package co.com.patios.mb.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;

import co.com.patios.ejb.controller.PatioEJB;
import co.com.patios.ejb.controller.UsuarioEJB;
import co.com.patios.ejb.controller.UtilidadesEJB;
import co.com.patios.entity.Patio;
import co.com.patios.entity.Usuario;
import co.com.patios.mb.util.MessagesEstaticos;
import co.com.patios.mb.util.Utilidades;


@ManagedBean (name="patioMB")
@RequestScoped
public class PatioMB {
	
	
	private Patio patio;
	private String placa_veh;
	private java.util.Date fechaActualRegistro;
	private Usuario usuario;
	
	private String codigoPatio;
	private String nombrePatio;
	private String direccionPatio;
	private String telefonoPatio;
	private String capacidadPatio;
	
	private UIComponent components;
	
	
	// variables de captura de session
	private HttpServletRequest httpServletRequestLogin;
	private final FacesContext context;
	
	
	@EJB
	private PatioEJB patioEJB;
	@EJB
	private UtilidadesEJB utilidadesEJB;
	@EJB
	private UsuarioEJB usuarioEJB;
	
	
	
	public PatioMB() {
		patio = new Patio();
		context = FacesContext.getCurrentInstance();
		httpServletRequestLogin  = (HttpServletRequest) context.getExternalContext().getRequest();
		
	}


	
	/**
	 * realiza la conversion de los campos de la pagina registrarPatio.xhmtl en mayuscula, una vez sean 
	 * digitados los mismos
	 */
	public void convertMayuscula(){
		if(nombrePatio!=null){
			nombrePatio = Utilidades.convertirMayusculas(nombrePatio);
		}
		
		if(direccionPatio != null){
			direccionPatio = Utilidades.convertirMayusculas(direccionPatio);;
		}
		
	}
	
	public void mayuscula(){
		String textPlaca = this.getPlaca_veh();
		this.setPlaca_veh(textPlaca.toUpperCase());
	}
	
	
	/**
	 * realiza el insert de un patio al sistema
	 */
	public void insertPatio(){
		//se captura la session del usuario
		Usuario usuarioSession = (Usuario) httpServletRequestLogin.getSession().getAttribute("usuario");
		patio = patioEJB.consultarPatioPorCodigo(codigoPatio);
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if(patio == null){
			patio = new Patio();
			if(usuarioSession != null){
				setDatosPatios();
				fechaActualRegistro = utilidadesEJB.getFechaActual();
				patio.setFechaRegistroPatio(fechaActualRegistro);
				usuario = new Usuario();
				usuario.setIdUsuario(usuarioEJB.buscarUsuario(usuarioSession.getLoginUsuario()).getIdUsuario());
				patio.setUsuario(usuario);
				patioEJB.registrarPatios(patio);
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				message.setDetail(MessagesEstaticos.getRegistroExitoso());
				message.setSummary(MessagesEstaticos.getCabeceraRegistroExitoso());
				context.addMessage(null, message);
				limpiar();
			}else{
				try {
					context.getExternalContext().redirect("../index.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else{
			message.setSeverity(FacesMessage.SEVERITY_WARN);
			message.setDetail("Ya existe el patio:"+patio.getNombrePatio()+" con el codigo: "+codigoPatio);
			message.setSummary(MessagesEstaticos.getMensajeCabeceraAlert());
			context.addMessage(null, message);
		}
	}
	
	
	/**
	 * evento que se activa al momento de realizar el envio del formulario y captura todos los componentes de una pagina, 
	 * despues puedes ser usado para capturar el valor o el id del componente
	 * @param event
	 */
	public void setIdComponent(ComponentSystemEvent event){
		setComponents(event.getComponent());
	}
	
	/**
	 * limpia los registros
	 */
	public void limpiar(){
		setCapacidadPatio("");
		setCodigoPatio("");
		setDireccionPatio("");
		setNombrePatio("");
		setTelefonoPatio("");
	}
	
	/**
	 * set de datos de los patios
	 */
	public void setDatosPatios(){
		patio.setCapacidadPatio(Integer.parseInt(capacidadPatio));
		patio.setCodigoPatio(codigoPatio);
		patio.setDireccionPatio(direccionPatio);
		patio.setNombrePatio(nombrePatio);
		patio.setTelefonoPatio(telefonoPatio);
		
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
	 * @return the patioEJB
	 */
	public PatioEJB getPatioEJB() {
		return patioEJB;
	}


	/**
	 * @param patioEJB the patioEJB to set
	 */
	public void setPatioEJB(PatioEJB patioEJB) {
		this.patioEJB = patioEJB;
	}


	/**
	 * @return the placa_veh
	 */
	public String getPlaca_veh() {
		return placa_veh;
	}


	/**
	 * @param placa_veh the placa_veh to set
	 */
	public void setPlaca_veh(String placa_veh) {
		this.placa_veh = placa_veh;
	}


	/**
	 * @return the utilidadesEJB
	 */
	public UtilidadesEJB getUtilidadesEJB() {
		return utilidadesEJB;
	}



	/**
	 * @param utilidadesEJB the utilidadesEJB to set
	 */
	public void setUtilidadesEJB(UtilidadesEJB utilidadesEJB) {
		this.utilidadesEJB = utilidadesEJB;
	}





	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}



	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	/**
	 * @return the fechaActualRegistro
	 */
	public java.util.Date getFechaActualRegistro() {
		return fechaActualRegistro;
	}



	/**
	 * @param fechaActualRegistro the fechaActualRegistro to set
	 */
	public void setFechaActualRegistro(java.util.Date fechaActualRegistro) {
		this.fechaActualRegistro = fechaActualRegistro;
	}



	/**
	 * @return the usuarioEJB
	 */
	public UsuarioEJB getUsuarioEJB() {
		return usuarioEJB;
	}



	/**
	 * @param usuarioEJB the usuarioEJB to set
	 */
	public void setUsuarioEJB(UsuarioEJB usuarioEJB) {
		this.usuarioEJB = usuarioEJB;
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
	 * @return the direccionPatio
	 */
	public String getDireccionPatio() {
		return direccionPatio;
	}



	/**
	 * @param direccionPatio the direccionPatio to set
	 */
	public void setDireccionPatio(String direccionPatio) {
		this.direccionPatio = direccionPatio;
	}



	/**
	 * @return the telefonoPatio
	 */
	public String getTelefonoPatio() {
		return telefonoPatio;
	}



	/**
	 * @param telefonoPatio the telefonoPatio to set
	 */
	public void setTelefonoPatio(String telefonoPatio) {
		this.telefonoPatio = telefonoPatio;
	}



	/**
	 * @return the capacidadPatio
	 */
	public String getCapacidadPatio() {
		return capacidadPatio;
	}



	/**
	 * @param capacidadPatio the capacidadPatio to set
	 */
	public void setCapacidadPatio(String capacidadPatio) {
		this.capacidadPatio = capacidadPatio;
	}



	/**
	 * @return the components
	 */
	public UIComponent getComponents() {
		return components;
	}



	/**
	 * @param components the components to set
	 */
	public void setComponents(UIComponent components) {
		this.components = components;
	}



	

}
