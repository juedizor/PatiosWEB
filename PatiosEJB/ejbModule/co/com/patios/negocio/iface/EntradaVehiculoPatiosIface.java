package co.com.patios.negocio.iface;

import javax.ejb.Local;

@Local
public interface EntradaVehiculoPatiosIface {

	/**
	 * 
	 * @param placa
	 * @return
	 * @throws Exception
	 */
	public String validarEntradaVehiculo(String placa) throws Exception;

}
