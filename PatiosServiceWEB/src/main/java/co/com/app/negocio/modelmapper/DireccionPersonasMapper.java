package co.com.app.negocio.modelmapper;

import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.DireccionPersonaDTO;
import co.com.app.patios.domain.DireccionPersona;

import org.mapstruct.Mapper;

@Mapper(uses = { PersonaMapper.class })
public interface DireccionPersonasMapper {

	DireccionPersonasMapper INSTANCE = Mappers.getMapper(DireccionPersonasMapper.class);

	DireccionPersonaDTO direccionPersonaToDireccionPersonaDTO(DireccionPersona direccionPersona);

}
