package co.com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.app.negocio.dto.MenuDTO;
import co.com.app.negocio.dto.MenuItemDTO;
import co.com.app.negocio.iface.GestionarMenuIface;
import co.com.app.rest.exception.CommonException;
import co.com.app.rest.exception.GeneralErrorException;
import co.com.app.rest.exception.NotFoundException;

@RestController
public class MenuService {

	@Autowired
	GestionarMenuIface gestionarMenuIface;

	@RequestMapping(value = "/menu/{idTipoMenu}", method = RequestMethod.GET)
	public List<MenuDTO> getMenuDTO(@PathVariable(value = "idTipoMenu") int idTipoMenu) throws CommonException {
		List<MenuDTO> listMenuDTO;
		try {
			listMenuDTO = gestionarMenuIface.obtenerMenusPorTipo(idTipoMenu);
		} catch (Exception e) {
			throw new GeneralErrorException(
					"Error obteniendo los menus: " + e.getMessage() + "\n" + e.getLocalizedMessage());
		}

		if (listMenuDTO == null || listMenuDTO.isEmpty()) {
			throw new NotFoundException("No existen datos de menu para el tipo de menu: " + idTipoMenu);
		}

		return listMenuDTO;

	}

	@RequestMapping(value = "/menu/menuItem/{idMenu}")
	public List<MenuItemDTO> getMenuItemDTO(@PathVariable(value = "idMenu") int idMenu) throws CommonException {
		List<MenuItemDTO> listMenuItemDTO;
		try {
			listMenuItemDTO = gestionarMenuIface.obtenerMenusItemPorIdMenu(idMenu);
		} catch (Exception e) {
			throw new GeneralErrorException(
					"Error obteniendo los items de los menus: " + e.getMessage() + "\n" + e.getLocalizedMessage());
		}

		if (listMenuItemDTO == null || listMenuItemDTO.isEmpty()) {
			throw new NotFoundException("No existen datos de items de menu para el id menu: " + idMenu);
		}

		return listMenuItemDTO;
	}

}
