package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Vehiculo;
import co.com.patios.persistence.iface.VehiculoIfaceDAO;

@Stateless
public class VehiculoImplDAO implements VehiculoIfaceDAO{

	@PersistenceContext (name= "PatiosDS")
	EntityManager manager;

	@Override
	public void insertVehiculo(Vehiculo vehiculo) {
		manager.persist(vehiculo);
	}
	
	@Override
	public void editarRegistroVehiculo(Vehiculo vehiculo) {
		manager.merge(vehiculo);
	}

	@Override
	public Vehiculo consultarVehiculo(String placa) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM Vehiculo AS u WHERE u.placaVehiculo = :placa");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("placa", placa);
		return (Vehiculo)query.getSingleResult();
	}

	@Override
	public Vehiculo consultarVehiculo(int idVehiculo) {
		return manager.find(Vehiculo.class, idVehiculo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> consultarVehiculos() {
		return manager.createNamedQuery("Vehiculo.findAll").getResultList();
	}

	
	
	
	
	
}
