package co.com.app.negocio.modelmapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.JurisdiccionOrganismoTransitoDTO;
import co.com.app.patios.domain.JurisdiccionOrganismoTransito;

@Mapper(uses = { OrganismoTransitoMapper.class })
public interface JurisdiccionOrganismoTransitoMapper {

	JurisdiccionOrganismoTransitoMapper INSTANCE = Mappers.getMapper(JurisdiccionOrganismoTransitoMapper.class);

	JurisdiccionOrganismoTransitoDTO jurisdiccionOrganismoTransitoTojurisdiccionOrganismoTransitoDTO(
			JurisdiccionOrganismoTransito jurisdiccionOrganismoTransito);

}
