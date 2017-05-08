package co.com.patios.ejb.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Vehiculo;


@LocalBean
@Stateless
public class VehiculoEJB {

	
	@PersistenceContext (name= "PatiosDS")
	EntityManager manager;
	
	
	public VehiculoEJB() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void insertVehiculo(Vehiculo vehiculo){
		manager.persist(vehiculo);
	}
	
	
	@SuppressWarnings("unchecked")
	public Vehiculo consultarVehiculo(String placa){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM Vehiculo AS u WHERE u.placaVehiculo = :placa");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("placa", placa);
		List<Vehiculo> vehiculo = query.getResultList();
		if(vehiculo != null){
			if(!vehiculo.isEmpty()){
				return vehiculo.get(0);
			}
		}
		return null;
	}
	
	
	public void editarRegistroVehiculo(Vehiculo vehiculo){
		manager.merge(vehiculo);
	}
	

	@SuppressWarnings("unchecked")
	public Vehiculo consultarVehiculo(int idVehiculo){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM Vehiculo AS u WHERE u.idVehiculo = :idVehiculo");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idVehiculo", idVehiculo);
		List<Vehiculo> vehiculo = query.getResultList();
		if(vehiculo != null){
			if(!vehiculo.isEmpty()){
				return vehiculo.get(0);
			}
		}
		return null;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Vehiculo> consultarVehiculos(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT v FROM Vehiculo AS v");
		Query query = manager.createQuery(sql.toString());
		List<Vehiculo> vehiculos = query.getResultList();
		if(vehiculos != null){
			if(!vehiculos.isEmpty()){
				return vehiculos;
			}
		}
		return null;
	}
	
}

