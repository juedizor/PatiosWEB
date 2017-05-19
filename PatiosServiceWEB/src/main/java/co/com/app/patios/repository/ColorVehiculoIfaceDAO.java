package co.com.app.patios.repository;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.app.patios.domain.ColorVehiculo;

public interface ColorVehiculoIfaceDAO extends JpaRepository<ColorVehiculo, Integer> {

	public List<ColorVehiculo> findAll() throws PersistenceException;

}
