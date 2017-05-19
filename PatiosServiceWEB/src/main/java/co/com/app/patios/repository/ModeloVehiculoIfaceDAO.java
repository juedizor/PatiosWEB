package co.com.app.patios.repository;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.app.patios.domain.ModeloVehiculo;

public interface ModeloVehiculoIfaceDAO extends JpaRepository<ModeloVehiculo, Integer> {

	@Query("SELECT u FROM ModeloVehiculo u WHERE u.marcaVehiculo.idMarcaVehiculo=:idMarca")
	public List<ModeloVehiculo> findByIdMarca(@Param("idMarca") int idMarca) throws PersistenceException;

	@Query("SELECT u FROM ModeloVehiculo AS u WHERE u.marcaVehiculo.idMarcaVehiculo=:idMarca "
			+ "AND u.idModeloVehiculo NOT IN (:idModelo)")
	public List<ModeloVehiculo> consultarModelosVehiculos(@Param("idMarca") int idMarca,
			@Param("idModelo") int idModelo) throws PersistenceException;

}
