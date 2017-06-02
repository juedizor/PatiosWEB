package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.MenuItemDTO;
import co.com.app.patios.domain.MenuItem;

@Mapper
public interface MenuItemMapper {

	MenuItemMapper INSTANCE = Mappers.getMapper(MenuItemMapper.class);

	@Mappings({ @Mapping(target = "menu1", ignore = true), @Mapping(target = "menu2", ignore = true) })
	MenuItemDTO menuItemToMenuItemDTO(MenuItem menuItem);

	List<MenuItemDTO> menuItemsToMenuItemDtos(List<MenuItem> listMenuItem);

}
