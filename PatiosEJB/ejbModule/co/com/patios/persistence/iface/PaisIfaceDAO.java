package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.Pais;

@Local
public interface PaisIfaceDAO extends PersistenceIface<Pais> {

	public List<Pais> consultarPaises() throws PersistenceException;

}
