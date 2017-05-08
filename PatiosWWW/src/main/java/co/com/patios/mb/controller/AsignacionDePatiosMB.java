package co.com.patios.mb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import co.com.patios.ejb.controller.PatioEJB;
import co.com.patios.ejb.controller.UsuarioEJB;
import co.com.patios.ejb.controller.UsuarioPatioEJB;
import co.com.patios.ejb.controller.UtilidadesEJB;
import co.com.patios.entity.Patio;
import co.com.patios.entity.Usuario;
import co.com.patios.entity.UsuarioPatio;
import co.com.patios.mb.beanUtil.ReporteAsignacionUserPatios;
import co.com.patios.mb.util.MessagesEstaticos;


@ManagedBean (name = "asignacionDePatiosMB")
@ViewScoped
public class AsignacionDePatiosMB {
	
	
	private String idPatio;
	private String codigoPatio;
	private String nombrePatio;
	
	private UsuarioPatio usuarioPatio;
	private Patio patio;
	private ReporteAsignacionUserPatios reporteAsignacionUserPatios;
	
	private List<Usuario> listUsuario;
	private List<Usuario> listSeleccionUsuarios;
	private List<UsuarioPatio> listUsuarioPatio;
	private List<Usuario> listUsuariosNoAsignados;
	private List<Usuario> listUsuariosAsignados;
	private List<ReporteAsignacionUserPatios> listReporteAsigUserPatios;
	
	private HttpServletRequest httpServletRequestLogin;
	private final FacesContext context;
	
	@EJB
	PatioEJB patioEJB;
	@EJB
	UsuarioEJB usuarioEJB;
	@EJB 
	UsuarioPatioEJB usuarioPatioEJB;
	@EJB 
	UtilidadesEJB utilidadesEJB;
	
	
	
	public AsignacionDePatiosMB() {
		context = FacesContext.getCurrentInstance();
		httpServletRequestLogin  = (HttpServletRequest) context.getExternalContext().getRequest();
	}
	
	
	/**
	 * captura la fila seleccionada en la tabla de asignacion de patios a funcionarios
	 * @param idPatio
	 */
	public void capturarDatosPatiosAsignacion(int idPatio){
			patio = new Patio();
			patio = patioEJB.consultarPatio(idPatio);
			setIdPatio(patio.getIdPatio().toString());
			setCodigoPatio(patio.getCodigoPatio().toString());
			setNombrePatio(patio.getNombrePatio());
			//se captura la session del usuario
			Usuario usuarioSession = (Usuario) httpServletRequestLogin.getSession().getAttribute("usuario");
			int idUsuario = usuarioEJB.buscarUsuario(usuarioSession.getLoginUsuario()).getIdUsuario();
			setListUsuario(usuarioEJB.consultarUsuario(idUsuario));
	}
	
	
	/**
	 * obtiene el patio seleccionado
	 */
	private void obtenerPatio(){
		if(idPatio != null){
			patio = new Patio();
			patio = patioEJB.consultarPatio(Integer.parseInt(idPatio));
		}
	}
	
	/**
	 * valida si el funcionario esta vigente en el patio seleccionado
	 * @param idUsuario
	 * @return
	 */
	private boolean validarVigenciaUsuarioPatio(int idUsuario, int idPatio){
		listUsuarioPatio = usuarioPatioEJB.consultarVigenciaUsuarioPatio(idUsuario, idPatio);
		if(listUsuarioPatio != null && !listUsuarioPatio.isEmpty()){
			return true;
		}
		
		return false;
	}
	
