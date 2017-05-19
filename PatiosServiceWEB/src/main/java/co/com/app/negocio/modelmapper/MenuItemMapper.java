package co.com.app.negocio.modelmapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import co.com.app.negocio.dto.MenuDTO;
import co.com.app.negocio.dto.MenuItemDTO;
import co.com.app.patios.domain.Menu;
import co.com.app.patios.domain.MenuItem;

@Mapper
public interface MenuItemMapper {

	MenuItemMapper INSTANCE = Mappers.getMapper(MenuItemMapper.class);

	@Mappings(value = { @Mapping(source = "menu1", target = "idMenuPrincipal"),
			@Mapping(source = "menu2", target = "idMenuSecundario") })
	MenuItemDTO menuItemToMenuItemDTO(MenuItem menuItem);
	
	@Mappings({ @Mapping(source = "tipoMenu.idTipoMenu", target = "idTipoMenu") })
	MenuDTO menuToMenuDTO(Menu menu);

	List<MenuItemDTO> menuItemsToMenuItemDtos(List<MenuItem> listMenuItem);

}
