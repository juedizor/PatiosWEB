package co.com.patios.persistence.impl;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.ValorPatio;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.ValorPatioIfaceDAO;

@Stateless
public class ValorPatioImplDAO extends AbstractFacadeEJB<ValorPatio> implements ValorPatioIfaceDAO {

	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;

	public ValorPatioImplDAO() {
		super(ValorPatio.class);
	}

	@Override
	public ValorPatio consultarValorPatio(Date fechaEntrada, int idPatio, int idClaseVehiculo) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM ValorPatio AS u WHERE :fechaEntrada BETWEEN u.fechaDesde AND u.fechaHasta ");
		sql.append("AND u.patio.idPatio = :idPatio AND u.claseVehiculo.idClaseVehiculo = :idClaseVehiculo");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("fechaEntrada", fechaEntrada);
		query.setParameter("idPatio", idPatio);
		query.setParameter("idClaseVehiculo", idClaseVehiculo);
		return (ValorPatio) query.getSingleResult();
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
