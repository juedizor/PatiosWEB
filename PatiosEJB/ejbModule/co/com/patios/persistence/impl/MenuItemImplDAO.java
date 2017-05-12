package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import co.com.patios.entity.MenuItem;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.MenuItemIfaceDAO;

@Stateless
public class MenuItemImplDAO extends AbstractFacadeEJB<MenuItem> implements MenuItemIfaceDAO {

	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;

	public MenuItemImplDAO() {
		super(MenuItem.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() throws PersistenceException {
		// TODO Auto-generated method stub
		return manager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuItem> consultarMenuItem(int idMenu) throws Exception {
		String sql = "SELECT m FROM MenuItem m WHERE m.menu1.idMenu = :idMenu";
		Query query = manager.createQuery(sql);
		query.setParameter("idMenu", idMenu);
		List<MenuItem> listMenuItem = query.getResultList();
		return listMenuItem;
	}

}
