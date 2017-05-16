package co.com.app.negocio.iface;

import co.com.app.negocio.dto.UsuarioDTO;

public interface IngresoIface {

	public UsuarioDTO ValidarAutenticacion(String loginUsuario, String claveAcceso) throws Exception;
	
	public UsuarioDTO ValidarAutenticacion1(String loginUsuario, String claveAcceso) throws Exception;

}
