package co.com.patios.service.client.gestionusuariopatios;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import co.com.patios.mb.util.DateUtils;
import co.com.patios.mb.util.ParamsBundle;
import co.com.patios.service.dto.UsuarioPatioDTO;

public class GestionUsuarioPatioServiceClient {

	private static GestionUsuarioPatioServiceClient INSTANCE;
	private static String HOST_END_POINT;
	private static final String HOST = "host_end_point";
	private static final String GESTION_USUARIO_PATIOS = "gestionUsuarioPatio";

	private GestionUsuarioPatioServiceClient() {
		// TODO Auto-generated constructor stub
	}

	public static GestionUsuarioPatioServiceClient getInstance() throws Exception {
		if (INSTANCE == null) {
			INSTANCE = new GestionUsuarioPatioServiceClient();
			ParamsBundle.getInstance().getEtiquetasParamsClient(ParamsBundle.service_client_patios);
			HOST_END_POINT = ParamsBundle.getInstance().getMapParamsServiceClientPatios().get(HOST);
		}
		return INSTANCE;
	}

	public List<UsuarioPatioDTO> obtenerPatiosUsuario(int idUsuario, Date fechaActual) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uri = HOST_END_POINT + GESTION_USUARIO_PATIOS + "/patiosUsuario/{idUsuario}/{fechaActual}";
		Map<String, String> mapParams = new HashMap<>();
		mapParams.put("idUsuario", "" + idUsuario);
		String formaDate = DateUtils.formatDate(fechaActual, "yyyy-MM-dd");
		mapParams.put("fechaActual", "" + formaDate);
		try {
			ResponseEntity<List<UsuarioPatioDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<UsuarioPatioDTO>>() {
					}, mapParams);
			List<UsuarioPatioDTO> listUsuarioPatio = response.getBody();
			return listUsuarioPatio;
		} catch (HttpServerErrorException e) {
			throw new Exception(e.getResponseBodyAsString() + " " + e.getMessage());
		}
	}

}
