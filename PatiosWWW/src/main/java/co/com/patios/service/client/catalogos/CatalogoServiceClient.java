package co.com.patios.service.client.catalogos;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import co.com.patios.mb.util.ParamsBundle;
import co.com.patios.service.dto.ClaseVehiculoDTO;
import co.com.patios.service.dto.ColorVehiculoDTO;
import co.com.patios.service.dto.EstadoVehiculoDTO;
import co.com.patios.service.dto.MarcaVehiculoDTO;
import co.com.patios.service.dto.OrganismoTransitoDTO;
import co.com.patios.service.dto.PaisDTO;
import co.com.patios.service.dto.TipoIdentificacionDTO;

public class CatalogoServiceClient {

	private static CatalogoServiceClient INSTANCE;
	private static String HOST_END_POINT;
	private static final String HOST = "host_end_point";
	private static final String CATALOGOS = "catalogos";

	private CatalogoServiceClient() {
		// TODO Auto-generated constructor stub
	}

	public static CatalogoServiceClient getInstance() throws Exception {
		if (INSTANCE == null) {
			INSTANCE = new CatalogoServiceClient();
			ParamsBundle.getInstance().getEtiquetasParamsClient(ParamsBundle.service_client_patios);
			HOST_END_POINT = ParamsBundle.getInstance().getMapParamsServiceClientPatios().get(HOST);
		}

		return INSTANCE;
	}

	public List<PaisDTO> obtenerPaises() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uri = HOST_END_POINT + CATALOGOS + "/paises";
		try {
			ResponseEntity<List<PaisDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<PaisDTO>>() {
					});
			List<PaisDTO> listPaisDTO = response.getBody();
			return listPaisDTO;
		} catch (HttpServerErrorException e) {
			throw new Exception(e.getResponseBodyAsString() + " " + e.getMessage());
		}
	}

	public List<MarcaVehiculoDTO> obtenerMarcaVehiculos() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uri = HOST_END_POINT + CATALOGOS + "/marcaVehiculos";
		try {
			ResponseEntity<List<MarcaVehiculoDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<MarcaVehiculoDTO>>() {
					});
			List<MarcaVehiculoDTO> listMarcas = response.getBody();
			return listMarcas;
		} catch (HttpServerErrorException e) {
			throw new Exception(e.getResponseBodyAsString() + " " + e.getMessage());
		}
	}

	public List<ClaseVehiculoDTO> obtenerClaseVehiculos() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uri = HOST_END_POINT + CATALOGOS + "/claseVehiculos";
		try {
			ResponseEntity<List<ClaseVehiculoDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<ClaseVehiculoDTO>>() {
					});
			List<ClaseVehiculoDTO> list = response.getBody();
			return list;
		} catch (HttpServerErrorException e) {
			throw new Exception(e.getResponseBodyAsString() + " " + e.getMessage());
		}
	}

	public List<EstadoVehiculoDTO> obtenerEstadosVehiculos() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uri = HOST_END_POINT + CATALOGOS + "/estadosVehiculos";
		try {
			ResponseEntity<List<EstadoVehiculoDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<EstadoVehiculoDTO>>() {
					});
			List<EstadoVehiculoDTO> list = response.getBody();
			return list;
		} catch (HttpServerErrorException e) {
			throw new Exception(e.getResponseBodyAsString() + " " + e.getMessage());
		}
	}

	public List<OrganismoTransitoDTO> obtenerOrganismoTransito() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uri = HOST_END_POINT + CATALOGOS + "/organismos";
		try {
			ResponseEntity<List<OrganismoTransitoDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<OrganismoTransitoDTO>>() {
					});
			List<OrganismoTransitoDTO> list = response.getBody();
			return list;
		} catch (HttpServerErrorException e) {
			throw new Exception(e.getResponseBodyAsString() + " " + e.getMessage());
		}
	}

	public List<TipoIdentificacionDTO> obtenerTipoIdentificacion() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uri = HOST_END_POINT + CATALOGOS + "/tipoIdentificacion";
		try {
			ResponseEntity<List<TipoIdentificacionDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<TipoIdentificacionDTO>>() {
					});
			List<TipoIdentificacionDTO> list = response.getBody();
			return list;
		} catch (HttpServerErrorException e) {
			throw new Exception(e.getResponseBodyAsString() + " " + e.getMessage());
		}
	}

	public List<ColorVehiculoDTO> obtenerColorVehiculo() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uri = HOST_END_POINT + CATALOGOS + "/colores";
		try {
			ResponseEntity<List<ColorVehiculoDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<ColorVehiculoDTO>>() {
					});
			List<ColorVehiculoDTO> list = response.getBody();
			return list;
		} catch (HttpServerErrorException e) {
			throw new Exception(e.getResponseBodyAsString() + " " + e.getMessage());
		}
	}

}
