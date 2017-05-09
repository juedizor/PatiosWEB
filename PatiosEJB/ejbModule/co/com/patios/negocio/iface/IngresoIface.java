package co.com.patios.negocio.iface;

import javax.ejb.Local;

@Local
public interface IngresoIface {
	
	public boolean ValidarAutenticacion(String loginUsuario, String claveAcceso) throws Exception;

}
