package co.com.patios.persistence.iface;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.UsuarioPatio;

@Local
public interface UsuarioPatioIfaceDAO extends PersistenceIface<UsuarioPatio> {

	/**
	 * obtiene los patios a los que esta autorizado un usuario
	 * 
	 * @param idUsuario
	 * @param fechaActual
	 * @return
	 */
	public List<UsuarioPatio> consultarPatiosUsuario(int idUsuario, Date fechaActual) throws PersistenceException;

}
