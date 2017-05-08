package co.com.patios.negocio.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Usuario;
import co.com.patios.negocio.iface.IngresoIface;

@Stateless
public class IngresoImpl implements IngresoIface {

	@PersistenceContext(unitName = "PatiosDS")
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public boolean ValidarAutenticacion(String loginUsuario, String claveAcceso) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM Usuario AS u WHERE u.loginUsuario = :loginUsuario AND u.claveUsuario = :claveAcceso");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("loginUsuario", loginUsuario);
		query.setParameter("claveAcceso", claveAcceso);
		List<Usuario> resultados = query.getResultList();
		if (resultados.size() > 0) {
			return true;
		}
		return false;
	}

}
