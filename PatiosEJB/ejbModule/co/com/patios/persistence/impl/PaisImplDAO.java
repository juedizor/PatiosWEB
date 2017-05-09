package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.patios.entity.Pais;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.PaisIfaceDAO;

@Stateless
public class PaisImplDAO extends AbstractFacadeEJB<Pais> implements PaisIfaceDAO {

	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;

	public PaisImplDAO() {
		super(Pais.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> consultarPaises() {
		return manager.createNamedQuery("Pais.findAll").getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
