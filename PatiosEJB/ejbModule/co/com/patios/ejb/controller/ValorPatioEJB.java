package co.com.patios.ejb.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.ValorPatio;

/**
 * Session Bean implementation class ValorPatioEJB
 */
@Stateless
@LocalBean
public class ValorPatioEJB {

	
	
	
	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;
	
    /**
     * Default constructor. 
     */
    public ValorPatioEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    @SuppressWarnings("unchecked")
	public ValorPatio consultarValorPatio(Date fechaEntrada, int idPatio, int idClaseVehiculo){
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM ValorPatio AS u WHERE :fechaEntrada BETWEEN u.fechaDesde AND u.fechaHasta ");
    	sql.append("AND u.patio.idPatio = :idPatio AND u.claseVehiculo.idClaseVehiculo = :idClaseVehiculo");
    	Query query = manager.createQuery(sql.toString());
    	query.setParameter("fechaEntrada", fechaEntrada);
    	query.setParameter("idPatio", idPatio);
    	query.setParameter("idClaseVehiculo", idClaseVehiculo);
    	List<ValorPatio> listValorPatio = query.getResultList();
    	if(listValorPatio.isEmpty()){
    		return null;
    	}else{
    		return listValorPatio.get(0);
    	}
    }
    
    

}
