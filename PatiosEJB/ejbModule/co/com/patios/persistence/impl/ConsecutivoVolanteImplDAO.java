package co.com.patios.persistence.impl;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.ConsecutivoVolante;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.ConsecutivoVolanteIfaceDAO;

@Stateless
public class ConsecutivoVolanteImplDAO extends AbstractFacadeEJB<ConsecutivoVolante>
		implements ConsecutivoVolanteIfaceDAO {

	@PersistenceContext(unitName = "PatiosDS")
	EntityManager manager;

	public ConsecutivoVolanteImplDAO() {
		super(ConsecutivoVolante.class);
	}

	@Override
	public ConsecutivoVolante consultarConsecutivoVolante(Date fecha) {
		String jpql = "SELECT u FROM ConsecutivoVolante AS u WHERE u.fechaConsecutivoVolante = :fecha";
		Query query = manager.createQuery(jpql);
		query.setParameter("fecha", fecha);
		return (ConsecutivoVolante) query.getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
