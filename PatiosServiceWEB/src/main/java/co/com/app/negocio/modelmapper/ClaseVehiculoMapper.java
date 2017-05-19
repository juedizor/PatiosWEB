package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.ClaseVehiculoDTO;
import co.com.app.patios.domain.ClaseVehiculo;

@Mapper
public interface ClaseVehiculoMapper {

	ClaseVehiculoMapper INSTANCE = Mappers.getMapper(ClaseVehiculoMapper.class);

	ClaseVehiculoDTO claseVehiculoToClaseVehiculoDTO(ClaseVehiculo claseVehiculo);

	List<ClaseVehiculoDTO> claseVehiculosToClaseVehiculoDTOs(List<ClaseVehiculo> listClaseVehiculo);
}
