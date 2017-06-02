package co.com.app.negocio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.app.negocio.iface.EntradaVehiculoPatiosIface;
import co.com.app.negocio.mensajes.MessagesEstaticos;
import co.com.app.negocio.parametros.EstadosEntradasPatios;
import co.com.app.patios.domain.EntradaVehiculoPatio;
import co.com.app.patios.domain.Vehiculo;
import co.com.app.patios.repository.EntradaVehiculoPatioIfaceDAO;
import co.com.app.patios.repository.VehiculoIfaceDAO;

@Service
public class EntradaVehiculosPatiosImpl implements EntradaVehiculoPatiosIface {

	@Autowired
	VehiculoIfaceDAO vehiculoIfaceDAO;
	@Autowired
	EntradaVehiculoPatioIfaceDAO entradaVehiculoPatioIfaceDAO;

	/**
	 * verifica que el vehiculo no se encuentre actualmente ingresado en el
	 * sistema
	 * 
	 * @param placa
	 * @return
	 * @throws Exception
	 */
	@Override
	public String validarEntradaVehiculo(String placa) throws Exception {
		String vehiculoIngresado = "";
		Vehiculo vehiculo = vehiculoIfaceDAO.findByPlacaVehiculo(placa);
		if (vehiculo != null) {
			EntradaVehiculoPatio entradaVehiculoPatio = entradaVehiculoPatioIfaceDAO
					.consultarEntrada(vehiculo.getIdVehiculo(), EstadosEntradasPatios.INGRESADO);
			if (entradaVehiculoPatio != null) {
				vehiculoIngresado = String.format(MessagesEstaticos.getInstance().getMensajeVehiculoEstaEnPatio(),
						placa, entradaVehiculoPatio.getPatio().getNombrePatio());
			}
		}

		return vehiculoIngresado;
	}

	public void registrarEntradaVehiculoPatio(Vehiculo vehiculo) throws Exception {
		String msgValidaEntrada = validarEntradaVehiculo(vehiculo.getPlacaVehiculo());
		if (!msgValidaEntrada.isEmpty()) {
			throw new Exception(msgValidaEntrada);
		}

	}

}
