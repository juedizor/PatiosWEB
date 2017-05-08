package co.com.patios.ejb.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.VolantePatio;

/**
 * Session Bean implementation class VolantePatioEJB
 */
@Stateless
@LocalBean
public class VolantePatioEJB {
	
	
	@EJB
	UtilidadesEJB UtilidadesEJB;
	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;

    /**
     * Default constructor. 
     */
    public VolantePatioEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    public void insertarVolantePatios(VolantePatio volantePatio){
    	manager.persist(volantePatio);
    }
    
    
    @SuppressWarnings("unchecked")
	public VolantePatio consultarVolantePorEntrada(int idEntrada){
    	StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM VolantePatio AS u WHERE u.entradaVehiculoPatio.idEntradaVehiculoPatio = :idEntrada ");
		sql.append("AND u.fechaVolante = :fechaVolante");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idEntrada", idEntrada);
		query.setParameter("fechaVolante", UtilidadesEJB.getFechaActual());
		List<VolantePatio> volantePatio = query.getResultList();
		if(volantePatio.isEmpty()){
			return null;
		}
		return volantePatio.get(0);
    }
    
    
    
    

}
