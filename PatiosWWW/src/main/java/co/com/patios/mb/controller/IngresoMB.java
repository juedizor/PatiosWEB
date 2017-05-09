package co.com.patios.mb.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;

import co.com.patios.appmain.InitParams;
import co.com.patios.entity.Usuario;
import co.com.patios.mb.util.Utils;
import co.com.patios.negocio.iface.IngresoIface;

/**
 * clase encargada de manejar el ingreso al sistema, es el managed bean que
 * controla el acceso a traves de un login de usuario y un password
 * 
 * @author jeio
 *
 */
@ManagedBean(name = "ingresoMB")
@SessionScoped
public class IngresoMB {

	private Usuario usuario;
	private String loginUsuario;
	private String password;

	// variable para manejar los componentes de la vista que maneja el managed
	// bean
	private UIComponent components;
	// variable que crea la session de usuario, este lo crea con los datos de el
	// bean usuario
	private HttpServletRequest httpServletRequest;

	public IngresoMB() {
		usuario = new Usuario();
	}

	@EJB
	IngresoIface ingresoIface;

	/**
	 * verifica el inicio de sesion de un usuario en el sistema
	 */
	public void verificarInicio() {
		usuario.setLoginUsuario(loginUsuario);
		usuario.setClaveUsuario(password);
		// captura el contexto del bean que se ejecuta, en este caso el bean
		// IngresoMB.
		FacesContext context = FacesContext.getCurrentInstance();
		// inicializa el contexto de los mensajes
		FacesMessage message = new FacesMessage();
		// input es una variable de tipo UIInput, la cual se utiliza con el fin
		// de buscar un componente especifico dentro de la
		// pagina jsf o xhtml
		UIInput input = (UIInput) getComponents().findComponent("mensajes");
		// idMessage, variable de tipo String en donde con la variable input se
		// captura el id del componente que se buscó
		String idMessage = input.getClientId();

		// valida que el usuario exista en el sistema, a traves del nombre de
		// usuario y password
		boolean existe = false;
		try {
			existe = ingresoIface.ValidarAutenticacion(this.usuario.getLoginUsuario(), this.usuario.getClaveUsuario());
		} catch (Exception e) {
			Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, idMessage,
					InitParams.MENSAJES_BUNDLE.CABECERA_ERROR, InitParams.MENSAJES_BUNDLE.ERROR_SISTEMA);
		}

		// valida que el usuario exista en el sistema
		if (existe) {
			try {
				context.getExternalContext().redirect("principal.xhtml");
			} catch (IOException e) {
				Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, idMessage,
						InitParams.MENSAJES_BUNDLE.CABECERA_ERROR, InitParams.MENSAJES_BUNDLE.ERROR_SISTEMA);
			}
			httpServletRequest = (HttpServletRequest) context.getExternalContext().getRequest();
			httpServletRequest.getSession().setAttribute("usuario", usuario);
		} else {
			this.setLoginUsuario("");
			this.setPassword("");
			Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, idMessage,
					InitParams.MENSAJES_BUNDLE.CABECERA_ERROR, InitParams.MENSAJES_BUNDLE.CREDENCIALES_ERRONEAS);
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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

	/**
	 * @return the loginUsuario
	 */
	public String getLoginUsuario() {
		return loginUsuario;
	}

	/**
	 * @param loginUsuario
	 *            the loginUsuario to set
	 */
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

}
