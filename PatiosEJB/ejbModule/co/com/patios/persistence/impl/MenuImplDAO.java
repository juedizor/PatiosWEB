package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import co.com.patios.entity.Menu;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.MenuIfaceDAO;

@Stateless
public class MenuImplDAO extends AbstractFacadeEJB<Menu> implements MenuIfaceDAO {

	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;

	public MenuImplDAO() {
		super(Menu.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() throws PersistenceException {
		return manager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> consultarMenu(int idTipoMenu) throws PersistenceException {
		String sql = "SELECT m FROM Menu m WHERE m.tipoMenu.idTipoMenu = :idTipoMenu";
		Query query = manager.createQuery(sql);
		query.setParameter("idTipoMenu", idTipoMenu);
		List<Menu> listMenu = query.getResultList();
		return listMenu;
	}

}
