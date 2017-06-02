package co.com.app.negocio.general.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.app.negocio.dto.PersonaDTO;
import co.com.app.negocio.general.iface.GestionPersonasIface;
import co.com.app.negocio.modelmapper.PersonaMapper;
import co.com.app.patios.domain.Persona;
import co.com.app.patios.repository.PersonaIfaceDAO;

@Service
public class GestionPersonasImpl implements GestionPersonasIface {

	@Autowired
	PersonaIfaceDAO personaIfaceDAO;
	
	@Override
	public PersonaDTO consultarPersona(int tipoIdentificacion, BigDecimal numeroDocumento) throws Exception {
		Persona persona = personaIfaceDAO.consultarPesona(tipoIdentificacion, numeroDocumento);
		PersonaDTO personaDTO = PersonaMapper.INSTANCE.personaToPersonaDTO(persona);
		return personaDTO;
	}

}
