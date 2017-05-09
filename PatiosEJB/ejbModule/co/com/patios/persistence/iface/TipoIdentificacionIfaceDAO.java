package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.TipoIdentificacion;

@Local
public interface TipoIdentificacionIfaceDAO extends PersistenceIface<TipoIdentificacion> {

	/**
	 * lista todos los tipos de identificacion disponibles en el sistema
	 * 
	 * @return
	 */
	public List<TipoIdentificacion> consultarTiposIdentificacion() throws PersistenceException;

}
