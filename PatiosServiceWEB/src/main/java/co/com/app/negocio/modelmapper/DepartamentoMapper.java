package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.DepartamentoDTO;
import co.com.app.patios.domain.Departamento;

@Mapper
public interface DepartamentoMapper {

	DepartamentoMapper INSTANCE = Mappers.getMapper(DepartamentoMapper.class);

	@Mappings({ @Mapping(target = "ciudads", ignore = true), @Mapping(target = "pais", ignore = true) })
	DepartamentoDTO departamentoToDepartamentoDTO(Departamento departamento);

	List<DepartamentoDTO> departamentosToDepartamentoDTOs(List<Departamento> listDepartamento);

}
