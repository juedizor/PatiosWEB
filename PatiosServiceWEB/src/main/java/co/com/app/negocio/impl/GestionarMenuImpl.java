package co.com.app.negocio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.app.negocio.dto.MenuDTO;
import co.com.app.negocio.dto.MenuItemDTO;
import co.com.app.negocio.iface.GestionarMenuIface;
import co.com.app.negocio.modelmapper.MenuItemMapper;
import co.com.app.negocio.modelmapper.MenuMapper;
import co.com.app.patios.domain.Menu;
import co.com.app.patios.domain.MenuItem;
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
		List<MenuDTO> listMenuDTO = MenuMapper.INSTANCE.menusToMenusDTO(listMenu);
		return listMenuDTO;
	}

	@Override
	public List<MenuItemDTO> obtenerMenusItemPorIdMenu(int idMenu) throws Exception {
		List<MenuItem> listMenuItem = menuItemIfaceDAO.findByIdMenu(idMenu);
		List<MenuItemDTO> listMenuItemDTO = MenuItemMapper.INSTANCE.menuItemsToMenuItemDtos(listMenuItem);
		return listMenuItemDTO;
	}

}
