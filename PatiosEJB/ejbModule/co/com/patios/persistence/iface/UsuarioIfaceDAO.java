package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.Usuario;

@Local
public interface UsuarioIfaceDAO extends PersistenceIface<Usuario> {

	/**
	 * realiza la busqueda de un usuario a traves de numero de indentificacion
	 * del mismo.
	 * 
	 * @param identificacion
	 * @return
	 */
	public Usuario buscarUsuario(String loginUsuario) throws PersistenceException;

	public Usuario buscarUsuario(String loginUsuario, String password) throws PersistenceException;

	/**
	 * obtiene todos los usuario del sistema, de la tabla usuario
	 * 
	 * @return
	 */
	public List<Usuario> consultarUsuario(int idUsuario) throws PersistenceException;

}
