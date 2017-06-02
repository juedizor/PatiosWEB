package co.com.app.negocio.modelmapper;

import org.mapstruct.Mapper;

import co.com.app.negocio.dto.CategoriaOrganismoTransitoDTO;
import co.com.app.patios.domain.CategoriaOrganismoTransito;

import org.mapstruct.factory.Mappers;

@Mapper(uses = { OrganismoTransitoMapper.class })
public interface CategoriaOrganismoTransitoMapper {

	CategoriaOrganismoTransitoMapper INSTANCE = Mappers.getMapper(CategoriaOrganismoTransitoMapper.class);

	CategoriaOrganismoTransitoDTO categoriaOrganismoTransitoToCategoriaOrganismoTransitoDTO(
			CategoriaOrganismoTransito categoriaOrganismoTransito);

}
