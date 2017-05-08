package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.ModeloVehiculo;

@Local
public interface ModeloVehiculoIfaceDAO {
	
	
	public void editarModeloVehiculo(ModeloVehiculo modeloVehiculo);
	
	public List<ModeloVehiculo> consultarModelosVehiculos(int idMarca);
	public List<ModeloVehiculo> consultarModelosVehiculos(int idMarca, int idModelo);

}
