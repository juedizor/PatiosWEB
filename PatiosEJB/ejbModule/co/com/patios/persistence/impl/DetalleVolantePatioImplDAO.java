package co.com.patios.persistence.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.DetalleVolantePatio;
import co.com.patios.entity.VolantePatio;
import co.com.patios.persistence.iface.DetalleVolantePatioIfaceDAO;

@Stateless
public class DetalleVolantePatioImplDAO implements DetalleVolantePatioIfaceDAO{

	
	@PersistenceContext (unitName = "PatiosDS")
	EntityManager manager;
	
	@Override
	public void insertarDetalleVolantePatio(DetalleVolantePatio detalleVolantePatio) {
		manager.persist(detalleVolantePatio);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleVolantePatio> consultarDetallePorIdVolante(VolantePatio volantePatio) {
		String jpql = "SELECT u FROM DetalleVolantePatio AS u WHERE u.volantePatio.idVolantePatio = :idVolantePatio";
		Query query = manager.createQuery(jpql);
		query.setParameter("idVolantePatio", volantePatio.getIdVolantePatio());
		return query.getResultList();
	}

}
