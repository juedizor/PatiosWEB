package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.MarcaVehiculo;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.MarcaVehiculoIfaceDAO;

@Stateless
public class MarcaVehiculoImplDAO extends AbstractFacadeEJB<MarcaVehiculo> implements MarcaVehiculoIfaceDAO {

	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;

	public MarcaVehiculoImplDAO() {
		super(MarcaVehiculo.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MarcaVehiculo> consultarMarcas() {
		return manager.createNamedQuery("MarcaVehiculo.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MarcaVehiculo> consultarMarcasVehiculos(int idMarca) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM MarcaVehiculo AS u WHERE u.idMarcaVehiculo not in (:idMarca)");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idMarca", idMarca);
		return query.getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
