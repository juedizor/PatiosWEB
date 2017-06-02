package co.com.app.negocio.general.iface;

import java.math.BigDecimal;

import co.com.app.negocio.dto.PersonaDTO;

public interface GestionPersonasIface {

	public PersonaDTO consultarPersona(int tipoIdentificacion, BigDecimal numeroDocumento) throws Exception;
}
