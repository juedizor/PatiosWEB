package co.com.patios.ejb.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.ConsecutivoVolante;
import co.com.patios.entity.Usuario;

/**
 * Session Bean implementation class ConsecutivoVolanteEJB
 */
@Stateless
@LocalBean
public class ConsecutivoVolanteEJB {
	
	private ConsecutivoVolante consecutivoVolante;
	

	@PersistenceContext(name ="PatiosDS")
	EntityManager manager;
	
	@EJB
	UsuarioEJB usuarioEJB;
	@EJB
	UtilidadesEJB utilidadesEJB;

    /**
     * Default constructor. 
     */
    public ConsecutivoVolanteEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    public void registrarConsecutivoVolante(ConsecutivoVolante consecutivoVolante){
    	manager.persist(consecutivoVolante);
    }
    
    public void actualizarConsecutivoVolante(ConsecutivoVolante consecutivoVolante){
    	manager.merge(consecutivoVolante);
    }
    
    @SuppressWarnings("unchecked")
	public ConsecutivoVolante consultarConsecutivoVolante(Date fechaActual){
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM ConsecutivoVolante AS u WHERE u.fechaConsecutivoVolante = :today");
    	Query query = manager.createQuery(sql.toString());
    	query.setParameter("today",fechaActual);
    	List<ConsecutivoVolante> listVolante = query.getResultList();
    	if(!listVolante.isEmpty()){
    		return listVolante.get(0);
    	}else{
    		return null;
    	}
    }
    
    
    /**
     * genera los consecutivos de volantes diarios, para un usuario especifico
     * @param identificacionUsuario, identificacion del usuario 
     * @return
     */
    public ConsecutivoVolante generarConsecutivoVolante(String loginUsuario){
    	int idUsuario = usuarioEJB.buscarUsuario(loginUsuario).getIdUsuario();
		ConsecutivoVolante consecutivo = consultarConsecutivoVolante(utilidadesEJB.getFechaActual());
		consecutivoVolante = new ConsecutivoVolante();
		Usuario usuario = new Usuario();
		if(consecutivo == null){
			usuario.setIdUsuario(idUsuario);
			consecutivoVolante.setUsuario(usuario);
			consecutivoVolante.setFechaConsecutivoVolante(utilidadesEJB.getFechaActual());
			consecutivoVolante.setNumeroVolante(1);
			registrarConsecutivoVolante(consecutivoVolante);
		}else{
			usuario.setIdUsuario(idUsuario);
			consecutivoVolante.setUsuario(usuario);
			consecutivoVolante.setFechaConsecutivoVolante(utilidadesEJB.getFechaActual());
			consecutivoVolante.setNumeroVolante(consecutivo.getNumeroVolante()+1);
			consecutivoVolante.setIdConsecutivoVolante(consecutivo.getIdConsecutivoVolante());
			actualizarConsecutivoVolante(consecutivoVolante);
		}
		
		return consecutivoVolante;
    }
    
    
    
    
    

}
