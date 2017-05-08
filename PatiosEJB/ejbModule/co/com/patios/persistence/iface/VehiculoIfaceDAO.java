package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.Vehiculo;

@Local
public interface VehiculoIfaceDAO {
	
	public void insertVehiculo(Vehiculo vehiculo);
	
	public void editarRegistroVehiculo(Vehiculo vehiculo);
	
	public Vehiculo consultarVehiculo(String placa);
	
	public Vehiculo consultarVehiculo(int idVehiculo);
	
	public List<Vehiculo> consultarVehiculos();

}
