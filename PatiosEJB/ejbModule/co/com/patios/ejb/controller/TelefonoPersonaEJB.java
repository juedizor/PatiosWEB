package co.com.patios.ejb.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.TelefonoPersona;

/**
 * Session Bean implementation class TelefonoPersonaEJB
 */
@Stateless
@LocalBean
public class TelefonoPersonaEJB {

    
	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;
	
	
	/**
     * Default constructor. 
     */
    public TelefonoPersonaEJB() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * realiza el insert a la tabla telefono_persona 
     * @param telefonoPersona
     */
    public void insertarTelefonoPersona(TelefonoPersona telefonoPersona){
    	manager.persist(telefonoPersona);
    	
    }
    
    /**
     * realiza la consulta de los telefonos asociados a una persoan
     * @param idPersona
     * @return
     */
    public List<TelefonoPersona> consultarTelefonoPersona(int idPersona){
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM TelefonoPersona AS u WHERE u.persona.idPersona = :idPersona");
    	Query query =  manager.createQuery(sql.toString());
    	query.setParameter("idPersona", idPersona);
    	List<TelefonoPersona> listTelefonoPersona = query.getResultList();
    	if(listTelefonoPersona != null && !listTelefonoPersona.isEmpty()){
    		return listTelefonoPersona;
    	}
    	
    	return null;
    	
    }
    
    

}
