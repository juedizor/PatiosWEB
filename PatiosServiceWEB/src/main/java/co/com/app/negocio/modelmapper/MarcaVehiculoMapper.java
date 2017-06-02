package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.MarcaVehiculoDTO;
import co.com.app.patios.domain.MarcaVehiculo;

@Mapper
public interface MarcaVehiculoMapper {

	MarcaVehiculoMapper INSTANCE = Mappers.getMapper(MarcaVehiculoMapper.class);

	@Mapping(target = "modeloVehiculos", ignore = true)
	MarcaVehiculoDTO marcaVehiculoToMarcaVehiculoDTO(MarcaVehiculo marcaVehiculo);

	List<MarcaVehiculoDTO> marcasVehiculosToMarcaVehiculoDTOs(List<MarcaVehiculo> listMarcaVehiculo);

}
