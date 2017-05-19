//package co.com.app.patios.repository;
//
//import java.util.List;
//
//import javax.persistence.PersistenceException;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import co.com.app.patios.domain.EntradaVehiculoPatio;
//
//public interface EntradaVehiculoPatioIfaceDAO extends JpaRepository<EntradaVehiculoPatio, Integer> {
//
//	public List<EntradaVehiculoPatio> obtenerEntrada() throws PersistenceException;
//
//	/**
//	 * realiza la consulta de la entrada del vehiculo teniendo en cuenta el
//	 * id_vehiculo y el estado de la entrada al patio
//	 * 
//	 * @param idVehiculo
//	 * @param estadoEntrada
//	 * @return
//	 */
//	public EntradaVehiculoPatio consultarEntrada(int idVehiculo, String estadoEntradaVehiculo)
//			throws PersistenceException;
//
//	/**
//	 * realiza la consulta de la entrada del vehiculo teniendo en cuenta el
//	 * id_vehiculo, el estado de la entrada y el id del patio al patio
//	 * 
//	 * @param idVehiculo
//	 * @param estadoEntrada
//	 * @return
//	 */
//	public EntradaVehiculoPatio consultarEntrada(int idVehiculo, String estadoEntradaVehiculo, int idPatio)
//			throws PersistenceException;
//
//	/**
//	 * realiza la consulta de la entrada del vehiculo teniendo en cuenta el
//	 * estado de la entrada al patio
//	 * 
//	 * @param estadoEntrada
//	 * @return
//	 */
//	public List<EntradaVehiculoPatio> consultarEntrada(String estadoEntradaVehiculo, int idPatio)
//			throws PersistenceException;
//
//	/**
//	 * realiza la consulta de una entrada a patios teniendo en cuenta la placa
//	 * del vehiculo
//	 * 
//	 * @param placa
//	 * @return
//	 */
//	public EntradaVehiculoPatio consultarEntrada(String placa) throws PersistenceException;
//
//}
