package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.MenuItem;

@Local
public interface MenuItemIfaceDAO extends PersistenceIface<MenuItem>{
	
	public List<MenuItem> consultarMenuItem(int idMenu) throws Exception;

}
