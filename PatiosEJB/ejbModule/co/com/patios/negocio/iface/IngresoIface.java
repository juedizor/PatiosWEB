package co.com.patios.negocio.iface;

import javax.ejb.Local;

import co.com.patios.entity.Usuario;

@Local
public interface IngresoIface {
	
	public Usuario ValidarAutenticacion(String loginUsuario, String claveAcceso) throws Exception;

}
