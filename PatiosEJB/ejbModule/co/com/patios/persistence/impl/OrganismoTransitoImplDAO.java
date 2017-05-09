package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.patios.entity.OrganismoTransito;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.OrganismoTransitoIfaceDAO;

@Stateless
public class OrganismoTransitoImplDAO extends AbstractFacadeEJB<OrganismoTransito>
		implements OrganismoTransitoIfaceDAO {

	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;

	public OrganismoTransitoImplDAO() {
		super(OrganismoTransito.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrganismoTransito> consultarOrganismosTransito() {
		return manager.createNamedQuery("OrganismoTransito.findAll").getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
