package co.com.patios.ejb.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.OrganismoTransito;

/**
 * Session Bean implementation class OrganismoTransitoEJB
 */
@Stateless
@LocalBean
public class OrganismoTransitoEJB {
	
	
	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;

    /**
     * Default constructor. 
     */
    public OrganismoTransitoEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    /**
     * consulta los organismos de transito para ser listados en un selectOneMenu
     * @return
     */
    @SuppressWarnings("unchecked")
	public Map<String, String> consultarOrganismosTransito(){
    	Map<String, String> map = new LinkedHashMap<String, String>();
    	String sql = "SELECT u FROM OrganismoTransito AS u";
    	Query query = manager.createQuery(sql);
    	List<OrganismoTransito> listOrganismos = query.getResultList();
    	for (OrganismoTransito organismo : listOrganismos) {
    		map.put(organismo.getNombreOrganismoTransito(),organismo.getIdOrganismoTransito().toString());
		}
    	
    	return map;
    }
    
    

}
