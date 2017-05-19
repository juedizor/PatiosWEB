package co.com.app.patios.repository;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.app.patios.domain.Menu;

public interface MenuIfaceDAO extends JpaRepository<Menu, Integer> {

	@Query("SELECT m FROM Menu m WHERE m.tipoMenu.idTipoMenu = :idTipoMenu")
	public List<Menu> findByIdTipoMenu(@Param("idTipoMenu") int idTipoMenu) throws PersistenceException;

}
