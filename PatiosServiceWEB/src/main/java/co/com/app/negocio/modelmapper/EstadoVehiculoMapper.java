package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.EstadoVehiculoDTO;
import co.com.app.patios.domain.EstadoVehiculo;

@Mapper
public interface EstadoVehiculoMapper {

	EstadoVehiculoMapper INSTANCE = Mappers.getMapper(EstadoVehiculoMapper.class);

	EstadoVehiculoDTO estadoVehiculoToEstadoVehiculoDTO(EstadoVehiculo estadoVehiculo);

	List<EstadoVehiculoDTO> estadoVehiculosToEstadoVehiculoDTOs(List<EstadoVehiculo> listEstadoVehiculo);

}
