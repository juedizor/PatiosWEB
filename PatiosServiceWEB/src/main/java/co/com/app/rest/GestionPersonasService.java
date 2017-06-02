package co.com.app.rest;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.app.negocio.dto.PersonaDTO;
import co.com.app.negocio.general.iface.GestionPersonasIface;
import co.com.app.rest.exception.CommonException;
import co.com.app.rest.exception.GeneralErrorException;
import co.com.app.rest.exception.NotFoundException;

@RestController
@RequestMapping("/gestionPersonas")
public class GestionPersonasService {

	@Autowired
	GestionPersonasIface gestionPersonasIface;

	@RequestMapping(value = "/persona/{tipoDocumento}/{numDocumento}", method = RequestMethod.GET)
	public PersonaDTO getPersona(@PathVariable("tipoDocumento") int tipoDocumento,
			@PathVariable("numDocumento") BigDecimal numeroDocumento) throws CommonException {
		PersonaDTO personaDTO;
		try {
			personaDTO = gestionPersonasIface.consultarPersona(tipoDocumento, numeroDocumento);
		} catch (Exception e) {
			throw new GeneralErrorException("Ocurrio un error " + e.getMessage());
		}

		if (personaDTO == null) {
			throw new NotFoundException("No hay dato de persona con el tipo y numero de documento " + tipoDocumento
					+ " - " + numeroDocumento);
		}

		return personaDTO;

	}

}
