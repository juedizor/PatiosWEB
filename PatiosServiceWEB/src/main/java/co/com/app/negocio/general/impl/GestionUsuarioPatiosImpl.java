package co.com.app.negocio.general.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.app.negocio.dto.PatioDTO;
import co.com.app.negocio.dto.UsuarioPatioDTO;
import co.com.app.negocio.general.iface.GestionUsuarioPatiosIface;
import co.com.app.negocio.modelmapper.PatioMapper;
import co.com.app.negocio.modelmapper.UsuarioPatioMapper;
import co.com.app.patios.domain.Patio;
import co.com.app.patios.domain.UsuarioPatio;
import co.com.app.patios.repository.UsuarioPatioIfaceDAO;

@Service
public class GestionUsuarioPatiosImpl implements GestionUsuarioPatiosIface {

	@Autowired
	UsuarioPatioIfaceDAO usuarioPatioIfaceDAO;

	@Override
	public List<UsuarioPatioDTO> consultarPatiosUsuario(int idUsuario, Date fechaActual) throws Exception {
		List<UsuarioPatio> listUsuarioPatio = usuarioPatioIfaceDAO.consultarPatiosUsuario(idUsuario, fechaActual);
		if (listUsuarioPatio != null && !listUsuarioPatio.isEmpty()) {
			List<UsuarioPatioDTO> listUsuarioPatioDTO = UsuarioPatioMapper.INSTANCE
					.usuarioPatiosToUsuarioPatioDTOs(listUsuarioPatio);
			int i = 0;
			for (UsuarioPatio usuarioPatio : listUsuarioPatio) {
				Patio patio = usuarioPatio.getPatio();
				PatioDTO patioDTO = PatioMapper.INSTANCE.patioToPatioDTO(patio);
				listUsuarioPatioDTO.get(i).setPatio(patioDTO);
				i++;
			}

			return listUsuarioPatioDTO;

		}

		return null;
	}

}
