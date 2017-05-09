package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.ColorVehiculo;

@Local
public interface ColorVehiculoIfaceDAO extends PersistenceIface<ColorVehiculo> {

	public List<ColorVehiculo> consultarColoresVehiculo() throws PersistenceException;

}
