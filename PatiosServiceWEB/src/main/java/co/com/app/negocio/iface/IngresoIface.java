package co.com.app.negocio.iface;

import co.com.app.negocio.dto.UsuarioDTO;

public interface IngresoIface {

	public UsuarioDTO validarAutenticacion(String loginUsuario, String claveAcceso) throws Exception;

}
