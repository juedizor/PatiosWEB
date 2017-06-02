package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.UsuarioPatioDTO;
import co.com.app.patios.domain.UsuarioPatio;

@Mapper
public interface UsuarioPatioMapper {

	UsuarioPatioMapper INSTANCE = Mappers.getMapper(UsuarioPatioMapper.class);

	@Mappings({ @Mapping(target = "patio", ignore = true), @Mapping(target = "usuario1", ignore = true),
			@Mapping(target = "usuario2", ignore = true) })
	UsuarioPatioDTO usuarioPatioToUsuarioPatioDTO(UsuarioPatio usuarioPatio);

	List<UsuarioPatioDTO> usuarioPatiosToUsuarioPatioDTOs(List<UsuarioPatio> listUsuarioPatio);

}
