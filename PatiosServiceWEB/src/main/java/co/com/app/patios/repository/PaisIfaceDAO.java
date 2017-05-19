package co.com.app.patios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.app.patios.domain.Pais;

public interface PaisIfaceDAO extends JpaRepository<Pais, Integer> {

	public List<Pais> findAll();	

}
