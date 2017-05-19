package co.com.app.patios.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.app.patios.domain.UsuarioPatio;

public interface UsuarioPatioIfaceDAO extends JpaRepository<UsuarioPatio, Integer> {

	/**
	 * obtiene los patios a los que esta autorizado un usuario
	 * 
	 * @param idUsuario
	 * @param fechaActual
	 * @return
	 */
	@Query("SELECT u FROM UsuarioPatio AS u WHERE u.usuario1.idUsuario = :idUsuario "
			+ "AND ((:fechaActual BETWEEN u.fechaInicio AND u.fechaFinal) OR (u.fechaFinal IS NULL))")
	public List<UsuarioPatio> consultarPatiosUsuario(@Param("idUsuario") int idUsuario,
			@Param("fechaActual") Date fechaActual) throws PersistenceException;

}
