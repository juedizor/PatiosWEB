package co.com.app.patios.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.app.patios.domain.Persona;

public interface PersonaIfaceDAO extends JpaRepository<Persona, Integer> {

	/**
	 * realiza la consulta de la persona teniendo en cuenta su numero de
	 * identificacion
	 * 
	 * @param numeroIdentificacion
	 * @return
	 */
	@Query("SELECT p FROM Persona AS p WHERE p.tipoIdentificacion.idTipoIdentificacion = :tipoIdentificacion AND p.numeroIdentificacion = :numeroIdentificacion")
	public Persona consultarPesona(@Param("tipoIdentificacion") int tipoIdentificacion,
			@Param("numeroIdentificacion") BigDecimal numeroIdentificacion);

}
