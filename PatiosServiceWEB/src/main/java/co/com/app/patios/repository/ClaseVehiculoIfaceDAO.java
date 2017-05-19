package co.com.app.patios.repository;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.app.patios.domain.ClaseVehiculo;

public interface ClaseVehiculoIfaceDAO extends JpaRepository<ClaseVehiculo, Integer>{

	
	public List<ClaseVehiculo> findAll() throws PersistenceException;
	
	
}
