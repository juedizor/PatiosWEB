package co.com.app.patios.repository;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.app.patios.domain.MarcaVehiculo;

public interface MarcaVehiculoIfaceDAO extends JpaRepository<MarcaVehiculo, Integer> {

	public List<MarcaVehiculo> findAll();

	
	public List<MarcaVehiculo> findByIdMarcaVehiculo(int idMarca) throws PersistenceException;

}
