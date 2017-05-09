package co.com.patios.persistence.iface;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public abstract class AbstractFacadeEJB<T> {

	private Class<T> entityClass;

	public AbstractFacadeEJB(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager() throws PersistenceException;

	public void save(T entity) throws PersistenceException {
		getEntityManager().persist(entity);
	}

	public T merge(T entity) throws PersistenceException {
		return getEntityManager().merge(entity);
	}

	public void remove(T entity) throws PersistenceException {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public T find(Object id) throws PersistenceException {
		return getEntityManager().find(entityClass, id);
	}

}
