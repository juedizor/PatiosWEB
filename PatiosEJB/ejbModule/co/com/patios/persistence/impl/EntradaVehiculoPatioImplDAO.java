package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.EntradaVehiculoPatio;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.EntradaVehiculoPatioIfaceDAO;

@Stateless
public class EntradaVehiculoPatioImplDAO extends AbstractFacadeEJB<EntradaVehiculoPatio>
		implements EntradaVehiculoPatioIfaceDAO {

	@PersistenceContext(unitName = "PatiosDS")
	EntityManager manager;

	public EntradaVehiculoPatioImplDAO() {
		super(EntradaVehiculoPatio.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntradaVehiculoPatio> obtenerEntrada() {
		return manager.createNamedQuery("EntradaVehiculoPatio.findAll").getResultList();
	}

	@Override
	public EntradaVehiculoPatio consultarEntrada(int idVehiculo, String estadoEntradaVehiculo) {
		String jpql = "SELECT u FROM EntradaVehiculoPatio AS u WHERE u.vehiculo.idVehiculo = :idVehiculo "
				+ "AND u.estadoEntradaVehiculo = :estadoEntradaVehiculo";
		Query query = manager.createQuery(jpql);
		query.setParameter("idVehiculo", idVehiculo);
		query.setParameter("estadoEntradaVehiculo", estadoEntradaVehiculo);
		return (EntradaVehiculoPatio) query.getSingleResult();
	}

	@Override
	public EntradaVehiculoPatio consultarEntrada(int idVehiculo, String estadoEntradaVehiculo, int idPatio) {
		String jpql = "SELECT u FROM EntradaVehiculoPatio AS u WHERE u.vehiculo.idVehiculo = :idVehiculo "
				+ "AND u.estadoEntradaVehiculo = :estadoEntradaVehiculo AND u.patio.idPatio = :idPatio";
		Query query = manager.createQuery(jpql);
		query.setParameter("idVehiculo", idVehiculo);
		query.setParameter("estadoEntradaVehiculo", estadoEntradaVehiculo);
		query.setParameter("idPatio", idPatio);
		return (EntradaVehiculoPatio) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntradaVehiculoPatio> consultarEntrada(String estadoEntradaVehiculo, int idPatio) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM EntradaVehiculoPatio AS u WHERE u.estadoEntradaVehiculo = :estadoEntradaVehiculo ");
		sql.append("AND u.patio.idPatio = :idPatio ");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("estadoEntradaVehiculo", estadoEntradaVehiculo);
		query.setParameter("idPatio", idPatio);
		return query.getResultList();
	}

	@Override
	public EntradaVehiculoPatio consultarEntrada(String placa) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM EntradaVehiculoPatio AS u WHERE u.vehiculo.placaVehiculo = :placa");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("placa", placa);
		return (EntradaVehiculoPatio) query.getSingleResult();
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
