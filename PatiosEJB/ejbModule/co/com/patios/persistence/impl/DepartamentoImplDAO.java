package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Departamento;
import co.com.patios.entity.Pais;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.DepartamentoIfaceDAO;

@Stateless
public class DepartamentoImplDAO extends AbstractFacadeEJB<Departamento> implements DepartamentoIfaceDAO {

	@PersistenceContext(unitName = "PatiosDS")
	EntityManager manager;

	public DepartamentoImplDAO() {
		super(Departamento.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> consultarDepartamentos() {
		return manager.createNamedQuery("Departamento.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> consultarDepartamentos(Pais pais) {
		String jpql = "SELECT u FROM Departamento AS u WHERE u.pais.idPais = :idPais";
		Query query = manager.createQuery(jpql);
		query.setParameter("idPais", pais.getIdPais());
		return query.getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
