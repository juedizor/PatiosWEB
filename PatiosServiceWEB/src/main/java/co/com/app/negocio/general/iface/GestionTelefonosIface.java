package co.com.app.negocio.general.iface;

import java.util.List;

import co.com.app.negocio.dto.TelefonoPersonaDTO;

public interface GestionTelefonosIface {
	
	public List<TelefonoPersonaDTO> consultarTelefonos(int idPersona) throws Exception;

}
