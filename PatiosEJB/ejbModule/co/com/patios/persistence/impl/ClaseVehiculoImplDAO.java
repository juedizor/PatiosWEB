package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.patios.entity.ClaseVehiculo;
import co.com.patios.persistence.iface.ClaseVehiculoIfaceDAO;

@Stateless
public class ClaseVehiculoImplDAO implements ClaseVehiculoIfaceDAO {
	
	@PersistenceContext(unitName = "PatiosDS")
	EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ClaseVehiculo> consultarClaseVehiculos() {
		return manager.createNamedQuery("ClaseVehiculo.findAll").getResultList();
	}
	
	

}
