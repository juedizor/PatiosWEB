package co.com.patios.negocio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.patios.entity.EntradaVehiculoPatio;
import co.com.patios.entity.Vehiculo;
import co.com.patios.negocio.iface.EntradaVehiculoPatiosIface;
import co.com.patios.negocio.mensajes.MessagesEstaticos;
import co.com.patios.negocio.parametros.EstadosEntradasPatios;
import co.com.patios.persistence.iface.EntradaVehiculoPatioIfaceDAO;
import co.com.patios.persistence.iface.VehiculoIfaceDAO;

@Stateless
public class EntradaVehiculosPatiosImpl implements EntradaVehiculoPatiosIface {

	@EJB
	VehiculoIfaceDAO vehiculoIfaceDAO;
	@EJB
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
		Vehiculo vehiculo = vehiculoIfaceDAO.consultarVehiculo(placa);
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
		if(!msgValidaEntrada.isEmpty()){
			throw new Exception(msgValidaEntrada);
		}
		
		
		
	}

}
