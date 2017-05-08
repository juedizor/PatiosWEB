package co.com.patios.ejb.controller;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Usuario;



@LocalBean
@Stateless
public class UsuarioEJB {

	
	@PersistenceContext (unitName = "PatiosDS")
	EntityManager manager;
	
	
	
	public UsuarioEJB() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * realiza el registro del usuario
	 * @param usuario, objeto de la clase Usuario, este debe tener los datos necesarios para el insert a la tabla
	 */
	public void registrarUsuario(Usuario usuario){
		manager.persist(usuario);
	}
	
	

	/**
	 * realiza la busqueda de un usuario a traves de numero de indentificacion del mismo.
	 * @param identificacion
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Usuario buscarUsuario(String loginUsuario){
		StringBuilder sql = new StringBuilder();
		sql.append("Select u FROM Usuario AS u WHERE u.loginUsuario = :loginUsuario");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("loginUsuario",loginUsuario);
		List<Usuario> usuario = query.getResultList();
		if(usuario.isEmpty()){
			return null;
		}else{
			return usuario.get(0);
		}
	
	}
	
	/**
	 * obtiene todos los usuario del sistema, de la tabla usuario
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> consultarUsuario(int idUsuario){
		StringBuilder sql = new StringBuilder();
		sql.append("Select u FROM Usuario AS u WHERE u.idUsuario <> :idUsuario");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idUsuario", idUsuario);
		List<Usuario> listUsuario = query.getResultList();
		if(!listUsuario.isEmpty()){
			return listUsuario;
		}
		
		return null;
	}
	
	
	
	
}
