package co.com.patios.ejb.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.EstadoVehiculo;

/**
 * Session Bean implementation class EstadoVehiculoEJB
 */
@Stateless
@LocalBean
public class EstadoVehiculoEJB {

	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;
	
	
    /**
     * Default constructor. 
     */
    public EstadoVehiculoEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    /**
     * consulta los estados de los vehiculos para ser listados en un selectOneMenu
     * @return
     */
    @SuppressWarnings("unchecked")
	public Map<String, String> consultarEstadosVehiculos(){
    	Map<String, String> map = new LinkedHashMap<String, String>();
    	String sql = "SELECT u FROM EstadoVehiculo AS u";
    	Query query = manager.createQuery(sql);
    	List<EstadoVehiculo> listEstados = query.getResultList();
    	if(listEstados != null && !listEstados.isEmpty()){
	    	for (EstadoVehiculo estadoVehiculo : listEstados) {
	    		map.put(estadoVehiculo.getDescripcionEstadoVehiculo(),estadoVehiculo.getIdEstadoVehiculo().toString());
			}
    	}
    	return map;
    }
    

}
