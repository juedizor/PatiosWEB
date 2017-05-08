package co.com.patios.persistence.iface;

import javax.persistence.EntityManager;

public abstract class AbstractFacadeEJB <T> {
	

	private Class<T> entityClass;
	
	public AbstractFacadeEJB(Class <T> entityClass) {
		this.entityClass = entityClass;
	}
	
	protected abstract EntityManager getEntityManager(); 
	
	public void create(T entity){
		getEntityManager().persist(entity);
	}
	
	public T edit(T entity){
		return getEntityManager().merge(entity);
	}
	
	public void remove(T entity){
		getEntityManager().remove(getEntityManager().merge(entity));
	}
	
	public T find(Object id){
		return getEntityManager().find(entityClass, id);
	}
	

}