	/**
	 * asigna el patio seleccionado a cada uno de los funcionarios seleccionados.
	 * En caso que el funcionario este vigente no realizara el proceso y continuara con los 
	 * siguientes registros. 
	 */
	public void asignarPatiosFuncionarios(){
		FacesMessage message = new FacesMessage();
		FacesContext context = FacesContext.getCurrentInstance();
		RequestContext requestContext = RequestContext.getCurrentInstance();
		obtenerPatio();
		int i = 0;
		Usuario usuarioSession = (Usuario) httpServletRequestLogin.getSession().getAttribute("usuario");
		usuarioSession = usuarioEJB.buscarUsuario(usuarioSession.getLoginUsuario());
		listUsuariosAsignados = new ArrayList<Usuario>();
		listUsuariosNoAsignados = new ArrayList<Usuario>();
		if(listSeleccionUsuarios != null && !listSeleccionUsuarios.isEmpty()){
			for (Usuario usuario : listSeleccionUsuarios) {
				if(!validarVigenciaUsuarioPatio(usuario.getIdUsuario(),Integer.parseInt(idPatio))){
					usuarioPatio = new UsuarioPatio();
					usuarioPatio.setPatio(getPatio());
					usuarioPatio.setUsuario1(usuario);
					usuarioPatio.setFechaInicio(utilidadesEJB.getFechaActual());
					usuarioPatio.setFechaProceso(utilidadesEJB.getFechaActual());
					usuarioPatio.setUsuario2(usuarioSession);
					usuarioPatioEJB.insertarUsuarioPatio(usuarioPatio);
					listUsuariosAsignados.add(usuario);
					i++;
				}else{
					listUsuariosNoAsignados.add(usuario);
				}
			}
			
			construirReporteAsignacion();
			
			if(i > 0){
				requestContext.execute("PF('dialogoAsignacion').hide();");
				requestContext.update("formAsignacion");
				requestContext.execute("PF('dialogoInformeAsignacion').show();");
				requestContext.update("formInformeAsignacion");
				listSeleccionUsuarios = null;
			}else{
				requestContext.execute("PF('dialogoAsignacion').hide();");
				requestContext.update("formAsignacion");
				requestContext.execute("PF('dialogoInformeAsignacion').show();");
				requestContext.update("formInformeAsignacion");
				listSeleccionUsuarios = null;
			}
			
		}else{
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setDetail(MessagesEstaticos.getMensajeNoSeleccion());
			message.setSummary(MessagesEstaticos.getMensajeCabeceraAlert());
			context.addMessage("", message);
		}
	}
	
	
	private void construirReporteAsignacion(){
		reporteAsignacionUserPatios = new ReporteAsignacionUserPatios();
		listReporteAsigUserPatios = new ArrayList<ReporteAsignacionUserPatios>();
		if(listUsuariosAsignados != null && !listUsuariosAsignados.isEmpty()){
			for (Usuario usuario : listUsuariosAsignados) {
				reporteAsignacionUserPatios = new ReporteAsignacionUserPatios();
				reporteAsignacionUserPatios.setUsuario(usuario);
				reporteAsignacionUserPatios.setMensajeReporte("Usuario Asignado exitosamente");
				listReporteAsigUserPatios.add(reporteAsignacionUserPatios);
			}
			
			
		}
		
		if(listUsuariosNoAsignados != null && !listUsuariosNoAsignados.isEmpty()){
			for (Usuario usuario : listUsuariosNoAsignados) {
				reporteAsignacionUserPatios = new ReporteAsignacionUserPatios();
				reporteAsignacionUserPatios.setUsuario(usuario);
				reporteAsignacionUserPatios.setMensajeReporte("Usuario se encuentra Asignado al patio");
				listReporteAsigUserPatios.add(reporteAsignacionUserPatios);
			}
		}
		
	}
	
	
	/**
	 * @return the idPatio
	 */
	public String getIdPatio() {
		return idPatio;
	}

	/**
	 * @param idPatio the idPatio to set
	 */
	public void setIdPatio(String idPatio) {
		this.idPatio = idPatio;
	}

	/**
	 * @return the codigoPatio
	 */
	public String getCodigoPatio() {
		return codigoPatio;
	}

	/**
	 * @param codigoPatio the codigoPatio to set
	 */
	public void setCodigoPatio(String codigoPatio) {
		this.codigoPatio = codigoPatio;
	}

