package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.Menu;

@Local
public interface MenuIfaceDAO extends PersistenceIface<Menu>{
	
	public List<Menu> consultarMenu(int idTipoMenu) throws PersistenceException;

}
