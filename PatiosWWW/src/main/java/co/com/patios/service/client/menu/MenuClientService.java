package co.com.patios.service.client.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import co.com.patios.mb.util.ParamsBundle;
import co.com.patios.service.dto.MenuDTO;
import co.com.patios.service.dto.MenuItemDTO;

public class MenuClientService {

	private static MenuClientService INSTANCE;
	private static String HOST_END_POINT;
	private static final String HOST = "host_end_point";

	private MenuClientService() {
		// TODO Auto-generated constructor stub
	}

	public static MenuClientService getInstance() throws Exception {
		if (INSTANCE == null) {
			INSTANCE = new MenuClientService();
			ParamsBundle.getInstance().getEtiquetas(ParamsBundle.service_client_patios);
			HOST_END_POINT = ParamsBundle.getInstance().getMapParamsServiceClientPatios().get(HOST);
		}
		return INSTANCE;
	}

	public List<MenuDTO> consultarMenus(int idTipoMenu) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uri = HOST_END_POINT + "/menu/{idTipoMenu}";
		Map<String, String> mapParams = new HashMap<>();
		mapParams.put("idTipoMenu", "" + idTipoMenu);
		try {
			ResponseEntity<List<MenuDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<MenuDTO>>() {
					}, mapParams);

			List<MenuDTO> listMenuDTO = response.getBody();
			return listMenuDTO;
		} catch (HttpServerErrorException e) {
			throw new Exception(e.getResponseBodyAsString() + " " + e.getMessage());
		}

	}

	public List<MenuItemDTO> consultarMenuItems(int idMenu) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String uri = HOST_END_POINT + "menu/menuItem/{idMenu}";
		Map<String, String> mapParams = new HashMap<>();
		mapParams.put("idMenu", "" + idMenu);
		try {
			ResponseEntity<List<MenuItemDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<MenuItemDTO>>() {
					}, mapParams);

			List<MenuItemDTO> listMenuDTO = response.getBody();
			return listMenuDTO;
		} catch (HttpServerErrorException e) {
			throw new Exception(e.getResponseBodyAsString() + " " + e.getMessage());
		}

	}

}
