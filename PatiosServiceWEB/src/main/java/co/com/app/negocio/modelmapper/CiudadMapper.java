package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.CiudadDTO;
import co.com.app.patios.domain.Ciudad;

@Mapper
public interface CiudadMapper {

	CiudadMapper INSTANCE = Mappers.getMapper(CiudadMapper.class);

	@Mappings({ @Mapping(target = "departamento", ignore = true) })
	CiudadDTO ciudadToCiudadDTO(Ciudad ciudad);

	List<CiudadDTO> ciudadsToCiudadDTOs(List<Ciudad> listCiudad);

}
