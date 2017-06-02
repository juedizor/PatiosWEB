package co.com.patios.mb.catalogos;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.patios.service.client.gestionusuariopatios.GestionUsuarioPatioServiceClient;
import co.com.patios.service.dto.UsuarioPatioDTO;

@ManagedBean(name = "patiosUsuario")
@SessionScoped
public class PatiosUsuario {

	private Map<String, String> patiosUsuario;

	public Map<String, String> getPatiosUsuario(int idUsuario, Date fechaActual) throws Exception {
		List<UsuarioPatioDTO> listUsuarioPatio = GestionUsuarioPatioServiceClient.getInstance()
				.obtenerPatiosUsuario(idUsuario, fechaActual);
		if (listUsuarioPatio != null && !listUsuarioPatio.isEmpty()) {
			patiosUsuario = new LinkedHashMap<>();
			for (UsuarioPatioDTO usuarioPatio : listUsuarioPatio) {
				patiosUsuario.put(usuarioPatio.getPatio().getNombrePatio(), "" + usuarioPatio.getPatio().getIdPatio());
			}
		}
		
		return patiosUsuario;
	}

	/**
	 * @param patiosUsuario
	 *            the patiosUsuario to set
	 */
	public void setPatiosUsuario(Map<String, String> patiosUsuario) {
		this.patiosUsuario = patiosUsuario;
	}

	/**
	 * @return the patiosUsuario
	 */
	public Map<String, String> getPatiosUsuario() {
		return patiosUsuario;
	}
	
	

}
