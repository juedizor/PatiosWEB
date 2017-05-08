package co.com.patios.ejb.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.DetalleVolantePatio;

/**
 * Session Bean implementation class DetalleVolantePatioEJB
 */
@Stateless
@LocalBean
public class DetalleVolantePatioEJB {
	
	
	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;
	

    /**
     * Default constructor. 
     */
    public DetalleVolantePatioEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    public void insertarDetalleVolantePatio(DetalleVolantePatio detalleVolantePatio){
    	manager.persist(detalleVolantePatio);
    }
    
    
    /**
     * consulta el detalle de un volante especifico
     * @param idVolantePatio
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<DetalleVolantePatio> consultarDetallePorIdVolante(int idVolantePatio){
    	StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM DetalleVolantePatio AS u WHERE u.volantePatio.idVolantePatio = :idVolantePatio ");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idVolantePatio", idVolantePatio);
		List<DetalleVolantePatio> detalleVolantePatio = query.getResultList();
		if(detalleVolantePatio.isEmpty()){
			return null;
		}
		return detalleVolantePatio;
    }
    

}
