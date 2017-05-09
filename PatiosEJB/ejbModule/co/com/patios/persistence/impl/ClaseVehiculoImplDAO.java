package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.patios.entity.ClaseVehiculo;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.ClaseVehiculoIfaceDAO;

@Stateless
public class ClaseVehiculoImplDAO extends AbstractFacadeEJB<ClaseVehiculo> implements ClaseVehiculoIfaceDAO {

	@PersistenceContext(unitName = "PatiosDS")
	EntityManager manager;

	public ClaseVehiculoImplDAO() {
		super(ClaseVehiculo.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClaseVehiculo> consultarClaseVehiculos() {
		return manager.createNamedQuery("ClaseVehiculo.findAll").getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		return manager;
	}

}
