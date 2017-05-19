package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.ColorVehiculoDTO;
import co.com.app.patios.domain.ColorVehiculo;

@Mapper
public interface ColorVehiculoMapper {

	ColorVehiculoMapper INSTANCE = Mappers.getMapper(ColorVehiculoMapper.class);

	ColorVehiculoDTO colorVehiculoToColorVehiculoDTO(ColorVehiculo colorVehiculo);

	List<ColorVehiculoDTO> colorVehiculosToColorVehiculoDTOs(List<ColorVehiculo> listColorVehiculo);

}
