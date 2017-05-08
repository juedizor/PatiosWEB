package co.com.patios.mb.util;


/**
 * clase encargada de manejar las variables de mensajes para la aplicacion. 
 * @author jeio
 *
 */
public class MessagesEstaticos {
	
	private static String existeUsuario = "Ya existe un usuario con la misma identificación!!!";
	private static String registroExitoso = "El registro se completo satisfactoriamente!!!";
	private static String credencialesErroneas = "Las credenciales son erroneas por favor verifique!!!";
	private static String camposNumericos = "Campo debe ser Numerico, Verifique !!!";
	private static String cabeceraRegistroExitoso = "Registro exitoso";
	private static String vehiculoExisteEnPatio = "Existe un ingreso para la placa %s en el patio %s";
	private static String mensajeCabeceraAlert = "Warning";
	private static String edicionExitosa = "Edicion exitosa";
	private static String mensajeCabeceraExito = "Exitoso";
	private static String mensajeErrorGeneracionLiquidacion = "Error Generando volante de Liquidación, no se generó el consecutivo del volante";
	private static String mensajeErrorGeneracionPdf = "Error generando el reporte pdf del volante de liquidación";
	private static String mensajeEntradaVehiculosNoExiste = "No existe entrada para la placa %s consultada";
	private static String mensajeValorPatioNoExiste = "No existe tarifa para el patio %s parametrizadas con fecha %s";
	private static String mensajeSessionNoExiste = "Usted no ha iniciado sesion, digite por favor su usuario y password para acceder al sistema";
	private static String mensajeEdicionExitosa = "Actualizacion exitosa";
	private static String mensajeNoSeleccion = "Se deben seleccionar Registros !!!";
	private static String mensajeAsignacionPatiosExitoso = "Se realizo la asignacion satisfactoria de los funcionarios con las siguientes identificaciones: %s al patio: %s";
	private static String mensajeFuncionariosTienePatios = "Los funcionarios con las siguientes identificaciones: %s tienen el patio: %s asignado y vigente";
	private static String mensajeCabeceraInformacion = "Información";
	private static String mensajeCierreSession = "Su sesion ha finalizado, gracias por acceder al sistema";
	private static String mensajeUsuarioNoAutorizado = "El usuario %s no esta autorizado para generar volante a la placa %s";
	private static String mensajeVehiculoEstaEnPatio = "El vehículo con placa %s tiene ingreso al patio %s";
	
	
	public MessagesEstaticos() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * @return the existeUsuario
	 */
	public static String getExisteUsuario() {
		return existeUsuario;
	}
	/**
	 * @param existeUsuario the existeUsuario to set
	 */
	public static void setExisteUsuario(String existeUsuario) {
		MessagesEstaticos.existeUsuario = existeUsuario;
	}
	/**
	 * @return the registroExitoso
	 */
	public static String getRegistroExitoso() {
		return registroExitoso;
	}
	/**
	 * @param registroExitoso the registroExitoso to set
	 */
	public static void setRegistroExitoso(String registroExitoso) {
		MessagesEstaticos.registroExitoso = registroExitoso;
	}



	/**
	 * @return the credencialesErroneas
	 */
	public static String getCredencialesErroneas() {
		return credencialesErroneas;
	}



	/**
	 * @param credencialesErroneas the credencialesErroneas to set
	 */
	public static void setCredencialesErroneas(String credencialesErroneas) {
		MessagesEstaticos.credencialesErroneas = credencialesErroneas;
	}



	/**
	 * @return the camposNumericos
	 */
	public static String getCamposNumericos() {
		return camposNumericos;
	}



	/**
	 * @param camposNumericos the camposNumericos to set
	 */
	public static void setCamposNumericos(String camposNumericos) {
		MessagesEstaticos.camposNumericos = camposNumericos;
	}



	/**
	 * @return the cabeceraRegistroExitoso
	 */
	public static String getCabeceraRegistroExitoso() {
		return cabeceraRegistroExitoso;
	}



