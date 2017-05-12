package co.com.patios.mb.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class Utilidades {

	private static final String PATRON = "#,###";
	public static final String DIRECTORIO_TEMP_USUARIO = System.getProperty("java.io.tmpdir");
	public static final String DIRECTORIO_ACTUAL = System.getProperty("user.dir");

	public static Object getManagedBean(String beanName) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext elc = fc.getELContext();
		ExpressionFactory ef = fc.getApplication().getExpressionFactory();
		ValueExpression ve = ef.createValueExpression(elc, getJsfEl(beanName), Object.class);
		try {
			return ve.getValue(elc);
		} catch (Exception e) {
			// log.log(Level.SEVERE, "could not get value for bean " + beanName,
			// e);
		}
		return null;
	}

	private static String getJsfEl(String value) {
		return "#{" + value + "}";
	}

	/**
	 * obtiene la ruta absoluta del servidor, retorna la ruta del war en donde
	 * se encuentra el empaquetado de la aplicacion Web
	 * 
	 * @return
	 */
	public static String obtenerRutaAbsolutaServidor() {
		ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String realPath = ctx.getRealPath("/");
		return realPath;
	}

	/**
	 * obtiene la fecha actual en tipo de dato Calendar
	 * 
	 * @return
	 */
	public static Calendar obtenerFechaActual() {
		Date dateActual = new Date();
		Calendar calendarActual = Calendar.getInstance();
		calendarActual.setTime(dateActual);
		return calendarActual;
	}

	/**
	 * obtiene la hora con segundo del sistema
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String obtenerHora() {
		Time time = new Time(new Date().getTime());
		String hora = time.getHours() + "_" + time.getMinutes() + "_" + time.getSeconds();
		return hora.trim().toString();

	}

	/**
	 * abre archivo del equipo de trabajo
	 * 
	 * @param rutaFileName,
	 *            ruta del archivo
	 */
	public static void abrirArchivosEquipo(String rutaFileName) {
		try {
			File path = new File(rutaFileName);
			Desktop.getDesktop().open(path);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * obtiene la session de una managed bean pasada por parametro
	 * 
	 * @return
	 */
	public static Object obtenerManagedBean(String managed) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ExternalContext extCtx = ctx.getExternalContext();
		Map<String, Object> sessionMap = extCtx.getSessionMap();
		Object managedBean = sessionMap.get(managed);
		return managedBean;
	}

	/**
	 * realiza la validacion de inicio de session de un usuario
	 * 
	 * @param rutaDirigir,
	 *            ruta a la cual se dirigirá al usuario en caso de no estar
	 *            logueado
	 */
	// public static IngresoMB validarSessionUsuario(String rutaDirigir){
	// IngresoMB ingresoMB = sessionUsuario();
	// if(ingresoMB == null){
	// FacesContext facesContext = FacesContext.getCurrentInstance();
	// try {
	// facesContext.getExternalContext().redirect(rutaDirigir);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// return ingresoMB;
	// }

	/**
	 * Formato numero a un string
	 * 
	 * @param numero
	 * @return
	 */
	public static String formatearNumero(String numero) {
		if (Integer.parseInt(numero) == 0) {
			return "0";
		} else {
			DecimalFormat format = new DecimalFormat(PATRON);
			numero = format.format(Double.parseDouble(numero));
			return numero;
		}

	}

	/**
	 * toma dos valores, los compara con la funcion equals y retorna false en
	 * caso que sean diferentes
	 * 
	 * @param texto1
	 * @param texto2
	 * @return
	 */
	public static boolean compararTexto(String texto1, String texto2) {
		if (!texto1.equals(texto2)) {
			return false;
		}

		return true;
	}

	/**
	 * validacion de numeros
	 * 
	 * @param value
	 * @return
	 */
	public static boolean validarNumerico(String value) {
		try {
			Long.parseLong(value);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/**
	 * realiza la conversion de cualquier valor(String) a mayusculas
	 * 
	 * @param value
	 * @return
	 */
	public static String convertirMayusculas(String value) {
		if (value != null && !value.trim().isEmpty()) {
			String mayuscula = value.toUpperCase();
			return mayuscula;
		}
		return value;
	}

	/**
	 * obtiene el primer valor de un map con llave y value String
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String obtenerPrimerValorMarcasVehiculos(Map<String, String> map) {
		Iterator it = map.keySet().iterator();
		String key = "";
		String value = "";
		while (it.hasNext()) {
			key = "" + it.next();
			value = map.get(key);
			break;
		}

		return value;
	}

	public void removeSessionBean(final String beanName) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(beanName);
	}

}
