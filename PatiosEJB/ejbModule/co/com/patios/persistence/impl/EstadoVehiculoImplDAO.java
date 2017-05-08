package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.patios.entity.EstadoVehiculo;
import co.com.patios.persistence.iface.EstadoVehiculoIfaceDAO;

@Stateless
public class EstadoVehiculoImplDAO implements EstadoVehiculoIfaceDAO{
	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoVehiculo> consultarEstadosVehiculos() {
		return manager.createNamedQuery("EstadoVehiculo.findAll").getResultList();
	}

}
