package co.com.patios.persistence.impl;

import java.sql.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import co.com.patios.entity.VolantePatio;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.VolantePatioIfaceDAO;

@Stateless
public class VolantePatioImplDAO extends AbstractFacadeEJB<VolantePatio> implements VolantePatioIfaceDAO {

	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;

	public VolantePatioImplDAO() {
		super(VolantePatio.class);
	}

	@Override
	public VolantePatio consultarVolantePorEntrada(int idEntrada, Date fecha) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM VolantePatio AS u WHERE u.entradaVehiculoPatio.idEntradaVehiculoPatio = :idEntrada ");
		sql.append("AND u.fechaVolante = :fechaVolante");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idEntrada", idEntrada);
		query.setParameter("fechaVolante", fecha);
		return (VolantePatio) query.getSingleResult();
	}

	@Override
	protected EntityManager getEntityManager() throws PersistenceException {
		// TODO Auto-generated method stub
		return manager;
	}

}
