package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.OrganismoTransito;

@Local
public interface OrganismoTransitoIfaceDAO extends PersistenceIface<OrganismoTransito> {

	public List<OrganismoTransito> consultarOrganismosTransito() throws PersistenceException;

}
