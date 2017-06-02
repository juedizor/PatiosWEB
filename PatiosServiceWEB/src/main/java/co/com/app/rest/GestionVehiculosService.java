package co.com.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.app.negocio.dto.VehiculoDTO;
import co.com.app.negocio.general.iface.GestionVehiculosIface;
import co.com.app.rest.exception.CommonException;
import co.com.app.rest.exception.GeneralErrorException;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gestionVehiculos")
public class GestionVehiculosService {

	@Autowired
	GestionVehiculosIface gestionVehiculosIface;

	@RequestMapping(value = "/vehiculo/{placa}")
	public VehiculoDTO getVehiculo(@PathVariable("placa") String placa) throws CommonException {
		VehiculoDTO vehiculoDTO;
		try {
			vehiculoDTO = gestionVehiculosIface.consultarVehiculo(placa);
		} catch (Exception e) {
			throw new GeneralErrorException("Ocurrio un error " + e.getMessage());
		}

		return vehiculoDTO;
	}

}
