package co.com.patios.negocio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.patios.entity.Menu;
import co.com.patios.entity.MenuItem;
import co.com.patios.negocio.iface.GestionarMenuIface;
import co.com.patios.persistence.iface.MenuIfaceDAO;
import co.com.patios.persistence.iface.MenuItemIfaceDAO;

@Stateless
public class GestionarMenuImpl implements GestionarMenuIface {

	@EJB
	MenuIfaceDAO menuIfaceDAO;
	@EJB
	MenuItemIfaceDAO menuItemIfaceDAO;

	@Override
	public List<Menu> obtenerMenusPorTipo(int idTipoMenu) throws Exception {
		List<Menu> listMenu = menuIfaceDAO.consultarMenu(idTipoMenu);
		return listMenu;
	}

	@Override
	public List<MenuItem> obtenerMenusItemPorIdMenu(int idMenu) throws Exception {
		List<MenuItem> listMenuItem = menuItemIfaceDAO.consultarMenuItem(idMenu);
		return listMenuItem;
	}

}
