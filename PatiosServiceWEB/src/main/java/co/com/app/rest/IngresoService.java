package co.com.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.app.negocio.dto.UsuarioDTO;
import co.com.app.negocio.general.iface.IngresoIface;
import co.com.app.rest.exception.CommonException;
import co.com.app.rest.exception.GeneralErrorException;
import co.com.app.rest.exception.NotFoundException;

@RestController
@RequestMapping("/ingreso")
public class IngresoService {

	@Autowired
	IngresoIface ingresoIface;

	@RequestMapping(value = "/inicio", method = RequestMethod.POST)
	public UsuarioDTO iniciarSesion(@RequestHeader(value = "login") String login,
			@RequestHeader(value = "pass") String clave) throws CommonException {
		UsuarioDTO user;
		try {
			user = ingresoIface.validarAutenticacion(login, clave);
		} catch (Exception e) {
			throw new GeneralErrorException(
					"Ocurrio un error en el inicio de sesion: " + e.getMessage() + "\n" + e.getLocalizedMessage());
		}

		if (user == null) {
			throw new NotFoundException("Credenciales Erroneas");
		}

		return user;
	}

}
