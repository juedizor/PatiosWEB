package co.com.patios.mb.ingreso;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import co.com.patios.service.dto.UsuarioDTO;

public class SesionUsuario {

	private static SesionUsuario instance;
	private HttpServletRequest httpServletRequestLogin;

	private SesionUsuario() {
		// TODO Auto-generated constructor stub
	}

	public static SesionUsuario getInstance() {
		if (instance == null) {
			instance = new SesionUsuario();
		}
		return instance;
	}

	/**
	 * 
	 * @param context,
	 *            faceContext usado en el momento que se quiere capturar la
	 *            sesion, en un MB se captura el contexto y se envia
	 * @param valueUsuario,
	 *            nombre de la sesion creada y la cual se quiere recuperar
	 * @return
	 */
	public UsuarioDTO getUsuarioSesion(FacesContext context, String valueUsuario) {
		httpServletRequestLogin = (HttpServletRequest) context.getExternalContext().getRequest();
		UsuarioDTO usuarioSession = (UsuarioDTO) httpServletRequestLogin.getSession().getAttribute(valueUsuario);
		return usuarioSession;
	}

}
