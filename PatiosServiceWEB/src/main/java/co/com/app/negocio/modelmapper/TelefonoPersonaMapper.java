package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.TelefonoPersonaDTO;
import co.com.app.patios.domain.TelefonoPersona;

@Mapper(uses = { PersonaMapper.class })
public interface TelefonoPersonaMapper {

	TelefonoPersonaMapper INSTANCE = Mappers.getMapper(TelefonoPersonaMapper.class);

	TelefonoPersonaDTO telefonoPersonaToTelefonoPersonaDTO(TelefonoPersona telefonoPersona);

	List<TelefonoPersonaDTO> telefonosPersonaToTelefonosPersonaDTO(List<TelefonoPersona> listTelefonosPersona);

}
