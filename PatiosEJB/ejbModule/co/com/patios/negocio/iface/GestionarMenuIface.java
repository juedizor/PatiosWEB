package co.com.patios.negocio.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.Menu;
import co.com.patios.entity.MenuItem;

@Local
public interface GestionarMenuIface {

	public List<Menu> obtenerMenusPorTipo(int idTipoMenu) throws Exception;
	
	public List<MenuItem> obtenerMenusItemPorIdMenu(int idMenu) throws Exception;

}
