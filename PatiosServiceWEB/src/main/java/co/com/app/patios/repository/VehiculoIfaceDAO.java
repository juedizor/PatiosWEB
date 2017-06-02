package co.com.app.patios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.app.patios.domain.Vehiculo;

public interface VehiculoIfaceDAO extends JpaRepository<Vehiculo, Integer> {

	public Vehiculo findByPlacaVehiculo(String placa);

	public List<Vehiculo> findAll();

}
