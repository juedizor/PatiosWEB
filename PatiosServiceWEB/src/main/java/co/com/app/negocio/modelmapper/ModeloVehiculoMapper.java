package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.com.app.negocio.dto.ModeloVehiculoDTO;
import co.com.app.patios.domain.ModeloVehiculo;

import org.mapstruct.factory.Mappers;

@Mapper
public interface ModeloVehiculoMapper {

	ModeloVehiculoMapper INSTANCE = Mappers.getMapper(ModeloVehiculoMapper.class);

	ModeloVehiculoDTO modeloVehiculoToModeloVehiculoDTO(ModeloVehiculo modeloVehiculo);

	List<ModeloVehiculoDTO> modeloVehiculosToModeloVehiculoDTOs(List<ModeloVehiculo> listModeloVehiculo);
}
