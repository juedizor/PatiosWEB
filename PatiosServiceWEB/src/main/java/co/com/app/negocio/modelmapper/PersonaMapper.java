package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.PersonaDTO;
import co.com.app.patios.domain.Persona;

@Mapper
public interface PersonaMapper {

	PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

	@Mappings({ @Mapping(target = "direccionPersonas", ignore = true), @Mapping(target = "ciudad", ignore = true),
			@Mapping(target = "tipoIdentificacion", ignore = true),
			@Mapping(target = "telefonoPersonas", ignore = true), @Mapping(target = "usuarios", ignore = true),
			@Mapping(target = "vehiculos", ignore = true) })
	PersonaDTO personaToPersonaDTO(Persona persona);

	List<PersonaDTO> personasToPersonaDTOs(List<Persona> listPersonas);

}
