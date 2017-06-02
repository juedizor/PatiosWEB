package co.com.app.negocio.modelmapper;

import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.ValorPatioDTO;
import co.com.app.patios.domain.ValorPatio;

import org.mapstruct.Mapper;

@Mapper(uses = { PatioMapper.class, ClaseVehiculoMapper.class })
public interface ValorPatiosMapper {

	ValorPatiosMapper INSTANCE = Mappers.getMapper(ValorPatiosMapper.class);

	ValorPatioDTO valorPatioToValorPatioDTO(ValorPatio valorPatio);

}
