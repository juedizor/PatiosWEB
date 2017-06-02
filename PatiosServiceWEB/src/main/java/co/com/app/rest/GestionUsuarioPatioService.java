package co.com.app.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.app.negocio.dto.UsuarioPatioDTO;
import co.com.app.negocio.general.iface.GestionUsuarioPatiosIface;
import co.com.app.rest.exception.CommonException;
import co.com.app.rest.exception.GeneralErrorException;

@RestController
@RequestMapping("/gestionUsuarioPatio")
public class GestionUsuarioPatioService {

	@Autowired
	GestionUsuarioPatiosIface gestionUsuarioPatiosIface;

	@RequestMapping(value = "/patiosUsuario/{idUsuario}/{fechaActual}", method = RequestMethod.GET)
	public List<UsuarioPatioDTO> getPatiosUsuario(@PathVariable("idUsuario") int idUsuario,
			@PathVariable("fechaActual") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaActual)
			throws CommonException {
		List<UsuarioPatioDTO> listUsuarioPatio;
		try {
			listUsuarioPatio = gestionUsuarioPatiosIface.consultarPatiosUsuario(idUsuario, fechaActual);
		} catch (Exception e) {
			throw new GeneralErrorException("Ocurrio un error " + e.getMessage());
		}

		return listUsuarioPatio;
	}

}
