package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.PaisDTO;
import co.com.app.patios.domain.Pais;

@Mapper
public interface PaisMapper {

	PaisMapper INSTANCE = Mappers.getMapper(PaisMapper.class);

	@Mapping (target = "departamentos", ignore = true)
	PaisDTO paisToPaisDTO(Pais pais);

	List<PaisDTO> paisToPaisDTOs(List<Pais> listPais);

}
