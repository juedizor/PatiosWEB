package co.com.patios.ejb.controller;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.ModeloVehiculo;


@LocalBean
@Stateless
public class ModeloVehiculoEJB {
	
	
	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;
	
	
	public ModeloVehiculoEJB() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void editarModeloVehiculo(ModeloVehiculo modeloVehiculo){
		manager.persist(modeloVehiculo);
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, String> consultarModelosVehiculos(int idMarca){
		Map<String, String> map = new LinkedHashMap<String, String>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM ModeloVehiculo AS u ");
		if(idMarca > 0){
			sql.append("WHERE u.marcaVehiculo.idMarcaVehiculo=:idMarca");
		}
		Query query = manager.createQuery(sql.toString());
		if(idMarca > 0){
			query.setParameter("idMarca", idMarca);
		}
	
		List<ModeloVehiculo> list = query.getResultList();
		if(list != null && !list.isEmpty()){
			for(ModeloVehiculo modeloVehiculo : list){
				map.put(modeloVehiculo.getModeloVehiculo(), modeloVehiculo.getIdModeloVehiculo().toString());
			}
		}
		
		return map;
		
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> consultarModelosVehiculos(int idMarca, int idModelo){
		Map<String, String> map = new LinkedHashMap<String, String>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM ModeloVehiculo AS u WHERE u.marcaVehiculo.idMarcaVehiculo=:idMarca ");
		sql.append("AND u.idModelo.idModelo NOT IN (:idModelo)");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idMarca", idMarca);
		query.setParameter("idModelo", idModelo);
		List<ModeloVehiculo> list = query.getResultList();
		for(ModeloVehiculo modeloVehiculo : list){
			map.put(modeloVehiculo.getModeloVehiculo(), modeloVehiculo.getIdModeloVehiculo().toString());
		}
		
		return map;
		
	}

}
