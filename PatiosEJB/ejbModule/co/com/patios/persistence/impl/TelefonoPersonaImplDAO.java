package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.TelefonoPersona;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.TelefonoPersonaIfaceDAO;

@Stateless
public class TelefonoPersonaImplDAO extends AbstractFacadeEJB<TelefonoPersona> implements TelefonoPersonaIfaceDAO {

	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;

	public TelefonoPersonaImplDAO() {
		super(TelefonoPersona.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TelefonoPersona> consultarTelefonoPersona(int idPersona) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM TelefonoPersona AS u WHERE u.persona.idPersona = :idPersona");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idPersona", idPersona);
		return query.getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
