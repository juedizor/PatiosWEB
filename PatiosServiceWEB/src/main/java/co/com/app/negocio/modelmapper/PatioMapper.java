package co.com.app.negocio.modelmapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.com.app.negocio.dto.PatioDTO;
import co.com.app.patios.domain.Patio;

import org.mapstruct.factory.Mappers;

@Mapper
public interface PatioMapper {

	PatioMapper INSTANCE = Mappers.getMapper(PatioMapper.class);

	@Mappings({ @Mapping(target = "entradaVehiculoPatios", ignore = true), @Mapping(target = "usuario", ignore = true),
			@Mapping(target = "usuarioPatios", ignore = true), @Mapping(target = "valorPatios", ignore = true) })
	PatioDTO patioToPatioDTO(Patio patio);

}
