package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Ciudad;
import co.com.patios.entity.Departamento;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.CiudadIfaceDAO;

@Stateless
public class CiudadImplDAO extends AbstractFacadeEJB<Ciudad> implements CiudadIfaceDAO {

	@PersistenceContext(unitName = "PatiosDS")
	EntityManager manager;

	public CiudadImplDAO() {
		super(Ciudad.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> consultarCiudades() {
		return manager.createNamedQuery("Ciudad.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> consultarCiudadPorDepartamento(Departamento departamento) {
		String jpql = "SELECT c FROM Ciudad c WHERE c.departamento.idDepartamento = :idDepartamento";
		Query query = manager.createNamedQuery(jpql);
		query.setParameter("idDepartamento", departamento.getIdDepartamento());
		return query.getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		return manager;
	}

}
