package co.com.patios.ejb.controller;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




/**
 * Session Bean implementation class UtilidadesEJB
 */
@Stateless
@LocalBean
public class UtilidadesEJB {

	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;

	
    /**
     * Default constructor. 
     */
    public UtilidadesEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    public java.sql.Date getFechaActual(){
    	String sql = "SELECT CURRENT_DATE";
    	Query query = manager.createNativeQuery(sql);
    	java.sql.Date date = (java.sql.Date)query.getSingleResult();
    	return date;
    }



}
