package co.com.patios.ejb.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Pais;

/**
 * Session Bean implementation class PaisEJB
 */
@Stateless
@LocalBean
public class PaisEJB {

	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;
	
	
    /**
     * Default constructor. 
     */
    public PaisEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    /**
     * consulta todos los paises del sistema y los retorna en una Map
     * @return
     */
    @SuppressWarnings("unchecked")
	public Map<String, String> consultarPaises(){
    	Map<String, String> map = new LinkedHashMap<String, String>();
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM Pais AS u");
    	Query query = manager.createQuery(sql.toString());
    	List<Pais> listPais = query.getResultList();
    	if(listPais != null && !listPais.isEmpty()){
	    	for (Pais pais : listPais) {
	    		map.put(pais.getDescripcionPais(), pais.getIdPais().toString().trim());
			}
    	}
    	
    	return map;
    	
    }
    

}
