package co.com.app.negocio.modelmapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.VehiculoDTO;
import co.com.app.patios.domain.Vehiculo;

@Mapper
public interface VehiculoMapper {

	VehiculoMapper INSTANCE = Mappers.getMapper(VehiculoMapper.class);

	@Mappings({ @Mapping(target = "claseVehiculo", ignore = true), @Mapping(target = "colorVehiculo", ignore = true),
			@Mapping(target = "estadoVehiculo", ignore = true), @Mapping(target = "modeloVehiculo", ignore = true),
			@Mapping(target = "organismoTransito", ignore = true), @Mapping(target = "persona", ignore = true),
			@Mapping(target = "usuario", ignore = true) })
	VehiculoDTO vehiculoToVehiculoDTO(Vehiculo vehiculo);

}
