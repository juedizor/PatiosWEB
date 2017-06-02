package co.com.app.negocio.general.iface;

import java.util.Date;
import java.util.List;

import co.com.app.negocio.dto.UsuarioPatioDTO;

public interface GestionUsuarioPatiosIface {

	public List<UsuarioPatioDTO> consultarPatiosUsuario(int idUsuario, Date fechaActual) throws Exception;

}
