package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import co.com.patios.entity.ColorVehiculo;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.ColorVehiculoIfaceDAO;

@Stateless
public class ColorVehiculoImplDAO extends AbstractFacadeEJB<ColorVehiculo> implements ColorVehiculoIfaceDAO {

	@PersistenceContext(unitName = "PatiosDS")
	EntityManager manager;

	public ColorVehiculoImplDAO() {
		super(ColorVehiculo.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ColorVehiculo> consultarColoresVehiculo() {
		return manager.createNamedQuery("ColorVehiculo.findAll").getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		return manager;
	}

}
