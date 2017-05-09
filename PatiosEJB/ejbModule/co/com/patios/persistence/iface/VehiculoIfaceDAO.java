package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.Vehiculo;

@Local
public interface VehiculoIfaceDAO extends PersistenceIface<Vehiculo> {

	public Vehiculo consultarVehiculo(String placa) throws PersistenceException;

	public List<Vehiculo> consultarVehiculos() throws PersistenceException;

}
