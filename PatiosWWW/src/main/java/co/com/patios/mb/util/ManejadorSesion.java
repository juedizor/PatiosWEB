package co.com.patios.mb.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ManejadorSesion {
	
	
	
	/**
	 * Si ya existe una sesion la invalida y crea una nueva
	 * 
	 * @param unRequest
	 *            Objeto de la peticion
	 * @return Un objeto HttpSession
	 */
	public HttpSession crearSesion(HttpServletRequest unRequest) {
		HttpSession miSesion = unRequest.getSession(false);
		if (miSesion != null) {
			miSesion.invalidate();
		}
		miSesion = unRequest.getSession(true);
		return miSesion;
	}

	/**
	 * Verifica que exista una sesion
	 * 
	 * @param req
	 *            Objeto Peticion
	 * @return si existe una sesion retorna un objeto HttpSession con los datos
	 *         de la sesion, si no existe la sesion el objeto es null.
	 * 
	 */
	public HttpSession obtenerSesion(HttpServletRequest unRequest) {
		HttpSession miSesion = unRequest.getSession(false);
		return miSesion;
	}

	/**
	 * Metodo utilizado para agregar un objeto a sesion
	 * 
	 * @param req
	 *            Objeto HttpServletRequest
	 * @param nombreAtrib
	 *            Nombre con el que se identificar el objeto dentro de la sesion
	 * @param objeto
	 *            Objeto que se desea agregar a la sesion
	 * 
	 */
	public void agregarObjetoSesion(HttpServletRequest unRequest, String unNombre, Object unObjeto) {
		HttpSession miSesion = obtenerSesion(unRequest);
		if (miSesion == null)
			miSesion = crearSesion(unRequest);
		miSesion.setAttribute(unNombre, unObjeto);
	}

	/**
	 * Metodo para sacar objetos de sesion
	 * 
	 * @param unNombreObjeto
	 *            Nombre del objeto en la sesion
	 * @param unRequest
	 * @return Objeto solicitado que se encuentra almacenado en la sesion
	 */
	public Object extraerObjetoSesion(String unNombreObjeto, HttpServletRequest unRequest) {
		/*
		 * se crea un objeto de respuesta
		 */
		Object miObjeto = null;
		/*
		 * se extrae el objeto HttpSession que contiene toda la informacion de
		 * la sesion iniciada
		 */
		HttpSession miSesion = unRequest.getSession(false);
		/*
		 * si la sesion es diferente de null obtenemos el objeto de sesion por
		 * el nombre solicitado(unNombreObjeto)
		 */
		if (miSesion != null) {
			miObjeto = miSesion.getAttribute(unNombreObjeto);
		}

		return miObjeto;
	}

	/**
	 * Metodo para eliminar objetos de sesion
	 * 
	 * @param unNombreObjeto
	 *            Nombre del objeto en la sesion
	 * @param unRequest
	 */
	public void removerObjetoSesion(String unNombreObjeto, HttpServletRequest unRequest) {
		HttpSession sesion = unRequest.getSession(false);
		sesion.removeAttribute(unNombreObjeto);
	}

	/**
	 * Obtener los nombres de las llaves de los objetos en sesion
	 * 
	 * @param unRequest
	 * @return lista de llaves
	 */
	@SuppressWarnings("unchecked")
	public Enumeration<String> obtenerLlavesObjetos(HttpServletRequest unRequest) {
		HttpSession sesion = unRequest.getSession(false);
		return sesion.getAttributeNames();
	}

	/**
	 * Remover los MBs de la sesion para que al finalizar una accion en forma
	 * exitosa se vuelva al estado inicial de los MBs
	 * 
	 * @param unRequest
	 */
	public void removerManagedBeansSesion(HttpServletRequest unRequest) {
		Enumeration<String> e = obtenerLlavesObjetos(unRequest);

		// Sacar de la sesion todos los MB que corresponda
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			if (key.endsWith("MB") && !key.equals("menuMB") && !key.equals("catalogoComparendoMB") && !key.equals("catalogoCarteraMB")
					&& !key.equals("catalogoGeneralMB") && !key.equals("catalogoDireccionMB") && !key.equals("catalogoFinanciacionMB")) {
				removerObjetoSesion(key, unRequest);
			}

		}

	}
}
