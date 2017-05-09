package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import co.com.patios.entity.Usuario;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.UsuarioIfaceDAO;

@Stateless
public class UsuarioImplDAO extends AbstractFacadeEJB<Usuario> implements UsuarioIfaceDAO {

	@PersistenceContext(unitName = "PatiosDS")
	EntityManager manager;

	public UsuarioImplDAO() {
		super(Usuario.class);
	}

	@Override
	public Usuario buscarUsuario(String loginUsuario) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select u FROM Usuario AS u WHERE u.loginUsuario = :loginUsuario");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("loginUsuario", loginUsuario);
		return (Usuario) query.getSingleResult();
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

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario buscarUsuario(String loginUsuario, String password) throws PersistenceException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM Usuario AS u WHERE u.loginUsuario = :loginUsuario AND u.claveUsuario = :claveAcceso");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("loginUsuario", loginUsuario);
		query.setParameter("claveAcceso", password);
		List<Usuario> listUsuario = query.getResultList();
		if (listUsuario != null && !listUsuario.isEmpty()) {
			return listUsuario.get(0);
		}

		return null;
	}

}
