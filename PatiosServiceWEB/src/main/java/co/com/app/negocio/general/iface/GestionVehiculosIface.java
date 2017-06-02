package co.com.app.negocio.general.iface;

import co.com.app.negocio.dto.VehiculoDTO;

public interface GestionVehiculosIface {

	public VehiculoDTO consultarVehiculo(String placa) throws Exception;
}
