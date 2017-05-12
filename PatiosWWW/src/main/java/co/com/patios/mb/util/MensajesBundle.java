package co.com.patios.mb.util;

import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MensajesBundle {

	private static MensajesBundle mensajesBundle;
	private ResourceBundle resourceBundle;
	public static String msg = "bundle/Mensajes";
	private Map<String, String> map;

	private MensajesBundle() {

	}

	public static MensajesBundle getInstance() {
		if (mensajesBundle == null) {
			mensajesBundle = new MensajesBundle();
		}
		return mensajesBundle;
	}
	
	private void setProperties(String pathProperties) throws Exception {
		try {
			resourceBundle = ResourceBundle.getBundle(pathProperties);
		} catch (Exception e) {
			throw e;
		}
	}

	private ResourceBundle getProperites(String pathProperties) throws Exception {
		setProperties(pathProperties);
		return resourceBundle;
	}

	public Map<String, String> getEtiquetas(String pathProperties) throws Exception {
		getProperites(pathProperties);
		Enumeration<String> enums = resourceBundle.getKeys();
		String key;
		map = new LinkedHashMap<>();
		while (enums.hasMoreElements()) {
			key = enums.nextElement();
			map.put(key, resourceBundle.getString(key));
		}
		return map;
	}

	/**
	 * @return the map
	 */
	public Map<String, String> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	

}
