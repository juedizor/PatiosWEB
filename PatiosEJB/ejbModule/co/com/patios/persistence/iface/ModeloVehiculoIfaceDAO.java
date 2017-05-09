package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.ModeloVehiculo;

@Local
public interface ModeloVehiculoIfaceDAO extends PersistenceIface<ModeloVehiculo> {

	public List<ModeloVehiculo> consultarModelosVehiculos(int idMarca) throws PersistenceException;

	public List<ModeloVehiculo> consultarModelosVehiculos(int idMarca, int idModelo) throws PersistenceException;

}
