package co.com.patios.persistence.iface;

import javax.persistence.PersistenceException;

public interface PersistenceIface<T> {

	public void save(T t) throws PersistenceException;

	public T merge(T t1) throws PersistenceException;

	public void remove(T t) throws PersistenceException;

	public T find(Object id) throws PersistenceException;

}
