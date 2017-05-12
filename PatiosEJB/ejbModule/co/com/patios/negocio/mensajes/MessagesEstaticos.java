package co.com.patios.negocio.mensajes;

/**
 * clase encargada de manejar las variables de mensajes para la aplicacion.
 * 
 * @author jeio
 *
 */
public class MessagesEstaticos {

	
	private static MessagesEstaticos instance;
	private String existeUsuario = "Ya existe un usuario con la misma identificación!!!";
	private String registroExitoso = "El registro se completo satisfactoriamente!!!";
	private String credencialesErroneas = "Las credenciales son erroneas por favor verifique!!!";
	private String camposNumericos = "Campo debe ser Numerico, Verifique !!!";
	private String cabeceraRegistroExitoso = "Registro exitoso";
	private String vehiculoExisteEnPatio = "Existe un ingreso para la placa %s en el patio %s";
	private String mensajeCabeceraAlert = "Warning";
	private String edicionExitosa = "Edicion exitosa";
	private String mensajeCabeceraExito = "Exitoso";
	private String mensajeErrorGeneracionLiquidacion = "Error Generando volante de Liquidación, no se generó el consecutivo del volante";
	private String mensajeErrorGeneracionPdf = "Error generando el reporte pdf del volante de liquidación";
	private String mensajeEntradaVehiculosNoExiste = "No existe entrada para la placa %s consultada";
	private String mensajeValorPatioNoExiste = "No existe tarifa para el patio %s parametrizadas con fecha %s";
	private String mensajeSessionNoExiste = "Usted no ha iniciado sesion, digite por favor su usuario y password para acceder al sistema";
	private String mensajeEdicionExitosa = "Actualizacion exitosa";
	private String mensajeNoSeleccion = "Se deben seleccionar Registros !!!";
	private String mensajeAsignacionPatiosExitoso = "Se realizo la asignacion satisfactoria de los funcionarios con las siguientes identificaciones: %s al patio: %s";
	private String mensajeFuncionariosTienePatios = "Los funcionarios con las siguientes identificaciones: %s tienen el patio: %s asignado y vigente";
	private String mensajeCabeceraInformacion = "Información";
	private String mensajeCierreSession = "Su sesion ha finalizado, gracias por acceder al sistema";
	private String mensajeUsuarioNoAutorizado = "El usuario %s no esta autorizado para generar volante a la placa %s";
	private String mensajeVehiculoEstaEnPatio = "El vehículo con placa %s tiene ingreso al patio %s";

	private  MessagesEstaticos() {
		// TODO Auto-generated constructor stub
	}
	
	public static MessagesEstaticos getInstance() {
		if (instance == null) {
			instance = new MessagesEstaticos();
		}
		return instance;
	}

	/**
	 * @return the existeUsuario
	 */
	public String getExisteUsuario() {
		return existeUsuario;
	}

	/**
	 * @return the registroExitoso
	 */
	public String getRegistroExitoso() {
		return registroExitoso;
	}

	/**
	 * @return the credencialesErroneas
	 */
	public String getCredencialesErroneas() {
		return credencialesErroneas;
	}

	/**
	 * @return the camposNumericos
	 */
	public String getCamposNumericos() {
		return camposNumericos;
	}

	/**
	 * @return the cabeceraRegistroExitoso
	 */
	public String getCabeceraRegistroExitoso() {
		return cabeceraRegistroExitoso;
	}

	/**
	 * @return the vehiculoExisteEnPatio
	 */
	public String getVehiculoExisteEnPatio() {
		return vehiculoExisteEnPatio;
	}

	/**
	 * @return the mensajeCabeceraAlert
	 */
	public String getMensajeCabeceraAlert() {
		return mensajeCabeceraAlert;
	}

	/**
	 * @return the edicionExitosa
	 */
	public String getEdicionExitosa() {
		return edicionExitosa;
	}

	/**
	 * @return the mensajeCabeceraExito
	 */
	public String getMensajeCabeceraExito() {
		return mensajeCabeceraExito;
	}

	/**
	 * @return the mensajeErrorGeneracionLiquidacion
	 */
	public String getMensajeErrorGeneracionLiquidacion() {
		return mensajeErrorGeneracionLiquidacion;
	}

	/**
	 * @return the mensajeErrorGeneracionPdf
	 */
	public String getMensajeErrorGeneracionPdf() {
		return mensajeErrorGeneracionPdf;
	}

	/**
	 * @return the mensajeEntradaVehiculosNoExiste
	 */
	public String getMensajeEntradaVehiculosNoExiste() {
		return mensajeEntradaVehiculosNoExiste;
	}

	/**
	 * @return the mensajeValorPatioNoExiste
	 */
	public String getMensajeValorPatioNoExiste() {
		return mensajeValorPatioNoExiste;
	}

	/**
	 * @return the mensajeSessionNoExiste
	 */
	public String getMensajeSessionNoExiste() {
		return mensajeSessionNoExiste;
	}

	/**
	 * @return the mensajeEdicionExitosa
	 */
	public String getMensajeEdicionExitosa() {
		return mensajeEdicionExitosa;
	}

	/**
	 * @return the mensajeNoSeleccion
	 */
	public String getMensajeNoSeleccion() {
		return mensajeNoSeleccion;
	}

	/**
	 * @return the mensajeAsignacionPatiosExitoso
	 */
	public String getMensajeAsignacionPatiosExitoso() {
		return mensajeAsignacionPatiosExitoso;
	}

	/**
	 * @return the mensajeFuncionariosTienePatios
	 */
	public String getMensajeFuncionariosTienePatios() {
		return mensajeFuncionariosTienePatios;
	}

	/**
	 * @return the mensajeCabeceraInformacion
	 */
	public String getMensajeCabeceraInformacion() {
		return mensajeCabeceraInformacion;
	}

	/**
	 * @return the mensajeCierreSession
	 */
	public String getMensajeCierreSession() {
		return mensajeCierreSession;
	}

	/**
	 * @return the mensajeUsuarioNoAutorizado
	 */
	public String getMensajeUsuarioNoAutorizado() {
		return mensajeUsuarioNoAutorizado;
	}

	/**
	 * @return the mensajeVehiculoEstaEnPatio
	 */
	public String getMensajeVehiculoEstaEnPatio() {
		return mensajeVehiculoEstaEnPatio;
	}
	
	
}
