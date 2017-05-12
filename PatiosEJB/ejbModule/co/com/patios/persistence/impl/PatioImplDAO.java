package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Patio;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.PatioIfaceDAO;

@Stateless
public class PatioImplDAO extends AbstractFacadeEJB<Patio> implements PatioIfaceDAO {

	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;

	public PatioImplDAO() {
		super(Patio.class);
	}

	@Override
	public List<Patio> consultarPatios(int idEntrada) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patio> consultarPatioNotInIdPatio(int idPatio) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM Patio AS u WHERE u.idPatio NOT IN (:idPatio)");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idPatio", idPatio);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patio> consultarPatio() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM Patio AS u");
		Query query = manager.createQuery(sql.toString());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Patio consultarPatioPorCodigo(String codigoPatio) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM Patio AS u WHERE u.codigoPatio = :codigoPatio");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("codigoPatio", codigoPatio);
		List<Patio> listPatio = query.getResultList();
		if(listPatio != null && !listPatio.isEmpty()){
			return listPatio.get(0);
		}
		return null;
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
