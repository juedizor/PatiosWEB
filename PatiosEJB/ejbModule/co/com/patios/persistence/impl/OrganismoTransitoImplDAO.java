package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.patios.entity.OrganismoTransito;
import co.com.patios.persistence.iface.OrganismoTransitoIfaceDAO;


@Stateless
public class OrganismoTransitoImplDAO implements OrganismoTransitoIfaceDAO{

	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrganismoTransito> consultarOrganismosTransito() {
		return manager.createNamedQuery("OrganismoTransito.findAll").getResultList();
	}

}
