package co.com.app.patios.repository;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.app.patios.domain.EstadoVehiculo;

public interface EstadoVehiculoIfaceDAO extends JpaRepository<EstadoVehiculo, Integer> {

	/**
	 * consulta los estados de los vehiculos
	 * 
	 * @return
	 */
	public List<EstadoVehiculo> findAll() throws PersistenceException;

}
