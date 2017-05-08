package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Patio;
import co.com.patios.persistence.iface.PatioIfaceDAO;

@Stateless
public class PatioImplDAO implements PatioIfaceDAO {

	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;

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

	@Override
	public Patio consultarPatio(int idPatio) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM Patio AS u WHERE u.idPatio = :idPatio)");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idPatio", idPatio);
		return (Patio) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patio> consultarPatio() {
		StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM Patio AS u");
    	Query query = manager.createQuery(sql.toString());
    	return query.getResultList();
	}

	@Override
	public Patio consultarPatioPorCodigo(String codigoPatio) {
		StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM Patio AS u WHERE u.codigoPatio = :codigoPatio");
    	Query query = manager.createQuery(sql.toString());
    	query.setParameter("codigoPatio", codigoPatio);
    	return (Patio)query.getSingleResult();
	}

}
