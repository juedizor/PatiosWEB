package co.com.patios.mb.ingreso;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import co.com.patios.mb.util.MessagesEstaticos;
import co.com.patios.mb.util.Utilidades;

@ManagedBean(name = "validarSessionMB")
@RequestScoped
public class ValidarSessionMB {

	private HttpServletRequest httpServletRequestLogin;
	private HttpServletRequest httpServletRequestLoginError;
	private HttpServletRequest httpServletRequestLogOut;
	private final FacesContext context;
	private boolean noSession;
	private boolean logOut;

	public ValidarSessionMB() {
		context = FacesContext.getCurrentInstance();
		httpServletRequestLogin = (HttpServletRequest) context.getExternalContext().getRequest();
		httpServletRequestLoginError = (HttpServletRequest) context.getExternalContext().getRequest();
		httpServletRequestLogOut = (HttpServletRequest) context.getExternalContext().getRequest();
	}

	public void checkLogin(ComponentSystemEvent event) {
		if (httpServletRequestLogin.getSession().getAttribute("usuario") == null) {
			try {
				noSession = true;
				httpServletRequestLoginError.getSession().setAttribute("noSession", noSession);
				String ctxPath = ((ServletContext) context.getExternalContext().getContext()).getContextPath();
				context.getExternalContext().redirect(ctxPath + "/index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void verificarSessionNoDisponible(ComponentSystemEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		if (httpServletRequestLoginError.getSession().getAttribute("noSession") != null) {
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setDetail(MessagesEstaticos.getMensajeSessionNoExiste());
			message.setSummary(MessagesEstaticos.getMensajeCabeceraAlert());
			context.addMessage("", message);
			httpServletRequestLoginError.getSession().removeAttribute("noSession");
			setNoSession(false);
		}

		if (httpServletRequestLogOut.getSession().getAttribute("logOut") != null) {
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setDetail(MessagesEstaticos.getMensajeCierreSession());
			message.setSummary(MessagesEstaticos.getMensajeCabeceraInformacion());
			context.addMessage("", message);
			httpServletRequestLogOut.getSession().removeAttribute("logOut");
			setLogOut(false);
		}
	}

	/**
	 * remueve la sesion del usuario
	 */
	public void cerrarSession() {
		if (httpServletRequestLogin.getSession().getAttribute("usuario") != null) {
			try {
				httpServletRequestLogin.getSession().removeAttribute("usuario");
				Utilidades utilidades = new Utilidades();
				utilidades.removeSessionBean("ingresoMB");
				logOut = true;
				httpServletRequestLoginError.getSession().setAttribute("logOut", logOut);
				String ctxPath = ((ServletContext) context.getExternalContext().getContext()).getContextPath();
				context.getExternalContext().redirect(ctxPath + "/index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the noSession
	 */
	public boolean isNoSession() {
		return noSession;
	}

	/**
	 * @param noSession
	 *            the noSession to set
	 */
	public void setNoSession(boolean noSession) {
		this.noSession = noSession;
	}

	/**
	 * @return the logOut
	 */
	public boolean isLogOut() {
		return logOut;
	}

	/**
	 * @param logOut
	 *            the logOut to set
	 */
	public void setLogOut(boolean logOut) {
		this.logOut = logOut;
	}

}
