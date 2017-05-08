package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.ColorVehiculo;

@Local
public interface ColorVehiculoIfaceDAO {
	
	public List<ColorVehiculo> consultarColoresVehiculo();

}
