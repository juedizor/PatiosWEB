package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.TelefonoPersona;

@Local
public interface TelefonoPersonaIfaceDAO extends PersistenceIface<TelefonoPersona> {

	/**
	 * realiza la consulta de los telefonos asociados a una persoan
	 * 
	 * @param idPersona
	 * @return
	 */
	public List<TelefonoPersona> consultarTelefonoPersona(int idPersona) throws PersistenceException;
}
