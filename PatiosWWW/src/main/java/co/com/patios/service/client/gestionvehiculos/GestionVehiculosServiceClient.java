package co.com.patios.service.client.gestionvehiculos;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import co.com.patios.mb.util.ParamsBundle;
import co.com.patios.service.dto.VehiculoDTO;

public class GestionVehiculosServiceClient {

	private static GestionVehiculosServiceClient INSTANCE;
	private static String HOST_END_POINT;
	private static final String HOST = "host_end_point";
	private static final String GESTION_VEHICULOS = "gestionVehiculos";

	private GestionVehiculosServiceClient() {
		// TODO Auto-generated constructor stub
	}

	public static GestionVehiculosServiceClient getInstance() throws Exception {
		if (INSTANCE == null) {
			INSTANCE = new GestionVehiculosServiceClient();
			ParamsBundle.getInstance().getEtiquetasParamsClient(ParamsBundle.service_client_patios);
			HOST_END_POINT = ParamsBundle.getInstance().getMapParamsServiceClientPatios().get(HOST);
		}
		return INSTANCE;
	}

	public VehiculoDTO obtenerDatosVehiculos(String placa) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uri = HOST_END_POINT + GESTION_VEHICULOS + "/vehiculo/{placa}";
		Map<String, String> mapParams = new HashMap<>();
		mapParams.put("placa", placa);
		try {
			VehiculoDTO vehiculoDTO = restTemplate.getForObject(uri, VehiculoDTO.class, mapParams);
			return vehiculoDTO;
		} catch (HttpServerErrorException e) {
			throw new Exception(e.getResponseBodyAsString() + " " + e.getMessage());
		}
	}

}
