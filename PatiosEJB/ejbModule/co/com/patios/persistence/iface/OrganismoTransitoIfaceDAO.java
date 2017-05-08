package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.OrganismoTransito;

@Local
public interface OrganismoTransitoIfaceDAO {
	
	
	public List<OrganismoTransito> consultarOrganismosTransito();

}
