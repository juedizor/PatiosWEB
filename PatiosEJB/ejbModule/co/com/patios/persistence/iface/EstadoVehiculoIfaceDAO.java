package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.EstadoVehiculo;

@Local
public interface EstadoVehiculoIfaceDAO {
	
	/**
     * consulta los estados de los vehiculos
     * @return
     */
	public List<EstadoVehiculo> consultarEstadosVehiculos();

}
