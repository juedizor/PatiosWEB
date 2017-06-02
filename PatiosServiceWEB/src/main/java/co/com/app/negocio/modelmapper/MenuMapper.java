package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.MenuDTO;
import co.com.app.patios.domain.Menu;

@Mapper
public interface MenuMapper {

	MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);

	@Mappings({ @Mapping(target = "menuItems1", ignore = true), @Mapping(target = "menuItems2", ignore = true),
			@Mapping(target = "tipoMenu", ignore = true) })
	MenuDTO menuToMenuDTO(Menu menu);

	List<MenuDTO> menusToMenusDTO(List<Menu> list);

}