	/**
	 * @return the patio
	 */
	public Patio getPatio() {
		return patio;
	}

	/**
	 * @param patio the patio to set
	 */
	public void setPatio(Patio patio) {
		this.patio = patio;
	}

	/**
	 * @return the nombrePatio
	 */
	public String getNombrePatio() {
		return nombrePatio;
	}

	/**
	 * @param nombrePatio the nombrePatio to set
	 */
	public void setNombrePatio(String nombrePatio) {
		this.nombrePatio = nombrePatio;
	}


	/**
	 * @return the listUsuario
	 */
	public List<Usuario> getListUsuario() {
		return listUsuario;
	}


	/**
	 * @param listUsuario the listUsuario to set
	 */
	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}


	/**
	 * @return the listSeleccionUsuarios
	 */
	public List<Usuario> getListSeleccionUsuarios() {
		return listSeleccionUsuarios;
	}


	/**
	 * @param listSeleccionUsuarios the listSeleccionUsuarios to set
	 */
	public void setListSeleccionUsuarios(List<Usuario> listSeleccionUsuarios) {
		this.listSeleccionUsuarios = listSeleccionUsuarios;
	}


	/**
	 * @return the usuarioPatio
	 */
	public UsuarioPatio getUsuarioPatio() {
		return usuarioPatio;
	}


	/**
	 * @param usuarioPatio the usuarioPatio to set
	 */
	public void setUsuarioPatio(UsuarioPatio usuarioPatio) {
		this.usuarioPatio = usuarioPatio;
	}


	/**
	 * @return the listUsuarioPatio
	 */
	public List<UsuarioPatio> getListUsuarioPatio() {
		return listUsuarioPatio;
	}


	/**
	 * @param listUsuarioPatio the listUsuarioPatio to set
	 */
	public void setListUsuarioPatio(List<UsuarioPatio> listUsuarioPatio) {
		this.listUsuarioPatio = listUsuarioPatio;
	}


	/**
	 * @return the listUsuariosNoAsignados
	 */
	public List<Usuario> getListUsuariosNoAsignados() {
		return listUsuariosNoAsignados;
	}


	/**
	 * @param listUsuariosNoAsignados the listUsuariosNoAsignados to set
	 */
	public void setListUsuariosNoAsignados(List<Usuario> listUsuariosNoAsignados) {
		this.listUsuariosNoAsignados = listUsuariosNoAsignados;
	}


	/**
	 * @return the listUsuariosAsignados
	 */
	public List<Usuario> getListUsuariosAsignados() {
		return listUsuariosAsignados;
	}


	/**
	 * @param listUsuariosAsignados the listUsuariosAsignados to set
	 */
	public void setListUsuariosAsignados(List<Usuario> listUsuariosAsignados) {
		this.listUsuariosAsignados = listUsuariosAsignados;
	}


	/**
	 * @return the reporteAsignacionUserPatios
	 */
	public ReporteAsignacionUserPatios getReporteAsignacionUserPatios() {
		return reporteAsignacionUserPatios;
	}


	/**
	 * @param reporteAsignacionUserPatios the reporteAsignacionUserPatios to set
	 */
	public void setReporteAsignacionUserPatios(
			ReporteAsignacionUserPatios reporteAsignacionUserPatios) {
		this.reporteAsignacionUserPatios = reporteAsignacionUserPatios;
	}


	/**
	 * @return the listReporteAsigUserPatios
	 */
	public List<ReporteAsignacionUserPatios> getListReporteAsigUserPatios() {
		return listReporteAsigUserPatios;
	}


	/**
	 * @param listReporteAsigUserPatios the listReporteAsigUserPatios to set
	 */
	public void setListReporteAsigUserPatios(
			List<ReporteAsignacionUserPatios> listReporteAsigUserPatios) {
		this.listReporteAsigUserPatios = listReporteAsigUserPatios;
	}




}
