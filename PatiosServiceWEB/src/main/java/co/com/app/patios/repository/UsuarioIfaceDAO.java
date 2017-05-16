package co.com.app.patios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.app.patios.domain.Usuario;


@Repository
public interface UsuarioIfaceDAO extends JpaRepository<Usuario, Integer> {
	
		

}
