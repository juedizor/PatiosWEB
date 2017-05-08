package co.com.patios.persistence.iface;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.UsuarioPatio;

@Local
public interface UsuarioPatioIfaceDAO {
	
	
	/**
     * realiza el insert a la entidad usuario_patio
     * @param usuarioPatio
     */
	public void insertarUsuarioPatio(UsuarioPatio usuarioPatio);
	
	/**
     * obtiene los patios a los que esta autorizado un usuario
     * @param idUsuario
     * @param fechaActual
     * @return
     */
	public List<UsuarioPatio> consultarPatiosUsuario(int idUsuario, Date fechaActual);
	

}
