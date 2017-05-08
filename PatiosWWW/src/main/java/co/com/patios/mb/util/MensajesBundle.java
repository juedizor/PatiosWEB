package co.com.patios.mb.util;

import java.util.ResourceBundle;

public class MensajesBundle {
	
	private static MensajesBundle mensajesBundle;
	public final String ERROR_SISTEMA = getMensaje("bundle/Mensajes", "error_sistema");
	public final String CABECERA_ERROR = getMensaje("bundle/Mensajes", "cabecera_error");
	public final String CREDENCIALES_ERRONEAS = getMensaje("bundle/Mensajes", "credenciales_erroneas");

	private MensajesBundle() {
		
	}
	
	public static MensajesBundle getInstance(){
		if(mensajesBundle == null){
			mensajesBundle = new MensajesBundle();
		}
		return mensajesBundle;
	}
	
	/**
	 * retorna el mensaje del archiv properties enviado por parametro relacionado a su nombre de etiqueta
	 * @param propertiesName, nombre del archivo donde va a buscar la etiqueta
	 * @param etiqueta, nombre de la etiqueta donde se encuentra el mensaje
	 * @return
	 */
	private static String getMensaje(String propertiesName, String etiqueta){
		return ResourceBundle.getBundle(propertiesName).getString(etiqueta);
	}

}
