package co.com.patios.ejb.controller;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.EntradaVehiculoPatio;
import co.com.patios.entity.Patio;

/**
 * Session Bean implementation class patioEJB
 */
@Stateless
@LocalBean
public class PatioEJB {

	
	
	
	@PersistenceContext(name ="PatiosDS")
	EntityManager manager;
	
	
    /**
     * Default constructor. 
     */
    public PatioEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    public void registrarPatios(Patio patio){
    	manager.persist(patio);
    }
    
    
    @SuppressWarnings({ "unchecked"})
	public Map<String, String> consultarPatios(int idEntrada){
    	Map<String, String> map = new LinkedHashMap<String, String>();
    	StringBuilder sql = new StringBuilder();
    	StringBuilder sqlEntradaPatio = new StringBuilder();
    	Query query = null;
    	Query queryAll = null;
    	sql.append("SELECT u FROM Patio AS u ");
    	queryAll = manager.createQuery(sql.toString());
    	List<EntradaVehiculoPatio> patio = null;
    	if(idEntrada > 0){
    		sqlEntradaPatio.append("SELECT p FROM EntradaVehiculoPatio AS p WHERE p.idEntradaVehiculoPatio = :idEntrada");
    		query = manager.createQuery(sqlEntradaPatio.toString());
    		query.setParameter("idEntrada", idEntrada);
    		patio = query.getResultList();
    	}
    	
    	List<Patio> allPatio = queryAll.getResultList();
    	
    	
    	int i =0;
    	if(!allPatio.isEmpty()){
	    	for (Patio patios : allPatio) {
	    		if(!(patio == null)){
	    			if(i<=0){
	    				map.put(patio.get(0).getPatio().getIdPatio().toString()+"-"+patio.get(0).getPatio().getNombrePatio().toString(),patio.get(0).getPatio().getIdPatio().toString());
	    				i++;
	    			}
	    		
	    			if(patio.get(0).getPatio().getIdPatio()!=patios.getIdPatio()){
	    				map.put(patios.getIdPatio().toString()+"-"+patios.getNombrePatio(),patios.getIdPatio().toString());
	    			}

				}else{
					map.put(patios.getIdPatio().toString()+"-"+patios.getNombrePatio(),patios.getIdPatio().toString());
				}
			}

		}
    	
    	return map;
    
    	}
    	
    
    /**
     * consulta todos los patios sin tener en cuenta el id_patio enviado por parametro
     * @param idPatio
     * @return
     */
    @SuppressWarnings("unchecked")
	public Map<String, String> consultarPatioNotInIdPatio(int idPatio){
    	Map<String, String> map = new LinkedHashMap<String, String>();
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM Patio AS u WHERE u.idPatio NOT IN (:idPatio)");
    	Query query = manager.createQuery(sql.toString());
    	query.setParameter("idPatio", idPatio);
    	List<Patio> listPatios = query.getResultList();
    	if(listPatios != null && !listPatios.isEmpty()){
	    	for (Patio patio: listPatios){
	    		map.put(patio.getNombrePatio(), patio.getIdPatio().toString());
	    	}
    	}	
    	
    	return map;
    }
    
    
    /**
     * realiza la consulta a patios teniendo en cuenta el id_patio enviado por parametro
     * @param idPatio
     * @return
     */
    @SuppressWarnings("unchecked")
  	public Patio consultarPatio(int idPatio){
      	StringBuilder sql = new StringBuilder();
      	sql.append("SELECT u FROM Patio AS u WHERE u.idPatio = :idPatio)");
      	Query query = manager.createQuery(sql.toString());
      	query.setParameter("idPatio", idPatio);
      	List<Patio> listPatios = query.getResultList();
      	if(listPatios.isEmpty()){
      		return null;
      	}
      	return listPatios.get(0);
      }
    
    /**
     * retorna todos los patios registrados en el sistema
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<Patio> consultarPatio(){
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM Patio AS u");
    	Query query = manager.createQuery(sql.toString());
    	List<Patio> listPatio =	query.getResultList();
    	if(listPatio != null){
    		if(!listPatio.isEmpty()){
    			return listPatio;
    		}
    		
    	}
    	
    	return null;
    }
    
    
    /**
     * realiza la consulta de patio segun el codigo del mismo
     * @param codigoPatio, codigo del patio que sera buscado
     * @return
     */
    @SuppressWarnings("unchecked")
	public Patio consultarPatioPorCodigo(String codigoPatio){
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM Patio AS u WHERE u.codigoPatio = :codigoPatio");
    	Query query = manager.createQuery(sql.toString());
    	query.setParameter("codigoPatio", codigoPatio);
    	List<Patio> listPatio = query.getResultList();
    	if(listPatio != null){
    		if(!listPatio.isEmpty()){
    			return listPatio.get(0);
    		}
    		
    	}
    	return null;
    }
    
    
    	

}
