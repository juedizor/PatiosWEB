package co.com.patios.persistence.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.UsuarioPatio;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.UsuarioPatioIfaceDAO;

@Stateless
public class UsuarioPatioImplDAO extends AbstractFacadeEJB<UsuarioPatio> implements UsuarioPatioIfaceDAO {

	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;

	public UsuarioPatioImplDAO() {
		super(UsuarioPatio.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioPatio> consultarPatiosUsuario(int idUsuario, Date fechaActual) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM UsuarioPatio AS u WHERE u.usuario1.idUsuario = :idUsuario ");
		sql.append("AND ( (:fechaActual BETWEEN u.fechaInicio AND u.fechaFinal) OR (u.fechaFinal IS NULL))");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idUsuario", idUsuario);
		query.setParameter("fechaActual", fechaActual);
		return query.getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
