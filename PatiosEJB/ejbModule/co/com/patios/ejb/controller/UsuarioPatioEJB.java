package co.com.patios.ejb.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.UsuarioPatio;

/**
 * Session Bean implementation class UsuarioPatioEJB
 */
@Stateless
@LocalBean
public class UsuarioPatioEJB {
	
	
	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;

    /**
     * Default constructor. 
     */
    public UsuarioPatioEJB() {
        // TODO Auto-generated constructor stub
    }

    /**
     * realiza el insert a la entidad usuario_patio
     * @param usuarioPatio
     */
    public void insertarUsuarioPatio(UsuarioPatio usuarioPatio){
    	manager.persist(usuarioPatio);
    }
    
    /**
     * obtiene los patios a los que esta autorizado un usuario
     * @param idUsuario
     * @param fechaActual
     * @return
     */
    @SuppressWarnings("unchecked")
	public Map<String, String> consultarPatiosUsuario(int idUsuario, Date fechaActual){
    	Map<String, String> map = new LinkedHashMap<String, String>();
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM UsuarioPatio AS u WHERE u.usuario1.idUsuario = :idUsuario ");
    	sql.append("AND ( (:fechaActual BETWEEN u.fechaInicio AND u.fechaFinal) OR (u.fechaFinal IS NULL))");
    	Query query = manager.createQuery(sql.toString());
    	query.setParameter("idUsuario", idUsuario);
    	query.setParameter("fechaActual", fechaActual);
		List<UsuarioPatio> listUsuarioPatio = query.getResultList();
		if(listUsuarioPatio != null && !listUsuarioPatio.isEmpty()){
	    	for (UsuarioPatio usuarioPatio : listUsuarioPatio) {
				map.put(usuarioPatio.getPatio().getNombrePatio(), usuarioPatio.getPatio().getIdPatio().toString());
			}
		}	
    	
    	return map;
    }
    
    
    /**
     * consulta los patios asociados a un usuario segun el id del mismo y la fecha actual
     * @param idUsuario
     * @param fechaActual
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<UsuarioPatio> consultarPatioUsuario(int idUsuario, Date fechaActual){
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM UsuarioPatio AS u WHERE u.usuario1.idUsuario = :idUsuario ");
    	sql.append("AND ( (:fechaActual BETWEEN u.fechaInicio AND u.fechaFinal) OR (u.fechaFinal IS NULL))");
    	Query query = manager.createQuery(sql.toString());
    	query.setParameter("idUsuario", idUsuario);
    	query.setParameter("fechaActual", fechaActual);
		List<UsuarioPatio> listUsuarioPatio = query.getResultList();
		if(listUsuarioPatio != null){
			return listUsuarioPatio;
		}
    	
    	return null;
    }
    
    
    /**
     * consulta si un usuario esta vigente en el patio
     * @param idUsuario, identificador del usuario
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<UsuarioPatio> consultarVigenciaUsuarioPatio(int idUsuario, int idPatio){
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM UsuarioPatio AS u WHERE u.usuario1.idUsuario = :idUsuario ");
    	sql.append("AND u.patio.idPatio = :idPatio ");
    	sql.append("AND (u.fechaFinal IS NULL OR u.fechaFinal >= CURRENT_DATE)");
    	Query query = manager.createQuery(sql.toString());
    	query.setParameter("idUsuario", idUsuario);
    	query.setParameter("idPatio", idPatio);
    	List<UsuarioPatio> listUsuarioPatio = query.getResultList();
    	if(listUsuarioPatio != null && !listUsuarioPatio.isEmpty()){
    		return listUsuarioPatio;
    	}
    	
    	return null;
    	
    }
    
    
    
    
    
}
