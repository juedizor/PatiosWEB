package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.TipoIdentificacionDTO;
import co.com.app.patios.domain.TipoIdentificacion;

@Mapper
public interface TipoIdentificacionMapper {

	TipoIdentificacionMapper INSTANCE = Mappers.getMapper(TipoIdentificacionMapper.class);

	TipoIdentificacionDTO tipoIdentificacionToTipoIdentificacionDTO(TipoIdentificacion tipoIdentificacion);

	List<TipoIdentificacionDTO> tipoIdentificacionToTipoIdentificacionDTOs(
			List<TipoIdentificacion> listTipoIdentificacion);

}
