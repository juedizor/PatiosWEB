package co.com.patios.service.client.ingreso;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import co.com.patios.mb.util.ParamsBundle;
import co.com.patios.service.dto.UsuarioDTO;

public class IngresoServiceClient {

	private static IngresoServiceClient INSTANCE;
	private static String HOST_END_POINT;
	private static final String HOST = "host_end_point";

	private IngresoServiceClient() {
		// TODO Auto-generated constructor stub
	}

	public static IngresoServiceClient getInstance() throws Exception {
		if (INSTANCE == null) {
			INSTANCE = new IngresoServiceClient();
			ParamsBundle.getInstance().getEtiquetasParamsClient(ParamsBundle.service_client_patios);
			HOST_END_POINT = ParamsBundle.getInstance().getMapParamsServiceClientPatios().get(HOST);
		}
		return INSTANCE;
	}

	public UsuarioDTO validarIngreso(String login, String clave) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uri = HOST_END_POINT + "/ingreso/inicio";
		HttpHeaders headers = new HttpHeaders();
		headers.add("login", "" + login);
		headers.add("pass", "" + clave);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(
				null, headers);
		try {
			UsuarioDTO user = restTemplate.postForObject(uri, requestEntity, UsuarioDTO.class);
			return user;
		} catch (HttpServerErrorException e) {
			throw new Exception(e.getResponseBodyAsString() + " " + e.getMessage());
		}
	}

}
