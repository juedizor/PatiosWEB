package co.com.patios.ejb.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Ciudad;

/**
 * Session Bean implementation class CiudadEJB
 */
@Stateless
@LocalBean
public class CiudadEJB {
	
	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;
	

    /**
     * Default constructor. 
     */
    public CiudadEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    /**
     * consulta las ciudades asociadas al departamento enviado por parametro a traves de su id
     * return a Map con los datos
     * @param idDepartamento, departamento del cual se buscaran sus ciudades
     * @return
     */
    @SuppressWarnings("unchecked")
	public Map<String, String> consultarCiudades(int idDepartamento){
    	Map<String, String> map = new LinkedHashMap<String, String>();
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM Ciudad AS u WHERE u.departamento.idDepartamento = :idDepartamento");
    	Query query = manager.createQuery(sql.toString());
    	query.setParameter("idDepartamento", idDepartamento);
    	List<Ciudad> listCiudad = query.getResultList();
    	if(listCiudad != null && !listCiudad.isEmpty()){
    		for (Ciudad ciudad : listCiudad) {
				map.put(ciudad.getNombreCiudad().trim(), ciudad.getIdCiudad().toString());
			}
    	}
    	
    	return map;
    }

}
