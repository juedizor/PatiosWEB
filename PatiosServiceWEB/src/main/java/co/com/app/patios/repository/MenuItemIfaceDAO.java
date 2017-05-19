package co.com.app.patios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.app.patios.domain.MenuItem;

public interface MenuItemIfaceDAO extends JpaRepository<MenuItem, Integer> {

	@Query("SELECT m FROM MenuItem m WHERE m.menu1.idMenu = :idMenu")
	public List<MenuItem> findByIdMenu(@Param("idMenu") int idMenu) throws Exception;

}
