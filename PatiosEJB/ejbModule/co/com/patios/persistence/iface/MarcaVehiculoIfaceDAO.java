package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.MarcaVehiculo;

@Local
public interface MarcaVehiculoIfaceDAO {
	
	public void editarMarca(MarcaVehiculo marcaVehiculo);
	public List<MarcaVehiculo> consultarMarcas();
	public List<MarcaVehiculo> consultarMarcasVehiculos(int idMarca);

}
