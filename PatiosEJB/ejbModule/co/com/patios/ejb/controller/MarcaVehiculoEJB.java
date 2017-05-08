package co.com.patios.ejb.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.MarcaVehiculo;


@LocalBean
@Stateless
public class MarcaVehiculoEJB {
	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;
	
	
	public MarcaVehiculoEJB() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void editarMarca(MarcaVehiculo marcaVehiculo){
		manager.merge(marcaVehiculo);
	}
	
	
	/**
	 * consulta todas las marcas de vehiculos y son retornados en un Map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> consultarMarcasVehiculos(){
		Map<String, String> map = new LinkedHashMap<String, String>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM MarcaVehiculo AS u");
		Query query = manager.createQuery(sql.toString());
		List<MarcaVehiculo> marcaVehiculos = query.getResultList();
		for (MarcaVehiculo tipos : marcaVehiculos){
			map.put(tipos.getDescripcionMarcaVehiculo(), tipos.getIdMarcaVehiculo().toString());
		}
		return map;
	}
	
	
	/**
	 * consulta todas las marcas de vehiculos ya la retorna en una lista 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MarcaVehiculo> consultarMarcas(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM MarcaVehiculo AS u");
		Query query = manager.createQuery(sql.toString());
		List<MarcaVehiculo> marcaVehiculos = query.getResultList();
		if(marcaVehiculos != null && !marcaVehiculos.isEmpty()){
			return marcaVehiculos;
		}
		
		return null;
	}
	
	
	/**
	 * realiza la consulta de las marcas, sin tener en cuenta la marca enviada por parametro
	 * @param idMarca
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> consultarMarcasVehiculos(int idMarca){
		Map<String, String> map = new LinkedHashMap<String, String>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM MarcaVehiculo AS u WHERE u.idMarcaVehiculo not in (:idMarca)");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idMarca", idMarca);
		List<MarcaVehiculo> marcaVehiculos = query.getResultList();
		for (MarcaVehiculo tipos : marcaVehiculos){
			map.put(tipos.getDescripcionMarcaVehiculo(), tipos.getIdMarcaVehiculo().toString());
		}
		return map;
	}
	
	
	
	
	
	

}
