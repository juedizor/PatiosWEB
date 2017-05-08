package co.com.patios.ejb.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.ColorVehiculo;

/**
 * Session Bean implementation class ColorVehiculoEJB
 */
@Stateless
@LocalBean
public class ColorVehiculoEJB {

	
	
	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;
	
	
    /**
     * Default constructor. 
     */
    public ColorVehiculoEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    /**
     * consulta todos los colores que hay en el sistema
     * @return
     */
    @SuppressWarnings("unchecked")
	public Map<String, String> consultarColorVehiculo(){
    	Map<String, String> map = new LinkedHashMap<String, String>();
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM ColorVehiculo AS u");
    	Query query = manager.createQuery(sql.toString());
    	List<ColorVehiculo> colorVehiculos = query.getResultList();
    	if(colorVehiculos != null && !colorVehiculos.isEmpty()){
			for (ColorVehiculo color : colorVehiculos){
				map.put(color.getDescripcionColorVehiculo(), color.getIdColorVehiculo().toString().trim());
			}
    	}
		return map;
    }
    
    
    /**
     * consulta todos los colores que se  encuentran en el sistemas
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<ColorVehiculo> consultarColoresVehiculos(){
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM ColorVehiculo AS u");
    	Query query = manager.createQuery(sql.toString());
    	List<ColorVehiculo> colorVehiculos = query.getResultList();
    	if(colorVehiculos != null && !colorVehiculos.isEmpty()){
    		return colorVehiculos;
    	}
    	
    	return null;
    }

}
