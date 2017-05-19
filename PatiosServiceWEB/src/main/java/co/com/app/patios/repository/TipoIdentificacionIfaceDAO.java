package co.com.app.patios.repository;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.app.patios.domain.TipoIdentificacion;

public interface TipoIdentificacionIfaceDAO extends JpaRepository<TipoIdentificacion, Integer> {

	/**
	 * lista todos los tipos de identificacion disponibles en el sistema
	 * 
	 * @return
	 */
	public List<TipoIdentificacion> findAll() throws PersistenceException;

}
