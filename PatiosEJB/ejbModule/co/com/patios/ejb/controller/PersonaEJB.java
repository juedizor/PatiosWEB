package co.com.patios.ejb.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Persona;

/**
 * Session Bean implementation class PersonaEJB
 */
@Stateless
@LocalBean
public class PersonaEJB {

	
	
	@PersistenceContext (name = "")
	EntityManager manager;
	
    /**
     * Default constructor. 
     */
    public PersonaEJB() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * realiza el insert de la persona
     * @param persona, objeto tipo persona con los datos del registro
     */
    public void registrarPersona(Persona persona){
    	manager.persist(persona);
    }
    
    /**
     * realiza la consulta de la persona teniendo en cuenta su numero de identificacion
     * @param numeroIdentificacion
     * @return
     */
    @SuppressWarnings("unchecked")
	public Persona consultarPersona(BigDecimal numeroIdentificacion){
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM Persona AS u WHERE u.numeroIdentificacion = :numeroIdentificacion");
    	Query query = manager.createQuery(sql.toString());
    	query.setParameter("numeroIdentificacion", numeroIdentificacion);
    	List<Persona> listPersona = query.getResultList();
    	if(listPersona != null && !listPersona.isEmpty()){
    		return listPersona.get(0);
    	}
    	return null;
    }

}
