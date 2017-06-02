package co.com.app.patios.repository;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.app.patios.domain.TelefonoPersona;

public interface TelefonoPersonaIfaceDAO extends JpaRepository<TelefonoPersona, Integer> {

	/**
	 * realiza la consulta de los telefonos asociados a una persoan
	 * 
	 * @param idPersona
	 * @return
	 */
	@Query("SELECT u FROM TelefonoPersona AS u WHERE u.persona.idPersona = :idPersona")
	public List<TelefonoPersona> consultarTelefonoPersona(@Param("idPersona") int idPersona)
			throws PersistenceException;
}
