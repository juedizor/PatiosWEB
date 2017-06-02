package co.com.app.negocio.general.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.app.negocio.dto.MenuDTO;
import co.com.app.negocio.dto.MenuItemDTO;
import co.com.app.negocio.dto.TipoMenuDTO;
import co.com.app.negocio.general.iface.GestionarMenuIface;
import co.com.app.negocio.modelmapper.MenuItemMapper;
import co.com.app.negocio.modelmapper.MenuMapper;
import co.com.app.negocio.modelmapper.TipoMenuMapper;
import co.com.app.patios.domain.Menu;
import co.com.app.patios.domain.MenuItem;
import co.com.app.patios.domain.TipoMenu;
import co.com.app.patios.repository.MenuIfaceDAO;
import co.com.app.patios.repository.MenuItemIfaceDAO;

@Service
public class GestionarMenuImpl implements GestionarMenuIface {

	@Autowired
	MenuIfaceDAO menuIfaceDAO;
	@Autowired
	MenuItemIfaceDAO menuItemIfaceDAO;

	@Override
	public List<MenuDTO> obtenerMenusPorTipo(int idTipoMenu) throws Exception {
		List<Menu> listMenu = menuIfaceDAO.findByIdTipoMenu(idTipoMenu);
		if (listMenu != null && !listMenu.isEmpty()) {
			List<MenuDTO> listMenuDTO = MenuMapper.INSTANCE.menusToMenusDTO(listMenu);
			int i = 0;
			for (Menu menu : listMenu) {
				TipoMenu tipoMenu = menu.getTipoMenu();
				TipoMenuDTO tipoMenuDTO = TipoMenuMapper.INSTANCE.tipoMenuToTipoMenuDTO(tipoMenu);
				listMenuDTO.get(i).setTipoMenu(tipoMenuDTO);
				i++;
			}
			return listMenuDTO;
		}
		return null;
	}

	@Override
	public List<MenuItemDTO> obtenerMenusItemPorIdMenu(int idMenu) throws Exception {
		List<MenuItem> listMenuItem = menuItemIfaceDAO.findByIdMenu(idMenu);
		if (listMenuItem != null && !listMenuItem.isEmpty()) {
			List<MenuItemDTO> listMenuItemDTO = MenuItemMapper.INSTANCE.menuItemsToMenuItemDtos(listMenuItem);
			int i = 0;
			for (MenuItem menuItem : listMenuItem) {
				Menu menu1 = menuItem.getMenu1();
				Menu menu2 = menuItem.getMenu2();
				TipoMenu tipoMenu1 = menu1.getTipoMenu();
				TipoMenuDTO tipoMenuDTO1 = TipoMenuMapper.INSTANCE.tipoMenuToTipoMenuDTO(tipoMenu1);
				TipoMenu tipoMenu2 = menu2.getTipoMenu();
				TipoMenuDTO tipoMenuDTO2 = TipoMenuMapper.INSTANCE.tipoMenuToTipoMenuDTO(tipoMenu2);
				MenuDTO menuDTO1 = MenuMapper.INSTANCE.menuToMenuDTO(menu1);
				menuDTO1.setTipoMenu(tipoMenuDTO1);
				MenuDTO menuDTO2 = MenuMapper.INSTANCE.menuToMenuDTO(menu2);
				menuDTO2.setTipoMenu(tipoMenuDTO2);
				listMenuItemDTO.get(i).setMenu1(menuDTO1);
				listMenuItemDTO.get(i).setMenu2(menuDTO2);
				i++;
			}
			return listMenuItemDTO;
		}
		return null;
	}

}
