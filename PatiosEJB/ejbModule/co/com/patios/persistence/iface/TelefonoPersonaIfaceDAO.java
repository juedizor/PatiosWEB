package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.TelefonoPersona;

@Local
public interface TelefonoPersonaIfaceDAO {

	/**
	 * realiza el insert a la tabla telefono_persona
	 * 
	 * @param telefonoPersona
	 */
	public void insertarTelefonoPersona(TelefonoPersona telefonoPersona);

	/**
	 * realiza la consulta de los telefonos asociados a una persoan
	 * 
	 * @param idPersona
	 * @return
	 */
	public List<TelefonoPersona> consultarTelefonoPersona(int idPersona);
}
