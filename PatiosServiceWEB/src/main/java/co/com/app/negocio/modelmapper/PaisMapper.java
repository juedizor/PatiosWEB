package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.DepartamentosDTO;
import co.com.app.negocio.dto.PaisDTO;
import co.com.app.patios.domain.Departamento;
import co.com.app.patios.domain.Pais;

@Mapper
public interface PaisMapper {
	
	PaisMapper INSTANCE = Mappers.getMapper(PaisMapper.class);
	
	PaisDTO paisToPaisDTO(Pais pais);
	
	DepartamentosDTO departamentoToDepartamentoDTO(Departamento departamento);
	
	List<PaisDTO> paisToPaisDTOs(List<Pais> listPais);

}
