package co.com.patios.negocio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.patios.entity.Usuario;
import co.com.patios.negocio.iface.IngresoIface;
import co.com.patios.persistence.iface.UsuarioIfaceDAO;

@Stateless
public class IngresoImpl implements IngresoIface {

	@EJB
	UsuarioIfaceDAO usuaarioIfaceDAO;

	@Override
	public boolean ValidarAutenticacion(String loginUsuario, String claveAcceso) throws Exception {
		Usuario user = usuaarioIfaceDAO.buscarUsuario(loginUsuario, claveAcceso);
		if (user == null) {
			return false;
		}

		return true;
	}

}
