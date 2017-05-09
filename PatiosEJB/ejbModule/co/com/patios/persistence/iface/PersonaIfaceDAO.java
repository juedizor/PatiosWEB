package co.com.patios.persistence.iface;

import java.math.BigDecimal;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.Persona;

@Local
public interface PersonaIfaceDAO extends PersistenceIface<Persona> {

	/**
	 * realiza la consulta de la persona teniendo en cuenta su numero de
	 * identificacion
	 * 
	 * @param numeroIdentificacion
	 * @return
	 */
	public Persona consultarPersona(BigDecimal numeroIdentificacion) throws PersistenceException;

}
