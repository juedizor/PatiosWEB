package co.com.patios.ejb.ingreso;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Usuario;


@Stateless
@LocalBean
public class IngresoEJB {

	@PersistenceContext(unitName = "PatiosDS")
	private EntityManager manager;

	

	/**
	 * metodo para autenticar el usuario
	 * 
	 * @param nombre
	 * @param claveAcceso
	 * @return
	 */
	@SuppressWarnings("unchecked")
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
