package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.ModeloVehiculo;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.ModeloVehiculoIfaceDAO;

@Stateless
public class ModeloVehiculoImplDAO extends AbstractFacadeEJB<ModeloVehiculo> implements ModeloVehiculoIfaceDAO {

	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;

	public ModeloVehiculoImplDAO() {
		super(ModeloVehiculo.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ModeloVehiculo> consultarModelosVehiculos(int idMarca) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM ModeloVehiculo u WHERE u.marcaVehiculo.idMarcaVehiculo=:idMarca");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idMarca", idMarca);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ModeloVehiculo> consultarModelosVehiculos(int idMarca, int idModelo) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM ModeloVehiculo AS u WHERE u.marcaVehiculo.idMarcaVehiculo=:idMarca ");
		sql.append("AND u.idModelo.idModelo NOT IN (:idModelo)");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idMarca", idMarca);
		query.setParameter("idModelo", idModelo);
		return query.getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

}
