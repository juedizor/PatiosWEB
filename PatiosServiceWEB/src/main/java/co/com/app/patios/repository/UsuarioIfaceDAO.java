package co.com.app.patios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.app.patios.domain.Usuario;

@Repository
public interface UsuarioIfaceDAO extends JpaRepository<Usuario, Integer> {

	public List<Usuario> findByLoginUsuarioAndClaveUsuario(String loginUsuario, String claveUsuario);

}
