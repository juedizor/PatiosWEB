package co.com.app.negocio.modelmapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.UsuarioDTO;
import co.com.app.patios.domain.Usuario;

@Mapper
public interface UsuarioMapper {

	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

	UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

}
