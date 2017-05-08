package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.patios.entity.TipoIdentificacion;
import co.com.patios.persistence.iface.AbstractFacadeEJB;
import co.com.patios.persistence.iface.TipoIdentificacionIfaceDAO;

@Stateless
public class TipoIdentificacionImplDAO extends AbstractFacadeEJB<TipoIdentificacion>
		implements TipoIdentificacionIfaceDAO {

	@PersistenceContext(name = "PatiosDS")
	EntityManager manager;

	public TipoIdentificacionImplDAO() {
		super(TipoIdentificacion.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return manager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoIdentificacion> consultarTiposIdentificacion() {
		return manager.createNamedQuery("TipoIdentificacion.findAll").getResultList();
	}

	@Override
	public TipoIdentificacion consultarTipoIdentificacionPorId(int idTipoIdentificacion) {
		return manager.find(TipoIdentificacion.class, idTipoIdentificacion);
	}

}
