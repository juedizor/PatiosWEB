package co.com.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.app.negocio.dto.UsuarioDTO;
import co.com.app.negocio.iface.IngresoIface;

@RestController
public class PruebaServices {

	@Autowired
	IngresoIface ingresoIface;

	@RequestMapping(value = "/prueba", method = RequestMethod.GET)
	public UsuarioDTO prueba() {
		UsuarioDTO user = null;
		try {
			user = ingresoIface.ValidarAutenticacion("", "");
			user = ingresoIface.ValidarAutenticacion1("", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
