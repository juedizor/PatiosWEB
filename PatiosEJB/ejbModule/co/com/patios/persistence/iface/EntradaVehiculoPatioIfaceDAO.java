package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.EntradaVehiculoPatio;

@Local
public interface EntradaVehiculoPatioIfaceDAO extends PersistenceIface<EntradaVehiculoPatio> {

	public List<EntradaVehiculoPatio> obtenerEntrada() throws PersistenceException;

	/**
	 * realiza la consulta de la entrada del vehiculo teniendo en cuenta el
	 * id_vehiculo y el estado de la entrada al patio
	 * 
	 * @param idVehiculo
	 * @param estadoEntrada
	 * @return
	 */
	public EntradaVehiculoPatio consultarEntrada(int idVehiculo, String estadoEntradaVehiculo)
			throws PersistenceException;

	/**
	 * realiza la consulta de la entrada del vehiculo teniendo en cuenta el
	 * id_vehiculo, el estado de la entrada y el id del patio al patio
	 * 
	 * @param idVehiculo
	 * @param estadoEntrada
	 * @return
	 */
	public EntradaVehiculoPatio consultarEntrada(int idVehiculo, String estadoEntradaVehiculo, int idPatio)
			throws PersistenceException;

	/**
	 * realiza la consulta de la entrada del vehiculo teniendo en cuenta el
	 * estado de la entrada al patio
	 * 
	 * @param estadoEntrada
	 * @return
	 */
	public List<EntradaVehiculoPatio> consultarEntrada(String estadoEntradaVehiculo, int idPatio)
			throws PersistenceException;

	/**
	 * realiza la consulta de una entrada a patios teniendo en cuenta la placa
	 * del vehiculo
	 * 
	 * @param placa
	 * @return
	 */
	public EntradaVehiculoPatio consultarEntrada(String placa) throws PersistenceException;

}
