package co.com.patios.service.client.gestionpersonas;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import co.com.patios.mb.util.ParamsBundle;
import co.com.patios.service.dto.PersonaDTO;

public class GestionPersonasServiceClient {

	private static GestionPersonasServiceClient INSTANCE;
	private static String HOST_END_POINT;
	private static final String HOST = "host_end_point";
	private static final String GESTION_PERSONAS = "gestionPersonas";

	private GestionPersonasServiceClient() {
		// TODO Auto-generated constructor stub
	}

	public static GestionPersonasServiceClient getInstance() throws Exception {
		if (INSTANCE == null) {
			INSTANCE = new GestionPersonasServiceClient();
			ParamsBundle.getInstance().getEtiquetasParamsClient(ParamsBundle.service_client_patios);
			HOST_END_POINT = ParamsBundle.getInstance().getMapParamsServiceClientPatios().get(HOST);
		}
		return INSTANCE;
	}

	public PersonaDTO consultarPersona(int tipoDocumento, BigDecimal numeroDocumento) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uri = HOST_END_POINT + GESTION_PERSONAS + "/persona/{tipoDocumento}/{numDocumento}";
		Map<String, String> mapParams = new HashMap<>();
		mapParams.put("tipoDocumento", "" + tipoDocumento);
		mapParams.put("numDocumento", "" + numeroDocumento);
		try {
			PersonaDTO personaDTO = restTemplate.getForObject(uri, PersonaDTO.class, mapParams);
			return personaDTO;
		} catch (HttpServerErrorException e) {
			if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
				return null;
			}

			if (e.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
				throw new Exception(e.getResponseBodyAsString() + " " + e.getMessage());
			}
		}

		return null;
	}

}
