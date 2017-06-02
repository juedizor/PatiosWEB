package co.com.app.negocio.general.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.app.negocio.dto.TelefonoPersonaDTO;
import co.com.app.negocio.general.iface.GestionTelefonosIface;
import co.com.app.negocio.modelmapper.TelefonoPersonaMapper;
import co.com.app.patios.domain.TelefonoPersona;
import co.com.app.patios.repository.TelefonoPersonaIfaceDAO;

@Service
public class GestionTelefonosImpl implements GestionTelefonosIface {

	@Autowired
	TelefonoPersonaIfaceDAO telefonoPersonaIfaceDAO;
	
	@Override
	public List<TelefonoPersonaDTO> consultarTelefonos(int idPersona) throws Exception {
		List<TelefonoPersona> listTelefonos = telefonoPersonaIfaceDAO.consultarTelefonoPersona(idPersona);
		List<TelefonoPersonaDTO> listTelefonoDTO = TelefonoPersonaMapper.INSTANCE.telefonosPersonaToTelefonosPersonaDTO(listTelefonos);
		return listTelefonoDTO;
	}

}
