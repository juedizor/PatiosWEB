package co.com.app.negocio.modelmapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.EntradaVehiculoPatioDTO;
import co.com.app.patios.domain.EntradaVehiculoPatio;

@Mapper(uses = { VehiculoMapper.class, UsuarioMapper.class, PatioMapper.class})
public interface EntradaVehiculoPatioMapper {

	EntradaVehiculoPatioMapper INSTANCE = Mappers.getMapper(EntradaVehiculoPatioMapper.class);

	EntradaVehiculoPatioDTO entradaVehiculoPatioToEntradaVehiculoPatioDTO(EntradaVehiculoPatio entradaVehiculoPatio);

}
