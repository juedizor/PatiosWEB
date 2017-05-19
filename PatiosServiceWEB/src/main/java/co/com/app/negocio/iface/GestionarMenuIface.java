package co.com.app.negocio.iface;

import java.util.List;

import co.com.app.negocio.dto.MenuDTO;
import co.com.app.negocio.dto.MenuItemDTO;

public interface GestionarMenuIface {

	public List<MenuDTO> obtenerMenusPorTipo(int idTipoMenu) throws Exception;
	
	public List<MenuItemDTO> obtenerMenusItemPorIdMenu(int idMenu) throws Exception;

}
