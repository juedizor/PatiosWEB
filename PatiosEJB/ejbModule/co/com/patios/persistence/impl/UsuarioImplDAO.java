package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Usuario;
import co.com.patios.persistence.iface.UsuarioIfaceDAO;

@Stateless
public class UsuarioImplDAO implements UsuarioIfaceDAO{

	
	@PersistenceContext (unitName = "PatiosDS")
	EntityManager manager;
	
	@Override
	public void registrarUsuario(Usuario usuario) {
		manager.persist(usuario);
		
	}

	@Override
	public Usuario buscarUsuario(String loginUsuario) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select u FROM Usuario AS u WHERE u.loginUsuario = :loginUsuario");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("loginUsuario",loginUsuario);
		return (Usuario)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> consultarUsuario(int idUsuario) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select u FROM Usuario AS u WHERE u.idUsuario <> :idUsuario");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idUsuario", idUsuario);
		return query.getResultList();
	}

}
