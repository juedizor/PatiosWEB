package co.com.patios.ejb.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.TipoIdentificacion;

/**
 * Session Bean implementation class TipoIdentificacionEJB
 */
@Stateless
@LocalBean
public class TipoIdentificacionEJB {
	
	
	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;

    /**
     * Default constructor. 
     */
    public TipoIdentificacionEJB() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * lista todos los tipos de identificacion disponibles en el sistema
     * @return
     */
    @SuppressWarnings("unchecked")
   	public Map<String, String> consultarTiposIdentificacion(){
       	Map<String, String> map = new LinkedHashMap<String, String>();
       	String sql = "SELECT u FROM TipoIdentificacion AS u";
       	Query query = manager.createQuery(sql);
       	List<TipoIdentificacion> listTiposIdentificacion = query.getResultList();
       	if(listTiposIdentificacion != null && !listTiposIdentificacion.isEmpty()){
	       	for (TipoIdentificacion tipoIdentificacion : listTiposIdentificacion) {
	       		map.put(tipoIdentificacion.getDescripcionTipoIdentificacion(),tipoIdentificacion.getIdTipoIdentificacion().toString());
	   		}
       	}
       	
       	return map;
       }
    
    /**
     * devuelve el tipo de identificación de la tabla tipo_identificacion, teniendo en cuenta el id de la tabla
     * @param idTipoIdentificacion
     * @return
     */
    @SuppressWarnings("unchecked")
	public TipoIdentificacion consultarTipoIdentificacionPorId(int idTipoIdentificacion){
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM TipoIdentificacion AS u WHERE u.idTipoIdentificacion = :idTipoIdentificacion");
    	Query query = manager.createQuery(sql.toString());
    	query.setParameter("idTipoIdentificacion", idTipoIdentificacion);
    	List<TipoIdentificacion> listTipoIdentificacion = query.getResultList();
    	if(listTipoIdentificacion != null){
	    	if(!listTipoIdentificacion.isEmpty()){
	    		return listTipoIdentificacion.get(0);
	    	}
    	}
    	
    	return null;
    	
    }
    
    

}
