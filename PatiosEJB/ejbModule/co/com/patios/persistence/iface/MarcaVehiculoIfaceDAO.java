package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.MarcaVehiculo;

@Local
public interface MarcaVehiculoIfaceDAO extends PersistenceIface<MarcaVehiculo> {

	public List<MarcaVehiculo> consultarMarcas() throws PersistenceException;

	public List<MarcaVehiculo> consultarMarcasVehiculos(int idMarca) throws PersistenceException;

}
