//package co.com.patios.mb.util;
//
//import java.io.IOException;
//
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.context.FacesContext;
//
//
//
//
//
//import co.com.patios.ejb.controller.UsuarioEJB;
//import co.com.patios.entity.Usuario;
//import co.com.patios.mb.ingreso.IngresoMB;
//
//
//@ManagedBean (name = "activacionOpcionesMB")
//@RequestScoped
//public class ActivacionOpcionesMB {
//
//	private Usuario usuario;
//	
//	private boolean registrarPatio = false;
//	private boolean listarEntradas = false;
//	private boolean registrarVehiculo = false;
//	private boolean entradaPatios = false;
//	
//	
//	private static final int [] opcionEntradaPatios = {1,1};
//	private static final int [] opcionRegistroVehiculos = {1,2};
//	private static final int [] opcionListarEntradas = {1,3};
//	private static final int [] opcionRegistrarPatios = {1,4};
//	private static final int [] opcionGeneracionVolante = {1,5};
//	
//	
//	@EJB
//	UsuarioEJB usuarioEJB;
//	
//	
//	public void activarItemPermisos() throws IOException {
//		FacesContext context = FacesContext.getCurrentInstance();
//		IngresoMB ingresoMB = Utilidades.sessionUsuario();
//		
//		if(ingresoMB == null){
//			context.getExternalContext().redirect("../../index.xhtml");
//		}else{
//			usuario = new Usuario();
//			usuario.setIdentificacionUsuario(usuarioEJB.buscarUsuario(ingresoMB.getUsuario().getIdentificacionUsuario()).getIdUsuario());
//		}
//	}
//
//	/**
//	 * @return the usuario
//	 */
//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//
//
//	/**
//	 * @param usuario the usuario to set
//	 */
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
//
//
//
//	/**
//	 * @return the registrarPatio
//	 */
//	public boolean isRegistrarPatio() {
//		return registrarPatio;
//	}
//
//
//
//	/**
//	 * @param registrarPatio the registrarPatio to set
//	 */
//	public void setRegistrarPatio(boolean registrarPatio) {
//		this.registrarPatio = registrarPatio;
//	}
//
//
//
//	/**
//	 * @return the listarEntradas
//	 */
//	public boolean isListarEntradas() {
//		return listarEntradas;
//	}
//
//
//
//	/**
//	 * @param listarEntradas the listarEntradas to set
//	 */
//	public void setListarEntradas(boolean listarEntradas) {
//		this.listarEntradas = listarEntradas;
//	}
//
//
//
//	/**
//	 * @return the registrarVehiculo
//	 */
//	public boolean isRegistrarVehiculo() {
//		return registrarVehiculo;
//	}
//
//
//
//	/**
//	 * @param registrarVehiculo the registrarVehiculo to set
//	 */
//	public void setRegistrarVehiculo(boolean registrarVehiculo) {
//		this.registrarVehiculo = registrarVehiculo;
//	}
//
//
//
//	/**
//	 * @return the entradaPatios
//	 */
//	public boolean isEntradaPatios() {
//		return entradaPatios;
//	}
//
//
//
//	/**
//	 * @param entradaPatios the entradaPatios to set
//	 */
//	public void setEntradaPatios(boolean entradaPatios) {
//		this.entradaPatios = entradaPatios;
//	}
//	
//	
//}
