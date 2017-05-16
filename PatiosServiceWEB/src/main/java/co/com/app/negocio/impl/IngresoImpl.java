package co.com.app.negocio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.app.negocio.dto.UsuarioDTO;
import co.com.app.negocio.iface.IngresoIface;
import co.com.app.patios.domain.Usuario;
import co.com.app.patios.repository.UsuarioIfaceDAO;
import co.com.app.prueba.domain.Test;
import co.com.app.prueba.repository.TestIfaceDAO;

@Service
public class IngresoImpl implements IngresoIface {

	@Autowired
	UsuarioIfaceDAO usuarioIfaceDAO;
	@Autowired
	TestIfaceDAO testIfaceDAO;

	@SuppressWarnings("unused")
	@Override
	@Transactional(value = "patiosTransactionManager")
	public UsuarioDTO ValidarAutenticacion(String loginUsuario, String claveAcceso) throws Exception {
		List<Usuario> usuario = usuarioIfaceDAO.findAll();
		UsuarioDTO user = new UsuarioDTO();
		user.setLoginUsuario("julioizq");
		return user;
	}
	
	@SuppressWarnings("unused")
	@Override
	@Transactional(value = "pruebaTransactionManager")
	public UsuarioDTO ValidarAutenticacion1(String loginUsuario, String claveAcceso) throws Exception {
		List<Test> tes = testIfaceDAO.findAll();
		UsuarioDTO user = new UsuarioDTO();
		user.setLoginUsuario("julioizq");
		return user;
	}
}
