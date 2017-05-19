package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.MarcaVehiculoDTO;
import co.com.app.negocio.dto.ModeloVehiculoDTO;
import co.com.app.patios.domain.MarcaVehiculo;
import co.com.app.patios.domain.ModeloVehiculo;

@Mapper
public interface MarcaVehiculoMapper {
	
	MarcaVehiculoMapper INSTANCE = Mappers.getMapper(MarcaVehiculoMapper.class);
	
	MarcaVehiculoDTO marcaVehiculoToMarcaVehiculoDTO(MarcaVehiculo marcaVehiculo);
	
	ModeloVehiculoDTO modeloVehiculoToModeloVehiculoDTO(ModeloVehiculo modeloVehiculo);
	
	List<MarcaVehiculoDTO> marcasVehiculosToMarcaVehiculoDTOs(List<MarcaVehiculo> listMarcaVehiculo);

}
