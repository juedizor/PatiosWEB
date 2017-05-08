//package co.com.patios.mb.controller;
//
//import java.math.BigDecimal;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.component.UIComponent;
//import javax.faces.component.UIInput;
//import javax.faces.context.FacesContext;
//import javax.faces.event.ComponentSystemEvent;
//import javax.faces.validator.ValidatorException;
//
//import co.com.patios.ejb.controller.TipoIdentificacionEJB;
//import co.com.patios.ejb.controller.UsuarioEJB;
//import co.com.patios.entity.Ciudad;
//import co.com.patios.entity.Persona;
//import co.com.patios.entity.TipoIdentificacion;
//import co.com.patios.entity.Usuario;
//import co.com.patios.mb.util.MessagesEstaticos;
//
//@ManagedBean(name="usuarioMB")
//@RequestScoped
//public class UsuariosMB {
//	
//	private Persona persona;
//	private Usuario usuario;
//	private TipoIdentificacion tipoIdentificacion;
//	private Ciudad ciudad;
//	
//	
//	private String numeroIdentificacion;
//	private String primerNombrePersona;
//	private String segundoNombrePersona;
//	private String primerApellidoPersona;
//	private String segundoApellidoPersona;
//	private String nombreComercialPersona;
//	private String loginUsuario;
//	private String claveUsuario;
//	private String claveUsuario2;
//	
//	
//	private UIComponent components;
//	
//	
//	// maneja el onemenu de los tipos de identificacion
//	private String idTipoIdentificacion;
//	private Map<String, String> tiposIdentificacion = new LinkedHashMap<String, String>();
//	
//	// maneja el onemenu de los paises
//	private String idPais;
//	private Map<String, String> paises = new LinkedHashMap<String, String>();
//	
//	// maneja el onemenu de los departamentos
//	private String idDepartamento;
//	private Map<String, String> departamentos = new LinkedHashMap<String, String>();
//	
//	// maneja el onemenu de las ciudades
//	private String idCiudad;
//	private Map<String, String> ciudades = new LinkedHashMap<String, String>();
//	
//	
//	
//	
//	@EJB
//	TipoIdentificacionEJB tipoIdentificacionEJB;
//	
//	
//	
//	public UsuariosMB() {
//		usuario = new Usuario();
//		tipoIdentificacion = new TipoIdentificacion();
//		persona = new Persona();
//		ciudad = new Ciudad();
//	}
//	
//	
//	@EJB
//	UsuarioEJB usuarioEJB;
//	
//	@PostConstruct
//	public void cargarTiposIdentificacion(){
//		setTiposIdentificacion(tipoIdentificacionEJB.listTiposIdentificacion());
//	}
//	
//	/**
//	 * realiza el insert de un usuario al sistema
//	 */
//	public void insertarNuevoUsuario(){
//		FacesContext context = FacesContext.getCurrentInstance();
//		
//		//message es una variable de tipo FacesMessage, con la cual se inicia la creacion de cualquier mensaje en la pagina 
//		//RegistroUsuario.xhtml
//		FacesMessage message = new FacesMessage();
//		// input es una variable de tipo UIInput, la cual se utiliza con el fin de buscar un componente especifico dentro de la 
//		// pagina RegistroUsuario.xhtml
//		UIInput input = (UIInput) getComponents().findComponent("mensajes");
//		// idMessage, variable de tipo String en donde con la variable input se captura el id del componente que se buscó
//		String idMessage = input.getClientId();
//		// con el metodo setUsuario se llena el objeto de la clase Usuario con los datos registrados en la pagina RegistroUsuario.xhtml
//		setUsuarioPersona();
//		if (!(usuarioEJB.buscarUsuario(new BigDecimal(0)) == null)){
//			// message.setSeverity(), modifica el modo del mensaje. Puede ser informativo, error,  entre otros. 
//			message.setSeverity(FacesMessage.SEVERITY_INFO);
//			// detalle del mensaje en la pagina xhtml 
//			message.setDetail(MessagesEstaticos.getExisteUsuario());
//			message.setSummary(MessagesEstaticos.getExisteUsuario());
//			// agrega el mensaje al contexto de la pagina. 
//			context.addMessage(idMessage, message);
//			usuario = new Usuario();
//		}else{
//			usuarioEJB.registrarUsuario(usuario);
//			limpiar();
//			usuario = new Usuario();
//			message.setSeverity(FacesMessage.SEVERITY_INFO);
//			message.setDetail(MessagesEstaticos.getRegistroExitoso());
//			message.setSummary(MessagesEstaticos.getRegistroExitoso());
//			context.addMessage(idMessage, message);
//			
//		}
//	}
//	
//	/**
//	 * evento que se activa al momento de realizar el envio del formulario y captura todos los componentes de una pagina, 
//	 * despues puedes ser usado para capturar el valor o el id del componente
//	 * @param event
//	 */
//	public void setIdComponent(ComponentSystemEvent event){
//		setComponents(event.getComponent());
//	}
//	
//	
//	
//	/**
//	 * realiza la validacion de las dos contraseñas en el formulario de registro
//	 * @param context
//	 * @param component
//	 * @param value
//	 * @throws ValidatorException
//	 */
////	public void validateSamePassword(ComponentSystemEvent event){
////		FacesContext context = FacesContext.getCurrentInstance();
////		UIComponent components = event.getComponent();
////		
////		UIInput uiInputPassword = (UIInput) components.findComponent("clave_usuario");
////		
////		String password = uiInputPassword.getLocalValue() == null ? "": uiInputPassword.getLocalValue().toString();
////		String passwordId = uiInputPassword.getClientId();
////		
////		UIInput uiInputConfirmPassword = (UIInput) components.findComponent("clave_usuario2");
////		String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? "": uiInputConfirmPassword.getLocalValue().toString();
////		  
////		
////		if(!Utilidades.compararTexto(password, confirmPassword)){
////			FacesMessage message = new FacesMessage();
////			message.setSeverity(FacesMessage.SEVERITY_ERROR);
////			message.setDetail("Las contraseñas no son iguales, verifique");
////			message.setSummary("Las contraseñas no son iguales, verifique");
////			context.addMessage(passwordId, message);
////			context.renderResponse();
////		}
////		
////	}
//	
//	
//	public void limpiar(){
//		
//	}
//	
//	
//	
//	/**
//	 * set de lo valores necesarios para crear un usuario
//	 */
//	private void setUsuarioPersona(){
//		tipoIdentificacion = new TipoIdentificacion();
//		ciudad = new Ciudad();
//		tipoIdentificacion = tipoIdentificacionEJB.consultarTipoIdentificacionPorId(Integer.parseInt(idTipoIdentificacion));
//		
//		if(tipoIdentificacion != null){
//			persona.setTipoIdentificacion(tipoIdentificacion);
//			
//			usuario.setClaveUsuario(claveUsuario);
//			
//			
//			
//		}
//	}
//	
//
//	
//	
//
//	/**
//	 * @return the usuario
//	 */
//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//
//	/**
//	 * @param usuario the usuario to set
//	 */
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
//
//	/**
//	 * @return the components
//	 */
//	public UIComponent getComponents() {
//		return components;
//	}
//
//	/**
//	 * @param components the components to set
//	 */
//	public void setComponents(UIComponent components) {
//		this.components = components;
//	}
//
//	public String getIdTipoIdentificacion() {
//		return idTipoIdentificacion;
//	}
//
//	public void setIdTipoIdentificacion(String idTipoIdentificacion) {
//		this.idTipoIdentificacion = idTipoIdentificacion;
//	}
//
//	public Map<String, String> getTiposIdentificacion() {
//		return tiposIdentificacion;
//	}
//
//	public void setTiposIdentificacion(Map<String, String> tiposIdentificacion) {
//		this.tiposIdentificacion = tiposIdentificacion;
//	}
//
//	public TipoIdentificacion getTipoIdentificacion() {
//		return tipoIdentificacion;
//	}
//
//	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
//		this.tipoIdentificacion = tipoIdentificacion;
//	}
//
//	/**
//	 * @return the persona
//	 */
//	public Persona getPersona() {
//		return persona;
//	}
//
//	/**
//	 * @param persona the persona to set
//	 */
//	public void setPersona(Persona persona) {
//		this.persona = persona;
//	}
//
//	/**
//	 * @return the ciudad
//	 */
//	public Ciudad getCiudad() {
//		return ciudad;
//	}
//
//	/**
//	 * @param ciudad the ciudad to set
//	 */
//	public void setCiudad(Ciudad ciudad) {
//		this.ciudad = ciudad;
//	}
//
//	/**
//	 * @return the numeroIdentificacion
//	 */
//	public String getNumeroIdentificacion() {
//		return numeroIdentificacion;
//	}
//
//	/**
//	 * @param numeroIdentificacion the numeroIdentificacion to set
//	 */
//	public void setNumeroIdentificacion(String numeroIdentificacion) {
//		this.numeroIdentificacion = numeroIdentificacion;
//	}
//
//	/**
//	 * @return the primerNombrePersona
//	 */
//	public String getPrimerNombrePersona() {
//		return primerNombrePersona;
//	}
//
//	/**
//	 * @param primerNombrePersona the primerNombrePersona to set
//	 */
//	public void setPrimerNombrePersona(String primerNombrePersona) {
//		this.primerNombrePersona = primerNombrePersona;
//	}
//
//	/**
//	 * @return the segundoNombrePersona
//	 */
//	public String getSegundoNombrePersona() {
//		return segundoNombrePersona;
//	}
//
//	/**
//	 * @param segundoNombrePersona the segundoNombrePersona to set
//	 */
//	public void setSegundoNombrePersona(String segundoNombrePersona) {
//		this.segundoNombrePersona = segundoNombrePersona;
//	}
//
//	/**
//	 * @return the primerApellidoPersona
//	 */
//	public String getPrimerApellidoPersona() {
//		return primerApellidoPersona;
//	}
//
//	/**
//	 * @param primerApellidoPersona the primerApellidoPersona to set
//	 */
//	public void setPrimerApellidoPersona(String primerApellidoPersona) {
//		this.primerApellidoPersona = primerApellidoPersona;
//	}
//
//	/**
//	 * @return the segundoApellidoPersona
//	 */
//	public String getSegundoApellidoPersona() {
//		return segundoApellidoPersona;
//	}
//
//	/**
//	 * @param segundoApellidoPersona the segundoApellidoPersona to set
//	 */
//	public void setSegundoApellidoPersona(String segundoApellidoPersona) {
//		this.segundoApellidoPersona = segundoApellidoPersona;
//	}
//
//	/**
//	 * @return the nombreComercialPersona
//	 */
//	public String getNombreComercialPersona() {
//		return nombreComercialPersona;
//	}
//
//	/**
//	 * @param nombreComercialPersona the nombreComercialPersona to set
//	 */
//	public void setNombreComercialPersona(String nombreComercialPersona) {
//		this.nombreComercialPersona = nombreComercialPersona;
//	}
//
//	/**
//	 * @return the loginUsuario
//	 */
//	public String getLoginUsuario() {
//		return loginUsuario;
//	}
//
//	/**
//	 * @param loginUsuario the loginUsuario to set
//	 */
//	public void setLoginUsuario(String loginUsuario) {
//		this.loginUsuario = loginUsuario;
//	}
//
//	/**
//	 * @return the idPais
//	 */
//	public String getIdPais() {
//		return idPais;
//	}
//
//	/**
//	 * @param idPais the idPais to set
//	 */
//	public void setIdPais(String idPais) {
//		this.idPais = idPais;
//	}
//
//	/**
//	 * @return the paises
//	 */
//	public Map<String, String> getPaises() {
//		return paises;
//	}
//
//	/**
//	 * @param paises the paises to set
//	 */
//	public void setPaises(Map<String, String> paises) {
//		this.paises = paises;
//	}
//
//	/**
//	 * @return the idDepartamento
//	 */
//	public String getIdDepartamento() {
//		return idDepartamento;
//	}
//
//	/**
//	 * @param idDepartamento the idDepartamento to set
//	 */
//	public void setIdDepartamento(String idDepartamento) {
//		this.idDepartamento = idDepartamento;
//	}
//
//	/**
//	 * @return the departamentos
//	 */
//	public Map<String, String> getDepartamentos() {
//		return departamentos;
//	}
//
//	/**
//	 * @param departamentos the departamentos to set
//	 */
//	public void setDepartamentos(Map<String, String> departamentos) {
//		this.departamentos = departamentos;
//	}
//
//	/**
//	 * @return the idCiudad
//	 */
//	public String getIdCiudad() {
//		return idCiudad;
//	}
//
//	/**
//	 * @param idCiudad the idCiudad to set
//	 */
//	public void setIdCiudad(String idCiudad) {
//		this.idCiudad = idCiudad;
//	}
//
//	/**
//	 * @return the ciudades
//	 */
//	public Map<String, String> getCiudades() {
//		return ciudades;
//	}
//
//	/**
//	 * @param ciudades the ciudades to set
//	 */
//	public void setCiudades(Map<String, String> ciudades) {
//		this.ciudades = ciudades;
//	}
//
//	/**
//	 * @return the claveUsuario
//	 */
//	public String getClaveUsuario() {
//		return claveUsuario;
//	}
//
//	/**
//	 * @param claveUsuario the claveUsuario to set
//	 */
//	public void setClaveUsuario(String claveUsuario) {
//		this.claveUsuario = claveUsuario;
//	}
//
//	/**
//	 * @return the claveUsuario2
//	 */
//	public String getClaveUsuario2() {
//		return claveUsuario2;
//	}
//
//	/**
//	 * @param claveUsuario2 the claveUsuario2 to set
//	 */
//	public void setClaveUsuario2(String claveUsuario2) {
//		this.claveUsuario2 = claveUsuario2;
//	}
//	
//
//}