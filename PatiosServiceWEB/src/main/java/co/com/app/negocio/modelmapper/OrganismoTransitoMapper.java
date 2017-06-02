package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.OrganismoTransitoDTO;
import co.com.app.patios.domain.OrganismoTransito;

@Mapper
public interface OrganismoTransitoMapper {

	OrganismoTransitoMapper INSTANCE = Mappers.getMapper(OrganismoTransitoMapper.class);

	@Mappings({ @Mapping(target = "categoriaOrganismoTransito", ignore = true),
			@Mapping(target = "ciudad", ignore = true),
			@Mapping(target = "jurisdiccionOrganismoTransito", ignore = true),
			@Mapping(target = "usuario", ignore = true) })
	OrganismoTransitoDTO organismoTransitoToOrganismoTransitoDTO(OrganismoTransito organismoTransito);

	List<OrganismoTransitoDTO> organismoTransitosToOrganismoTransitoDTOs(List<OrganismoTransito> listOrganismoTransito);

}
