package co.com.patios.mb.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import co.com.patios.ejb.controller.PatioEJB;
import co.com.patios.ejb.controller.UsuarioEJB;
import co.com.patios.ejb.controller.UtilidadesEJB;
import co.com.patios.entity.Patio;
import co.com.patios.entity.Usuario;
import co.com.patios.mb.ingreso.SesionUsuario;
import co.com.patios.mb.util.ParamsBundle;
import co.com.patios.mb.util.MessagesEstaticos;
import co.com.patios.mb.util.Utilidades;
import co.com.patios.mb.util.Utils;
import co.com.patios.negocio.iface.RegistrarPatiosIface;
import co.com.patios.service.dto.UsuarioDTO;

@ManagedBean(name = "patioMB")
@RequestScoped
public class PatioMB {

	/*
	 * entity bean de patios
	 */
	private Patio patio;
	/*
	 * Entity bean del usuario
	 */
	private Usuario usuario;

	private java.util.Date fechaActualRegistro;

	private String codigoPatio;
	private String nombrePatio;
	private String direccionPatio;
	private String telefonoPatio;
	private String capacidadPatio;

	private UIComponent components;

	@EJB
	private PatioEJB patioEJB;
	@EJB
	private UtilidadesEJB utilidadesEJB;
	@EJB
	private UsuarioEJB usuarioEJB;

	@EJB
	RegistrarPatiosIface registrarPatiosIface;

	public PatioMB() {
		patio = new Patio();
	}

	public void nombrePatioMayuscula() {
		if (nombrePatio != null) {
			nombrePatio = Utilidades.convertirMayusculas(nombrePatio);
		}
	}

	public void direccionPatioMayuscula() {
		if (direccionPatio != null) {
			direccionPatio = Utilidades.convertirMayusculas(direccionPatio);
		}

	}

	/**
	 * realiza el insert de un patio al sistema
	 */
	public void insertPatio() {
		/*
		 * contexto de actual
		 */
		FacesContext context = FacesContext.getCurrentInstance();

		/*
		 * inicializacion para manejo de mensajes hacia la vista
		 */
		FacesMessage message = new FacesMessage();

		/*
		 * se captura la session del usuario
		 */
		UsuarioDTO usuarioSession = SesionUsuario.getInstance().getUsuarioSesion(context, "usuario");
		if (usuarioSession == null) {
			try {
				context.getExternalContext().redirect("../index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}

		/*
		 * captura de todos los datos asociados al formulario
		 */
		try {
			usuario = new Usuario();
			usuario.setIdUsuario(usuarioSession.getIdUsuario());
			setDatosPatios();
			patio = registrarPatiosIface.realizarRegistroPatio(patio);
		} catch (Exception e) {
			Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, null, e.getMessage(),
					ParamsBundle.getInstance().getMapMensajes().get("cabecera_error"));
			return;
		}

		if (patio != null) {
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setDetail(MessagesEstaticos.getRegistroExitoso());
			message.setSummary(MessagesEstaticos.getCabeceraRegistroExitoso());
			context.addMessage(null, message);
			limpiar();
		}

	}

	/**
	 * evento que se activa al momento de realizar el envio del formulario y
	 * captura todos los componentes de una pagina, despues puedes ser usado
	 * para capturar el valor o el id del componente
	 * 
	 * @param event
	 */
	public void setIdComponent(ComponentSystemEvent event) {
		setComponents(event.getComponent());
	}

	/**
	 * limpia los registros
	 */
	public void limpiar() {
		setCapacidadPatio("");
		setCodigoPatio("");
		setDireccionPatio("");
		setNombrePatio("");
		setTelefonoPatio("");
	}

	/**
	 * set de datos de los patios
	 */
	public void setDatosPatios() {
		patio = new Patio();
		patio.setUsuario(usuario);
		fechaActualRegistro = utilidadesEJB.getFechaActual();
		patio.setFechaRegistroPatio(fechaActualRegistro);
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
	 * @param patio
	 *            the patio to set
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
	 * @param patioEJB
	 *            the patioEJB to set
	 */
	public void setPatioEJB(PatioEJB patioEJB) {
		this.patioEJB = patioEJB;
	}

	/**
	 * @return the utilidadesEJB
	 */
	public UtilidadesEJB getUtilidadesEJB() {
		return utilidadesEJB;
	}

	/**
	 * @param utilidadesEJB
	 *            the utilidadesEJB to set
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
	 * @param usuario
	 *            the usuario to set
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
	 * @param fechaActualRegistro
	 *            the fechaActualRegistro to set
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
	 * @param usuarioEJB
	 *            the usuarioEJB to set
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
	 * @param codigoPatio
	 *            the codigoPatio to set
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
	 * @param nombrePatio
	 *            the nombrePatio to set
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
	 * @param direccionPatio
	 *            the direccionPatio to set
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
	 * @param telefonoPatio
	 *            the telefonoPatio to set
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
	 * @param capacidadPatio
	 *            the capacidadPatio to set
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
	 * @param components
	 *            the components to set
	 */
	public void setComponents(UIComponent components) {
		this.components = components;
	}

}
