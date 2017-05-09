package co.com.patios.persistence.impl;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Persona;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.PersonaIfaceDAO;

@Stateless
public class PersonaImplDAO extends AbstractFacadeEJB<Persona> implements PersonaIfaceDAO {

	@PersistenceContext(unitName = "PatiosDS")
	EntityManager manager;

	public PersonaImplDAO() {
		super(Persona.class);
	}

	@Override
	public Persona consultarPersona(BigDecimal numeroIdentificacion) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM Persona AS u WHERE u.numeroIdentificacion = :numeroIdentificacion");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("numeroIdentificacion", numeroIdentificacion);
		return (Persona) query.getSingleResult();
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
