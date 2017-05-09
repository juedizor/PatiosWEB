package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Vehiculo;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.VehiculoIfaceDAO;

@Stateless
public class VehiculoImplDAO extends AbstractFacadeEJB<Vehiculo> implements VehiculoIfaceDAO {

	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;

	public VehiculoImplDAO() {
		super(Vehiculo.class);
	}

	@Override
	public Vehiculo consultarVehiculo(String placa) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM Vehiculo AS u WHERE u.placaVehiculo = :placa");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("placa", placa);
		return (Vehiculo) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> consultarVehiculos() {
		return manager.createNamedQuery("Vehiculo.findAll").getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
