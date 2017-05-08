package co.com.patios.mb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import co.com.patios.ejb.controller.EntradaVehiculoPatioEJB;
import co.com.patios.ejb.controller.UsuarioEJB;
import co.com.patios.ejb.controller.UsuarioPatioEJB;
import co.com.patios.ejb.controller.UtilidadesEJB;
import co.com.patios.entity.EntradaVehiculoPatio;
import co.com.patios.entity.Usuario;
import co.com.patios.entity.UsuarioPatio;


@ManagedBean(name = "entradasVehiculosMB")
@RequestScoped
public class EntradasVehiculosMB {
	
	private UsuarioPatio usuarioPatio;
	private List<EntradaVehiculoPatio> entradaVehiculos;
	private boolean mostraOpcionReporte = false;
	
	
	private HttpServletRequest httpServletRequestLogin;
	private final FacesContext context;
	
	@EJB 
	EntradaVehiculoPatioEJB entradaVehiculoPatioEJB;
	@EJB
	UsuarioPatioEJB usuarioPatioEJB;
	@EJB 
	UsuarioEJB usuarioEJB;
	@EJB
	UtilidadesEJB utilidadesEJB;
	
	public EntradasVehiculosMB() {
			context = FacesContext.getCurrentInstance();
			httpServletRequestLogin  = (HttpServletRequest) context.getExternalContext().getRequest();
	}
	
	@PostConstruct
	public void tablaVehiculos(){
		listarEntradasVehiculos();
		this.setEntradaVehiculos(entradaVehiculos);
	}

	/**
	 * realiza la consulta de entradas de vehiculos en estado Insertado a los patios asociados al usuario que este en sesion 
	 */
	public void listarEntradasVehiculos(){
		Usuario usuario = (Usuario) httpServletRequestLogin.getSession().getAttribute("usuario");
		int idUsuario = usuarioEJB.buscarUsuario(usuario.getLoginUsuario()).getIdUsuario();
		Date dateActual = utilidadesEJB.getFechaActual();
		List<UsuarioPatio> listUsuarioPatios =  usuarioPatioEJB.consultarPatioUsuario(idUsuario, dateActual);
		List<EntradaVehiculoPatio> listEntradaVehiculoPatio;
		entradaVehiculos = new ArrayList<EntradaVehiculoPatio>();
		if(listUsuarioPatios != null && !listUsuarioPatios.isEmpty()){
			for (UsuarioPatio usuarioPatio : listUsuarioPatios) {
				listEntradaVehiculoPatio = entradaVehiculoPatioEJB.consultarEntradaVehiculoPorEstado("I", usuarioPatio.getPatio().getIdPatio());
				if(listEntradaVehiculoPatio != null && !listEntradaVehiculoPatio.isEmpty()){
					for (EntradaVehiculoPatio entradaVehiculoPatio : listEntradaVehiculoPatio) {
						entradaVehiculos.add(entradaVehiculoPatio);
					}
					
				}
				
			}
		}
		
		if(entradaVehiculos != null && !entradaVehiculos.isEmpty()){
			mostraOpcionReporte = true;
		}
	}
	
	/**
	 * @return the entradaVehiculos
	 */
	public List<EntradaVehiculoPatio> getEntradaVehiculos() {
		return entradaVehiculos;
	}

	/**
	 * @param entradaVehiculos the entradaVehiculos to set
	 */
	public void setEntradaVehiculos(List<EntradaVehiculoPatio> entradaVehiculos) {
		this.entradaVehiculos = entradaVehiculos;
	}

	/**
	 * @return the entradaVehiculoPatioEJB
	 */
	public EntradaVehiculoPatioEJB getEntradaVehiculoPatioEJB() {
		return entradaVehiculoPatioEJB;
	}

	/**
	 * @param entradaVehiculoPatioEJB the entradaVehiculoPatioEJB to set
	 */
	public void setEntradaVehiculoPatioEJB(
			EntradaVehiculoPatioEJB entradaVehiculoPatioEJB) {
		this.entradaVehiculoPatioEJB = entradaVehiculoPatioEJB;
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
	 * @return the mostraOpcionReporte
	 */
	public boolean isMostraOpcionReporte() {
		return mostraOpcionReporte;
	}

	/**
	 * @param mostraOpcionReporte the mostraOpcionReporte to set
	 */
	public void setMostraOpcionReporte(boolean mostraOpcionReporte) {
		this.mostraOpcionReporte = mostraOpcionReporte;
	}
	

}