package co.com.patios.service.client.gestiontelefonos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import co.com.patios.mb.util.ParamsBundle;
import co.com.patios.service.dto.TelefonoPersonaDTO;

public class GestionTelefonoServiceClient {

	private static GestionTelefonoServiceClient INSTANCE;
	private static String HOST_END_POINT;
	private static final String HOST = "host_end_point";

	private GestionTelefonoServiceClient() {
		// TODO Auto-generated constructor stub
	}

	public static GestionTelefonoServiceClient getInstance() throws Exception {
		if (INSTANCE == null) {
			INSTANCE = new GestionTelefonoServiceClient();
			ParamsBundle.getInstance().getEtiquetasParamsClient(ParamsBundle.service_client_patios);
			HOST_END_POINT = ParamsBundle.getInstance().getMapParamsServiceClientPatios().get(HOST);
		}
		return INSTANCE;
	}

	public List<TelefonoPersonaDTO> obtenerTelefonosPersona(int idPersona) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uri = HOST_END_POINT + "/telefonos/{idPersona}";
		Map<String, String> mapParams = new HashMap<>();
		mapParams.put("idPersona", "" + idPersona);
		try {
			ResponseEntity<List<TelefonoPersonaDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<TelefonoPersonaDTO>>() {
					}, mapParams);
			List<TelefonoPersonaDTO> listTel = response.getBody();
			return listTel;
		} catch (HttpServerErrorException e) {
			throw new Exception(e.getResponseBodyAsString() + " " + e.getMessage());
		}

	}
}
