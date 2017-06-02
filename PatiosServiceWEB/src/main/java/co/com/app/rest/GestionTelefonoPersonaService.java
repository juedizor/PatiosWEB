package co.com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.app.negocio.dto.TelefonoPersonaDTO;
import co.com.app.negocio.general.iface.GestionTelefonosIface;
import co.com.app.rest.exception.CommonException;
import co.com.app.rest.exception.GeneralErrorException;

@RestController
public class GestionTelefonoPersonaService {

	@Autowired
	GestionTelefonosIface gestionTelefonosIface;

	@RequestMapping(value = "/telefonos/{idPersona}", method = RequestMethod.GET)
	public List<TelefonoPersonaDTO> getTelefonosPersona(@PathVariable("idPersona") int idPersona)
			throws CommonException {
		List<TelefonoPersonaDTO> listTel;
		try {
			listTel = gestionTelefonosIface.consultarTelefonos(idPersona);
		} catch (Exception e) {
			throw new GeneralErrorException("Ocurrio un error " + e.getMessage());
		}

		return listTel;
	}

}
