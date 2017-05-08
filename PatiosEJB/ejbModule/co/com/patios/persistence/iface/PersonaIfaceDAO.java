package co.com.patios.persistence.iface;

import java.math.BigDecimal;

import javax.ejb.Local;

import co.com.patios.entity.Persona;

@Local
public interface PersonaIfaceDAO {

	/**
	 * realiza el insert de la persona
	 * 
	 * @param persona,
	 *            objeto tipo persona con los datos del registro
	 */
	public void registrarPersona(Persona persona);

	/**
	 * realiza la consulta de la persona teniendo en cuenta su numero de
	 * identificacion
	 * 
	 * @param numeroIdentificacion
	 * @return
	 */
	public Persona consultarPersona(BigDecimal numeroIdentificacion);

}
