package co.com.app.negocio.modelmapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.TipoMenuDTO;
import co.com.app.patios.domain.TipoMenu;

@Mapper
public interface TipoMenuMapper {

	TipoMenuMapper INSTANCE = Mappers.getMapper(TipoMenuMapper.class);

	TipoMenuDTO tipoMenuToTipoMenuDTO(TipoMenu tipoMenu);

}
