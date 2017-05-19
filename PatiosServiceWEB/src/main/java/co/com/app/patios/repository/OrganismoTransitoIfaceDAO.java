package co.com.app.patios.repository;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.app.patios.domain.OrganismoTransito;


public interface OrganismoTransitoIfaceDAO extends JpaRepository<OrganismoTransito, Integer> {

	public List<OrganismoTransito> findAll() throws PersistenceException;

}
