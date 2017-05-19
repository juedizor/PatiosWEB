package co.com.app.negocio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.app.negocio.dto.UsuarioDTO;
import co.com.app.negocio.iface.IngresoIface;
import co.com.app.negocio.modelmapper.UsuarioMapper;
import co.com.app.patios.domain.Usuario;
import co.com.app.patios.repository.UsuarioIfaceDAO;

@Service
public class IngresoImpl implements IngresoIface {

	@Autowired
	UsuarioIfaceDAO usuarioIfaceDAO;

	@Override
	@Transactional(value = "patiosTransactionManager")
	public UsuarioDTO validarAutenticacion(String loginUsuario, String claveAcceso) throws Exception {
		List<Usuario> listUsuario = usuarioIfaceDAO.findByLoginUsuarioAndClaveUsuario(loginUsuario, claveAcceso);
		if(listUsuario == null || listUsuario.isEmpty()){
			return null;
		}
		Usuario usuario = listUsuario.get(0);
		UsuarioDTO user = UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario);
		return user;
	}
}
