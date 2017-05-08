package co.com.patios.ejb.controller;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ModuloOpcionPermiso
 */
@Stateless
@LocalBean
public class ModuloOpcionPermisoEJB {

	
	
	@PersistenceContext (unitName = "PatiosDS")
	EntityManager manager;
	
    /**
     * Default constructor. 
     */
    public ModuloOpcionPermisoEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    
    
    
    
    
    
    

}