	/**
	 * @param cabeceraRegistroExitoso the cabeceraRegistroExitoso to set
	 */
	public static void setCabeceraRegistroExitoso(String cabeceraRegistroExitoso) {
		MessagesEstaticos.cabeceraRegistroExitoso = cabeceraRegistroExitoso;
	}



	/**
	 * @return the vehiculoExisteEnPatio
	 */
	public static String getVehiculoExisteEnPatio() {
		return vehiculoExisteEnPatio;
	}



	/**
	 * @param vehiculoExisteEnPatio the vehiculoExisteEnPatio to set
	 */
	public static void setVehiculoExisteEnPatio(String vehiculoExisteEnPatio) {
		MessagesEstaticos.vehiculoExisteEnPatio = vehiculoExisteEnPatio;
	}



	/**
	 * @return the mensajeCabeceraAlert
	 */
	public static String getMensajeCabeceraAlert() {
		return mensajeCabeceraAlert;
	}



	/**
	 * @param mensajeCabeceraAlert the mensajeCabeceraAlert to set
	 */
	public static void setMensajeCabeceraAlert(String mensajeCabeceraAlert) {
		MessagesEstaticos.mensajeCabeceraAlert = mensajeCabeceraAlert;
	}



	/**
	 * @return the edicionExitosa
	 */
	public static String getEdicionExitosa() {
		return edicionExitosa;
	}



	/**
	 * @param edicionExitosa the edicionExitosa to set
	 */
	public static void setEdicionExitosa(String edicionExitosa) {
		MessagesEstaticos.edicionExitosa = edicionExitosa;
	}



	/**
	 * @return the mensajeCabeceraExito
	 */
	public static String getMensajeCabeceraExito() {
		return mensajeCabeceraExito;
	}



	/**
	 * @param mensajeCabeceraExito the mensajeCabeceraExito to set
	 */
	public static void setMensajeCabeceraExito(String mensajeCabeceraExito) {
		MessagesEstaticos.mensajeCabeceraExito = mensajeCabeceraExito;
	}



	/**
	 * @return the mensajeErrorGeneracionLiquidacion
	 */
	public static String getMensajeErrorGeneracionLiquidacion() {
		return mensajeErrorGeneracionLiquidacion;
	}



	/**
	 * @param mensajeErrorGeneracionLiquidacion the mensajeErrorGeneracionLiquidacion to set
	 */
	public static void setMensajeErrorGeneracionLiquidacion(
			String mensajeErrorGeneracionLiquidacion) {
		MessagesEstaticos.mensajeErrorGeneracionLiquidacion = mensajeErrorGeneracionLiquidacion;
	}



	/**
	 * @return the mensajeErrorGeneracionPdf
	 */
	public static String getMensajeErrorGeneracionPdf() {
		return mensajeErrorGeneracionPdf;
	}



	/**
	 * @param mensajeErrorGeneracionPdf the mensajeErrorGeneracionPdf to set
	 */
	public static void setMensajeErrorGeneracionPdf(String mensajeErrorGeneracionPdf) {
		MessagesEstaticos.mensajeErrorGeneracionPdf = mensajeErrorGeneracionPdf;
	}



	/**
	 * @return the mensajeEntradaVehiculosNoExiste
	 */
	public static String getMensajeEntradaVehiculosNoExiste() {
		return mensajeEntradaVehiculosNoExiste;
	}



	/**
	 * @param mensajeEntradaVehiculosNoExiste the mensajeEntradaVehiculosNoExiste to set
	 */
	public static void setMensajeEntradaVehiculosNoExiste(
			String mensajeEntradaVehiculosNoExiste) {
		MessagesEstaticos.mensajeEntradaVehiculosNoExiste = mensajeEntradaVehiculosNoExiste;
	}



	/**
	 * @return the mensajeValorPatioNoExiste
	 */
	public static String getMensajeValorPatioNoExiste() {
		return mensajeValorPatioNoExiste;
	}



	/**
	 * @param mensajeValorPatioNoExiste the mensajeValorPatioNoExiste to set
	 */
	public static void setMensajeValorPatioNoExiste(String mensajeValorPatioNoExiste) {
		MessagesEstaticos.mensajeValorPatioNoExiste = mensajeValorPatioNoExiste;
	}



