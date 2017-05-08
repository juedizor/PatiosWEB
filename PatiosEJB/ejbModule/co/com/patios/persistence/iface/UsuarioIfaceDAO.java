package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.Usuario;

@Local
public interface UsuarioIfaceDAO {
	
	/**
	 * realiza el registro del usuario
	 * @param usuario, objeto de la clase Usuario, este debe tener los datos necesarios para el insert a la tabla
	 */
	public void registrarUsuario(Usuario usuario);
	
	/**
	 * realiza la busqueda de un usuario a traves de numero de indentificacion del mismo.
	 * @param identificacion
	 * @return
	 */
	public Usuario buscarUsuario(String loginUsuario);
	
	
	/**
	 * obtiene todos los usuario del sistema, de la tabla usuario
	 * @return
	 */
	public List<Usuario> consultarUsuario(int idUsuario);

}
