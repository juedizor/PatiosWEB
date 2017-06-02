package co.com.app.patios.repository;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.app.patios.domain.EntradaVehiculoPatio;

public interface EntradaVehiculoPatioIfaceDAO extends JpaRepository<EntradaVehiculoPatio, Integer> {

	/**
	 * realiza la consulta de la entrada del vehiculo teniendo en cuenta el
	 * id_vehiculo y el estado de la entrada al patio
	 * 
	 * @param idVehiculo
	 * @param estadoEntrada
	 * @return
	 */
	@Query("SELECT u FROM EntradaVehiculoPatio AS u WHERE u.vehiculo.idVehiculo = :idVehiculo "
			+ "AND u.estadoEntradaVehiculo = :estadoEntradaVehiculo")
	public EntradaVehiculoPatio consultarEntrada(@Param("idVehiculo") int idVehiculo,
			@Param("estadoEntradaVehiculo") String estadoEntradaVehiculo) throws PersistenceException;

	/**
	 * realiza la consulta de la entrada del vehiculo teniendo en cuenta el
	 * id_vehiculo, el estado de la entrada y el id del patio al patio
	 * 
	 * @param idVehiculo
	 * @param estadoEntrada
	 * @return
	 */
	@Query("SELECT u FROM EntradaVehiculoPatio AS u WHERE u.vehiculo.idVehiculo = :idVehiculo "
			+ "AND u.estadoEntradaVehiculo = :estadoEntradaVehiculo AND u.patio.idPatio = :idPatio")
	public EntradaVehiculoPatio consultarEntrada(@Param("idVehiculo") int idVehiculo,
			@Param("estadoEntradaVehiculo") String estadoEntradaVehiculo, @Param("idPatio") int idPatio)
			throws PersistenceException;

	/**
	 * realiza la consulta de la entrada del vehiculo teniendo en cuenta el
	 * estado de la entrada al patio
	 * 
	 * @param estadoEntrada
	 * @return
	 */
	@Query("SELECT u FROM EntradaVehiculoPatio AS u WHERE u.estadoEntradaVehiculo = :estadoEntradaVehiculo AND u.patio.idPatio = :idPatio")
	public List<EntradaVehiculoPatio> consultarEntrada(@Param("estadoEntradaVehiculo") String estadoEntradaVehiculo,
			@Param("idPatio") int idPatio) throws PersistenceException;

	/**
	 * realiza la consulta de una entrada a patios teniendo en cuenta la placa
	 * del vehiculo
	 * 
	 * @param placa
	 * @return
	 */
	@Query("SELECT u FROM EntradaVehiculoPatio AS u WHERE u.vehiculo.placaVehiculo = :placa")
	public EntradaVehiculoPatio consultarEntrada(@Param("placa") String placa) throws PersistenceException;

}