	public static String getMensajeSessionNoExiste() {
		return mensajeSessionNoExiste;
	}



	public static void setMensajeSessionNoExiste(String mensajeSessionNoExiste) {
		MessagesEstaticos.mensajeSessionNoExiste = mensajeSessionNoExiste;
	}



	public static String getMensajeEdicionExitosa() {
		return mensajeEdicionExitosa;
	}



	public static void setMensajeEdicionExitosa(String mensajeEdicionExitosa) {
		MessagesEstaticos.mensajeEdicionExitosa = mensajeEdicionExitosa;
	}



	/**
	 * @return the mensajeNoSeleccion
	 */
	public static String getMensajeNoSeleccion() {
		return mensajeNoSeleccion;
	}



	/**
	 * @param mensajeNoSeleccion the mensajeNoSeleccion to set
	 */
	public static void setMensajeNoSeleccion(String mensajeNoSeleccion) {
		MessagesEstaticos.mensajeNoSeleccion = mensajeNoSeleccion;
	}



	/**
	 * @return the mensajeAsignacionPatiosExitoso
	 */
	public static String getMensajeAsignacionPatiosExitoso() {
		return mensajeAsignacionPatiosExitoso;
	}



	/**
	 * @param mensajeAsignacionPatiosExitoso the mensajeAsignacionPatiosExitoso to set
	 */
	public static void setMensajeAsignacionPatiosExitoso(
			String mensajeAsignacionPatiosExitoso) {
		MessagesEstaticos.mensajeAsignacionPatiosExitoso = mensajeAsignacionPatiosExitoso;
	}



	/**
	 * @return the mensajeFuncionariosTienePatios
	 */
	public static String getMensajeFuncionariosTienePatios() {
		return mensajeFuncionariosTienePatios;
	}



	/**
	 * @param mensajeFuncionariosTienePatios the mensajeFuncionariosTienePatios to set
	 */
	public static void setMensajeFuncionariosTienePatios(
			String mensajeFuncionariosTienePatios) {
		MessagesEstaticos.mensajeFuncionariosTienePatios = mensajeFuncionariosTienePatios;
	}



	/**
	 * @return the mensajeCabeceraInformacion
	 */
	public static String getMensajeCabeceraInformacion() {
		return mensajeCabeceraInformacion;
	}



	/**
	 * @param mensajeCabeceraInformacion the mensajeCabeceraInformacion to set
	 */
	public static void setMensajeCabeceraInformacion(
			String mensajeCabeceraInformacion) {
		MessagesEstaticos.mensajeCabeceraInformacion = mensajeCabeceraInformacion;
	}



	/**
	 * @return the mensajeCierreSession
	 */
	public static String getMensajeCierreSession() {
		return mensajeCierreSession;
	}



	/**
	 * @param mensajeCierreSession the mensajeCierreSession to set
	 */
	public static void setMensajeCierreSession(String mensajeCierreSession) {
		MessagesEstaticos.mensajeCierreSession = mensajeCierreSession;
	}



	/**
	 * @return the mensajeUsuarioNoAutorizado
	 */
	public static String getMensajeUsuarioNoAutorizado() {
		return mensajeUsuarioNoAutorizado;
	}



	/**
	 * @param mensajeUsuarioNoAutorizado the mensajeUsuarioNoAutorizado to set
	 */
	public static void setMensajeUsuarioNoAutorizado(
			String mensajeUsuarioNoAutorizado) {
		MessagesEstaticos.mensajeUsuarioNoAutorizado = mensajeUsuarioNoAutorizado;
	}



	/**
	 * @return the mensajeVehiculoEstaEnPatio
	 */
	public static String getMensajeVehiculoEstaEnPatio() {
		return mensajeVehiculoEstaEnPatio;
	}



	/**
	 * @param mensajeVehiculoEstaEnPatio the mensajeVehiculoEstaEnPatio to set
	 */
	public static void setMensajeVehiculoEstaEnPatio(
			String mensajeVehiculoEstaEnPatio) {
		MessagesEstaticos.mensajeVehiculoEstaEnPatio = mensajeVehiculoEstaEnPatio;
	}
	

}
