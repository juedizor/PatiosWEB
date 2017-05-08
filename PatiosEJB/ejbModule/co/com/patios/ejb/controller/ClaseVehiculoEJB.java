package co.com.patios.ejb.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.ClaseVehiculo;

/**
 * Session Bean implementation class ClaseVehiculoEJB
 */
@Stateless
@LocalBean
public class ClaseVehiculoEJB {

    
	
	
	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;
	
	
	/**
     * Default constructor. 
     */
    public ClaseVehiculoEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    /**
     * realiza la consulta de todas las clases de vehiculos que existen en el sistema
     * @return
     */
    @SuppressWarnings("unchecked")
	public Map<String, String> consultarClasesVehiculos(){
    	Map<String, String> map = new LinkedHashMap<String, String>();
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM ClaseVehiculo AS u");
    	Query query = manager.createQuery(sql.toString());
    	List<ClaseVehiculo> claseVehiculos = query.getResultList();
    	if(claseVehiculos != null && !claseVehiculos.isEmpty()){
			for (ClaseVehiculo clase : claseVehiculos){
				map.put(clase.getDescripcionClaseVehiculo(), clase.getIdClaseVehiculo().toString().trim());
			}
    	}
		return map;
    }
   
    

}
