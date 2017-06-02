package co.com.patios.mb.ingreso;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;

import co.com.patios.mb.util.ParamsBundle;
import co.com.patios.mb.util.Utils;
import co.com.patios.service.client.ingreso.IngresoServiceClient;
import co.com.patios.service.dto.UsuarioDTO;

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

	/*
	 * Entity bean correspondiente al usuario
	 */
	private UsuarioDTO usuario;

	private String loginUsuario;
	private String password;

	/*
	 * variable para manejar los componentes de la vista que maneja el
	 * managedbean
	 */
	private UIComponent components;

	/*
	 * variable que crea la session de usuario, este lo crea con los datos de el
	 * bean usuario
	 */
	private HttpServletRequest httpServletRequest;

	/*
	 * constructor del MB
	 */
	public IngresoMB() throws Exception {
		/*
		 * se inicializa el entity bean
		 */
		usuario = new UsuarioDTO();
		ParamsBundle.getInstance().getEtiquetas(ParamsBundle.msg);
	}


	/**
	 * verifica el inicio de sesion de un usuario en el sistema
	 */
	public void verificarInicio() {
		/*
		 * captura el contexto del bean que se ejecuta, en este caso el bean
		 * IngresoMB.
		 */
		FacesContext context = FacesContext.getCurrentInstance();

		/*
		 * inicializa el contexto de los mensajes
		 */
		FacesMessage message = new FacesMessage();

		/*
		 * input es una variable de tipo UIInput, la cual se utiliza con el fin
		 * de buscar un componente especifico dentro de la pagina jsf o xhtml
		 */
		UIInput input = (UIInput) getComponents().findComponent("mensajes");

		/*
		 * idMessage, variable de tipo String en donde con la variable input se
		 * captura el id del componente que se buscó
		 */
		String idMessage = input.getClientId();

		/*
		 * valida que el usuario exista en el sistema, a traves del nombre de
		 * usuario y password
		 */
		try {
			usuario = IngresoServiceClient.getInstance().validarIngreso(loginUsuario, password);
		} catch (Exception e) {
			Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, idMessage,
					ParamsBundle.getInstance().getMapMensajes().get("cabecera_error"),
					ParamsBundle.getInstance().getMapMensajes().get("error_sistema"));
		}

		if (usuario != null) {
			try {
				/*
				 * usa el contexto actual y direcciona a la pagina (ruta
				 * correspondiente)
				 */
				context.getExternalContext().redirect("principal.xhtml");
			} catch (IOException e) {
				/*
				 * en caso de ocurrir error envia el mensaje a la vista actual
				 */
				Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, idMessage,
						ParamsBundle.getInstance().getMapMensajes().get("cabecera_error"),
						ParamsBundle.getInstance().getMapMensajes().get("error_sistema"));
			}

			/*
			 * usa la variable para mantener la sesion con los datos del entity
			 * usuario
			 */
			httpServletRequest = (HttpServletRequest) context.getExternalContext().getRequest();
			usuario.setClaveUsuario("");
			httpServletRequest.getSession().setAttribute("usuario", usuario);
		} else {
			/*
			 * si el usuario no existe limpia los campoos de la vista
			 */
			this.setLoginUsuario("");
			this.setPassword("");
			/*
			 * envia mensaje a la vista actual
			 */
			Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, idMessage,
					ParamsBundle.getInstance().getMapMensajes().get("cabecera_error"),
					ParamsBundle.getInstance().getMapMensajes().get("credenciales_erroneas"));
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
	public UsuarioDTO getUsuarioDTO() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuarioDTO(UsuarioDTO usuario) {
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
