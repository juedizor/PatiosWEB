package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.ClaseVehiculo;

@Local
public interface ClaseVehiculoIfaceDAO {

	
	public List<ClaseVehiculo> consultarClaseVehiculos() throws PersistenceException;
	
	
}
