
package co.com.patios.mb.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import co.com.patios.entity.UsuarioPatio;
import co.com.patios.entity.Vehiculo;
import co.com.patios.mb.catalogos.CatalogosGenericos;
import co.com.patios.mb.catalogos.ModelosMarcas;
import co.com.patios.mb.catalogos.PatiosUsuario;
import co.com.patios.mb.ingreso.SesionUsuario;
import co.com.patios.mb.parametros.TiposIdentificacion;
import co.com.patios.mb.util.DateUtils;
import co.com.patios.mb.util.MessagesEstaticos;
import co.com.patios.mb.util.ParamsBundle;
import co.com.patios.mb.util.Utilidades;
import co.com.patios.mb.util.Utils;
import co.com.patios.negocio.iface.EntradaVehiculoPatiosIface;
import co.com.patios.service.client.gestionpersonas.GestionPersonasServiceClient;
import co.com.patios.service.client.gestiontelefonos.GestionTelefonoServiceClient;
import co.com.patios.service.client.gestionvehiculos.GestionVehiculosServiceClient;
import co.com.patios.service.dto.CiudadDTO;
import co.com.patios.service.dto.ClaseVehiculoDTO;
import co.com.patios.service.dto.ColorVehiculoDTO;
import co.com.patios.service.dto.EntradaVehiculoPatioDTO;
import co.com.patios.service.dto.EstadoVehiculoDTO;
import co.com.patios.service.dto.MarcaVehiculoDTO;
import co.com.patios.service.dto.ModeloVehiculoDTO;
import co.com.patios.service.dto.OrganismoTransitoDTO;
import co.com.patios.service.dto.PaisDTO;
import co.com.patios.service.dto.PatioDTO;
import co.com.patios.service.dto.PersonaDTO;
import co.com.patios.service.dto.TelefonoPersonaDTO;
import co.com.patios.service.dto.TipoIdentificacionDTO;
import co.com.patios.service.dto.UsuarioDTO;
import co.com.patios.service.dto.VehiculoDTO;

@ManagedBean(name = "entradaVehiculoPatioMB")
@ViewScoped
public class EntradaVehiculoPatioMB {

	private UsuarioDTO usuarioSession;

	/*
	 * bean utilizados en em MB con el fin de realizar persistencia y consulta
	 * de datos
	 */
	private VehiculoDTO vehiculo;
	private ModeloVehiculoDTO modeloVehiculo;
	private MarcaVehiculoDTO marcaVehiculo;
	private UsuarioDTO usuario;
	private EntradaVehiculoPatioDTO entradaVehiculoPatio;
	private UsuarioPatio usuarioPatio;
	private ColorVehiculoDTO coloresVehiculo;
	private ClaseVehiculoDTO claseVehiculos;
	private OrganismoTransitoDTO organismoTransito;
	private TipoIdentificacionDTO tipoIdentificacion;
	private PaisDTO pais;
	private PersonaDTO persona;
	private CiudadDTO ciudad;
	private TelefonoPersonaDTO telPersona;

	/*
	 * datos para formulario de datos patio
	 */
	private String placa;
	private String idUsuario;
	private String marca_vehiculo;
	private List<Vehiculo> lisVehiculos;
	private String numeroMotorVehiculo;
	private String numeroChasisVehiculo;
	private String numeroSerieVehiculo;
	private boolean mostraFormularioEdicion;

	/*
	 * datos para formulario de datos persona
	 */
	private String numeroIdentificacionPersona;
	private String primerNombrePersona;
	private String segundoNombrePersona;
	private String primerApellidoPersona;
	private String segundoApellidoPersona;
	private String nombreComercialPersona;
	private String telefonoPersona;
	private List<String> listTelefonoPersona;
	private boolean mostrarTelefonos = false;

	private UIComponent components;

	// variable para renderizar el nombre comercial que caso q la seleccion
	private boolean renderizaNameComercial;

	// variable para renderizar el nombre normal que caso q la seleccion
	private boolean renderizaNameNormal = true;

	// variable para validar el check de información de persona
	private String tieneInfoPersona;

	// variable para mostrar o no el panel de persona
	private boolean checkInfoPersona = false;

	// lista de los colores
	private List<ColorVehiculoDTO> listColorVehiculos;

	// maneja el onemenu de las marcas de vehiculos
	private String marcaAuto;
	private Map<String, String> marcasVehiculos = new LinkedHashMap<String, String>();

	// maneja el onemenu de los modelos de los vehiculos
	private String modeloAuto;
	private Map<String, String> modeloVehiculos = new LinkedHashMap<String, String>();

	// maneja el onemenu de los patios
	private String idPatio;
	private Map<String, String> patios = new LinkedHashMap<String, String>();

	// maneja el onemenu de los estados de vehiculos
	private String estadoAuto;
	private Map<String, String> estadosVehiculos = new LinkedHashMap<String, String>();

	// maneja el onemenu de las clases de vehiculos
	private String claseVehiculo;
	private Map<String, String> clasesVehiculos = new LinkedHashMap<String, String>();

	// maneja el onemenu de los colores de vehiculos
	private String colorVehiculo;
	private Map<String, String> colorVehiculos = new LinkedHashMap<String, String>();

	// maneja el onemenu de los organismos de transito
	private String idOrganismoTransito;
	private Map<String, String> organismosTransito = new LinkedHashMap<String, String>();

	// maneja el onemenu de los tipo de identificacion de transito
	private String idTipoIdentificacion;
	private Map<String, String> tiposIdentificacion = new LinkedHashMap<String, String>();

	// maneja el onemenu de los paises
	private String idPais;
	private Map<String, String> paises = new LinkedHashMap<String, String>();

	// maneja el onemenu de los departamentos
	private String idDepartamento;
	private Map<String, String> departamentos = new LinkedHashMap<String, String>();

	// maneja el onemenu de las ciudades
	private String idCiudad;
	private Map<String, String> ciudades = new LinkedHashMap<String, String>();

	private final FacesContext context;

	private static final String LIMPIAR_SELECT_ONE_MENU = "-1";

	@ManagedProperty(value = "#{catalogosGenericos}")
	CatalogosGenericos catalogosImpl;
	@ManagedProperty(value = "#{patiosUsuario}")
	PatiosUsuario patiosUsuario;
	@ManagedProperty(value = "#{modelosMarcas}")
	ModelosMarcas modelosMarcas;

	@EJB
	EntradaVehiculoPatiosIface entradaVehiculoPatioIface;

	public EntradaVehiculoPatioMB() {
		persona = new PersonaDTO();
		pais = new PaisDTO();
		tipoIdentificacion = new TipoIdentificacionDTO();
		coloresVehiculo = new ColorVehiculoDTO();
		organismoTransito = new OrganismoTransitoDTO();
		claseVehiculos = new ClaseVehiculoDTO();
		vehiculo = new VehiculoDTO();
		modeloVehiculo = new ModeloVehiculoDTO();
		marcaVehiculo = new MarcaVehiculoDTO();
		usuario = new UsuarioDTO();
		entradaVehiculoPatio = new EntradaVehiculoPatioDTO();
		usuarioPatio = new UsuarioPatio();
		context = FacesContext.getCurrentInstance();
		listTelefonoPersona = new ArrayList<>();
	}

	@PostConstruct
	public void llenarCaracteristicasVehiculos() throws Exception {
		setMarcasVehiculos(catalogosImpl.getMarcasVehiculos());
		setClasesVehiculos(catalogosImpl.getClasesVehiculos());
		setEstadosVehiculos(catalogosImpl.getEstadosVehiculos());
		setOrganismosTransito(catalogosImpl.getOrganismosTransito());
		setTiposIdentificacion(catalogosImpl.getTiposIdentificacion());
		setPaises(catalogosImpl.getPaises());

		String valueMarca = Utils.getPrimerValorMap(getMarcasVehiculos());
		if (!valueMarca.equals("")) {
			llenarModelos(Integer.parseInt(valueMarca));
		}

		obtenerPatiosUsuario();
	}

	/**
	 * obtiene los colores de los vehiculos
	 */
	@SuppressWarnings("unused")
	public void obtenerColorVehiculos(ActionEvent event) throws Exception {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String action = params.get("action");
		RequestContext requestContext = RequestContext.getCurrentInstance();
		UIComponent table = FacesContext.getCurrentInstance().getViewRoot().findComponent(":tablaColores:tableColores");
		((DataTable) table).resetValue();
		listColorVehiculos = catalogosImpl.getColores();
		requestContext.execute("PF('dialogoColores').show();");
	}

	/**
	 * captura la seleccion sobre los colores de vehiculos
	 */
	public void selectionColor(SelectEvent event) {
		coloresVehiculo = (ColorVehiculoDTO) event.getObject();
		colorVehiculos = new LinkedHashMap<String, String>();
		if (coloresVehiculo != null) {
			colorVehiculos.put(coloresVehiculo.getDescripcionColorVehiculo().trim(),
					coloresVehiculo.getIdColorVehiculo().toString());
		}
	}

	/**
	 * activa el panel persona de aceurdo a la seleccion del usuario, en caso
	 * que si tenga la informacion del mismo
	 */
	public void activarPanelPersona() {
		if (tieneInfoPersona.equals("1")) {
			checkInfoPersona = true;
		} else {
			checkInfoPersona = false;
			idTipoIdentificacion = LIMPIAR_SELECT_ONE_MENU;
			idPais = LIMPIAR_SELECT_ONE_MENU;
			idDepartamento = LIMPIAR_SELECT_ONE_MENU;
			idCiudad = LIMPIAR_SELECT_ONE_MENU;
		}
	}

	/**
	 * obtiene los patios asociados a un usuario, teniendo en cuenta si la fecha
	 * actual del sistema esta dentro del rango establecido para el usuario
	 */
	public void obtenerPatiosUsuario() {
		// se captura la session del usuario
		usuarioSession = SesionUsuario.getInstance().getUsuarioSesion(context, "usuario");
		FacesMessage message = new FacesMessage();
		try {
			setPatios(patiosUsuario.getPatiosUsuario(usuarioSession.getIdUsuario(), new Date()));
		} catch (Exception e) {
			Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, null,
					ParamsBundle.getInstance().getMapMensajes().get("cabecera_error"), e.getMessage());
			return;
		}

	}

	/**
	 * llena los modelos de vehiculos segun la marca seleccionada
	 * 
	 * @param marcaVehiculo
	 */
	public void llenarModelos(int marcaVehiculo) throws Exception {
		setModeloVehiculos(modelosMarcas.getModelos(marcaVehiculo));
	}

	/**
	 * realiza el llenado de los departamentos del pais seleccionados
	 */
	public void llenarDepartamentos() {
		// setDepartamentos(departamentoEJB.consultarDepartamentos(Integer.parseInt(idPais)));
	}

	/**
	 * llena los modelos de vehiculos segun la marca seleccionada en la pagina
	 * entradaPatios.xhmtl
	 */
	public void llenarModelos() throws Exception {
		setModeloVehiculos(modelosMarcas.getModelos(Integer.parseInt(marcaAuto)));
	}

	/**
	 * realiza el llenado de las ciudades asociados al departamento seleccionado
	 */
	public void llenarCiudades() {
		// setCiudades(ciudadEJB.consultarCiudades(Integer.parseInt(idDepartamento)));
	}

	/**
	 * valida la existencia de la persona en el sistema, si esta existe muestra
	 * los datos correspondientes
	 */
	public void validarExistenciaPersona() {
		/*
		 * aqui se captura el contexto actual
		 */
		FacesContext context = FacesContext.getCurrentInstance();

		/*
		 * variable para el manejo de mensajes en la vista
		 */
		FacesMessage message = new FacesMessage();

		/*
		 * se captura la session del usuario
		 */
		usuarioSession = SesionUsuario.getInstance().getUsuarioSesion(context, "usuario");

		if (checkInfoPersona) {
			int tipoIdent = Integer.parseInt(idTipoIdentificacion);
			BigDecimal numeroDocumento = new BigDecimal(numeroIdentificacionPersona);
			try {
				persona = GestionPersonasServiceClient.getInstance().consultarPersona(tipoIdent, numeroDocumento);
			} catch (Exception e) {
				Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, null,
						ParamsBundle.getInstance().getMapMensajes().get("cabecera_error"), e.getMessage());
				return;
			}

			if (persona != null) {
				numeroIdentificacionPersona = persona.getNumeroIdentificacion().toString();
				idTipoIdentificacion = persona.getTipoIdentificacion().toString();
				List<TelefonoPersonaDTO> listTelefonoPersonas;
				try {
					listTelefonoPersonas = GestionTelefonoServiceClient.getInstance()
							.obtenerTelefonosPersona(persona.getIdPersona());
				} catch (Exception e) {
					Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, null,
							ParamsBundle.getInstance().getMapMensajes().get("cabecera_error"), e.getMessage());
					return;
				}

				if (listTelefonoPersonas != null && !listTelefonoPersonas.isEmpty()) {
					listTelefonoPersona = new ArrayList<>();
					mostrarTelefonos = true;
					for (TelefonoPersonaDTO telefonoPersona : listTelefonoPersonas) {
						listTelefonoPersona.add(telefonoPersona.getNumeroTelefonoPersona());
					}
				} else {
					mostrarTelefonos = false;
				}

				if (idTipoIdentificacion.equals("" + TiposIdentificacion.NIT)) {
					nombreComercialPersona = persona.getNombreComercialPersona();
					idPais = persona.getCiudad().getDepartamento().getPais().getIdPais().toString();
					idDepartamento = persona.getCiudad().getDepartamento().getIdDepartamento().toString();
					idCiudad = persona.getCiudad().getIdCiudad().toString();
					renderizaNameNormal = false;
					renderizaNameComercial = true;
				} else {
					primerNombrePersona = persona.getPrimerNombrePersona();
					segundoNombrePersona = persona.getSegundoNombrePersona();
					primerApellidoPersona = persona.getPrimerApellidoPersona();
					segundoApellidoPersona = persona.getSegundoApellidoPersona();
					idPais = persona.getCiudad().getDepartamento().getPais().getIdPais().toString();
					llenarDepartamentos();
					idDepartamento = persona.getCiudad().getDepartamento().getIdDepartamento().toString();
					llenarCiudades();
					idCiudad = persona.getCiudad().getIdCiudad().toString();
					renderizaNameNormal = true;
					renderizaNameComercial = false;
				}
			} else {
				mostrarTelefonos = false;
				listTelefonoPersona = null;
				nombreComercialPersona = LIMPIAR_SELECT_ONE_MENU;
				idPais = LIMPIAR_SELECT_ONE_MENU;
				idDepartamento = LIMPIAR_SELECT_ONE_MENU;
				idCiudad = LIMPIAR_SELECT_ONE_MENU;
				primerNombrePersona = "";
				segundoNombrePersona = "";
				primerApellidoPersona = "";
				segundoApellidoPersona = "";

			}

		}
	}

	/**
	 * valida la existencia del vehiculo, en caso de existir llena los campos
	 * correspondientes del formulario
	 */
	public void validarExistenciaVehiculo() {
		convertMayuscula();
		// valida si existe el vehiculo
		FacesMessage message = new FacesMessage();
		try {

			vehiculo = GestionVehiculosServiceClient.getInstance().obtenerDatosVehiculos(placa);
		} catch (Exception e) {
			Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, null,
					ParamsBundle.getInstance().getMapMensajes().get("cabecera_error"), e.getMessage());
			return;
		}

		if (vehiculo != null) {
			colorVehiculos = new LinkedHashMap<String, String>();
			marcaAuto = "" + vehiculo.getModeloVehiculo().getMarcaVehiculo().getIdMarcaVehiculo();
			if (!marcaAuto.equals("")) {
				// llenarModelos(Integer.parseInt(marcaAuto));
			}
			modeloAuto = "" + vehiculo.getModeloVehiculo().getIdModeloVehiculo();
			claseVehiculo = "" + vehiculo.getClaseVehiculo().getIdClaseVehiculo();
			colorVehiculo = "" + vehiculo.getColorVehiculo().getIdColorVehiculo();
			idOrganismoTransito = "" + vehiculo.getOrganismoTransito().getIdOrganismoTransito();
			estadoAuto = "" + vehiculo.getEstadoVehiculo().getIdEstadoVehiculo();
			numeroMotorVehiculo = "" + vehiculo.getNumeroMotorVehiculo();
			numeroChasisVehiculo = vehiculo.getNumeroChasisVehiculo();
			numeroSerieVehiculo = "" + vehiculo.getNumeroSerieVehiculo();
			colorVehiculos.put(vehiculo.getColorVehiculo().getDescripcionColorVehiculo().trim(),
					"" + vehiculo.getColorVehiculo().getIdColorVehiculo());
		} else {
			limpiarCampos(false);
		}

	}

	/**
	 * realiza la conversion de los campos de la pagina entradaPatios.xhmtl en
	 * mayuscula, una vez sean digitados los mismos
	 */
	public void convertMayuscula() {
		if (placa != null) {
			placa = Utilidades.convertirMayusculas(placa);
		}

		if (this.numeroMotorVehiculo != null) {
			numeroMotorVehiculo = Utilidades.convertirMayusculas(numeroMotorVehiculo);
		}

		if (numeroChasisVehiculo != null) {
			numeroChasisVehiculo = Utilidades.convertirMayusculas(numeroChasisVehiculo);
		}

		if (numeroSerieVehiculo != null) {
			numeroSerieVehiculo = Utilidades.convertirMayusculas(numeroSerieVehiculo);
		}

		if (primerNombrePersona != null) {
			primerNombrePersona = Utilidades.convertirMayusculas(primerNombrePersona);
		}

		if (segundoNombrePersona != null) {
			segundoNombrePersona = Utilidades.convertirMayusculas(segundoNombrePersona);
		}

		if (primerApellidoPersona != null) {
			primerApellidoPersona = Utilidades.convertirMayusculas(primerApellidoPersona);
		}

		if (segundoApellidoPersona != null) {
			segundoApellidoPersona = Utilidades.convertirMayusculas(segundoApellidoPersona);
		}

		if (nombreComercialPersona != null) {
			nombreComercialPersona = Utilidades.convertirMayusculas(nombreComercialPersona);
		}
	}

	/**
	 * realiza la entrada de un vehiculo a un patio especifico
	 */
	public void registrarEntradaVehiculo() {
		/*
		 * aqui se captura el contexto actual
		 */
		FacesContext context = FacesContext.getCurrentInstance();

		/*
		 * variable para la visualizacion de mensajes en la pagina jsf
		 */
		FacesMessage message = new FacesMessage();

		/*
		 * se captura la session del usuario
		 */
		usuarioSession = SesionUsuario.getInstance().getUsuarioSesion(context, "usuario");

		/*
		 * valida la session de usuario en caso que no exista redirecciona a la
		 * pagina de inicio
		 */
		if (usuarioSession == null) {
			try {
				context.getExternalContext().redirect("../index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			/*
			 * valida si la placa tiene entrada
			 */
			vehiculo = new VehiculoDTO();
			String msgExisteEntrada = "";
			try {
				msgExisteEntrada = entradaVehiculoPatioIface.validarEntradaVehiculo(placa);
			} catch (Exception e) {
				Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, null,
						ParamsBundle.getInstance().getMapMensajes().get("cabecera_error"),
						ParamsBundle.getInstance().getMapMensajes().get("error_sistema"));
				return;
			}

			if (!msgExisteEntrada.isEmpty()) {
				Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_WARN, null,
						ParamsBundle.getInstance().getMapMensajes().get("cabecera_warn"), msgExisteEntrada);
				return;
			}

			/*
			 * en este punto se capturan los datos de la vista, se hace parse
			 * teniendo en cuenta que la validacion de dato y de valor numerico
			 * se realizo en la vista
			 */
			int tipoIdent = Integer.parseInt(idTipoIdentificacion);
			BigDecimal numeroDocumento = new BigDecimal(numeroIdentificacionPersona);
			try {
				persona = GestionPersonasServiceClient.getInstance().consultarPersona(tipoIdent, numeroDocumento);
			} catch (Exception e) {
				Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, null,
						ParamsBundle.getInstance().getMapMensajes().get("cabecera_error"), e.getMessage());
				return;
			}

			if (persona == null) {
				persona = new PersonaDTO();
				if (tipoIdent == TiposIdentificacion.NIT) {
					persona.setPrimerNombrePersona("");
					persona.setSegundoNombrePersona("");
					persona.setPrimerApellidoPersona("");
					persona.setSegundoApellidoPersona("");
					persona.setNombreComercialPersona(nombreComercialPersona);
				} else {
					persona.setPrimerNombrePersona(primerNombrePersona);
					persona.setSegundoNombrePersona(segundoNombrePersona);
					persona.setPrimerApellidoPersona(primerApellidoPersona);
					persona.setSegundoApellidoPersona(segundoApellidoPersona);
					persona.setNombreComercialPersona("");
				}

				TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO();
				tipoIdentificacionDTO.setIdTipoIdentificacion(tipoIdent);
				persona.setTipoIdentificacion(tipoIdentificacionDTO);
				persona.setNumeroIdentificacion(numeroDocumento);
				int identificadorCiudad = Integer.parseInt(idCiudad);
				CiudadDTO ciudadDTO = new CiudadDTO();
				ciudadDTO.setIdCiudad(identificadorCiudad);
				persona.setCiudad(ciudadDTO);
				persona.setFechaProceso(DateUtils.getInstance().getFechaActual());

				List<TelefonoPersonaDTO> listTelefonos = new ArrayList<>();
				if (listTelefonoPersona != null && !listTelefonoPersona.isEmpty()) {
					for (String telefono : listTelefonoPersona) {
						telPersona = new TelefonoPersonaDTO();
						telPersona.setFechaProceso(DateUtils.getInstance().getFechaActual());
						telPersona.setNumeroTelefonoPersona(telefono);
						listTelefonos.add(telPersona);
					}
				}
				persona.setTelefonoPersonas(listTelefonos);
			}

			setObjetoVehiculo();
			setObjetoEntradaVehiculo();

			/*
			 * en este punto los objetos tienen los valores se envia al servicio
			 * para realizar el registro
			 */

			limpiarCampos(true);
			idPatio = LIMPIAR_SELECT_ONE_MENU;
			checkInfoPersona = false;
			listTelefonoPersona = null;
			mostrarTelefonos = false;
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			message.setDetail(MessagesEstaticos.getRegistroExitoso());
			message.setSummary(MessagesEstaticos.getMensajeCabeceraExito());
			context.addMessage(null, message);

		}
	}

	/**
	 * evento que se activa al momento de realizar el envio del formulario y
	 * captura todos los componentes de una pagina, despues puedes ser usado
	 * para capturar el valor o el id del componente
	 * 
	 * @param event
	 */
	public void setIdComponent(ComponentSystemEvent event) {
		setComponents(event.getComponent());
	}

	/**
	 * limpia los campos de la pagina jsf entradaPatios.xhtml
	 * 
	 * @param sw,
	 *            en caso que se envie no limpia la placa
	 */
	private void limpiarCampos(boolean sw) {
		if (sw) {
			setPlaca("");
		}
		setNumeroChasisVehiculo("");
		setNumeroMotorVehiculo("");
		setNumeroSerieVehiculo("");
		idOrganismoTransito = LIMPIAR_SELECT_ONE_MENU;
		idTipoIdentificacion = LIMPIAR_SELECT_ONE_MENU;
		colorVehiculo = LIMPIAR_SELECT_ONE_MENU;
		colorVehiculos = null;
		claseVehiculo = LIMPIAR_SELECT_ONE_MENU;
		estadoAuto = LIMPIAR_SELECT_ONE_MENU;
		modeloAuto = LIMPIAR_SELECT_ONE_MENU;
		marcaAuto = LIMPIAR_SELECT_ONE_MENU;
		idTipoIdentificacion = LIMPIAR_SELECT_ONE_MENU;
		idPais = LIMPIAR_SELECT_ONE_MENU;
		idDepartamento = LIMPIAR_SELECT_ONE_MENU;
		idCiudad = LIMPIAR_SELECT_ONE_MENU;
		numeroIdentificacionPersona = "";
		primerNombrePersona = "";
		primerApellidoPersona = "";
		segundoApellidoPersona = "";
		segundoNombrePersona = "";
		nombreComercialPersona = "";

	}

	/**
	 * captura los datos del vehiculo que se esta ingresando a patios
	 */
	private void setObjetoVehiculo() {
		if (vehiculo == null) {
			vehiculo = new VehiculoDTO();
			vehiculo.setUsuario(usuarioSession);
			vehiculo.setPlacaVehiculo(placa);
			ModeloVehiculoDTO modeloVehiculo = new ModeloVehiculoDTO();
			modeloVehiculo.setIdModeloVehiculo(Integer.parseInt(modeloAuto));
			vehiculo.setModeloVehiculo(modeloVehiculo);
			EstadoVehiculoDTO estadoVehiculoDTO = new EstadoVehiculoDTO();
			estadoVehiculoDTO.setIdEstadoVehiculo(Integer.parseInt(estadoAuto));
			vehiculo.setEstadoVehiculo(estadoVehiculoDTO);
			ClaseVehiculoDTO claseVehiculoDTO = new ClaseVehiculoDTO();
			claseVehiculoDTO.setIdClaseVehiculo(Integer.parseInt(claseVehiculo));
			vehiculo.setClaseVehiculo(claseVehiculoDTO);
			ColorVehiculoDTO colorVehiculoDTO = new ColorVehiculoDTO();
			colorVehiculoDTO.setIdColorVehiculo(Integer.parseInt(colorVehiculo));
			vehiculo.setColorVehiculo(colorVehiculoDTO);

			if (idOrganismoTransito != null) {
				OrganismoTransitoDTO organismoTransitoDTO = new OrganismoTransitoDTO();
				organismoTransitoDTO.setIdOrganismoTransito(Integer.parseInt(idOrganismoTransito));
				vehiculo.setOrganismoTransito(organismoTransitoDTO);
			}

			vehiculo.setNumeroChasisVehiculo(numeroChasisVehiculo);
			vehiculo.setNumeroMotorVehiculo(numeroMotorVehiculo);
			vehiculo.setNumeroSerieVehiculo(numeroSerieVehiculo);
			vehiculo.setFechaProceso(DateUtils.getInstance().getFechaActual());
		}
	}

	/**
	 * captura los datos de entrada del vehiculo
	 */
	private void setObjetoEntradaVehiculo() {
		entradaVehiculoPatio = new EntradaVehiculoPatioDTO();
		entradaVehiculoPatio.setUsuario(usuarioSession);
		PatioDTO patio = new PatioDTO();
		patio.setIdPatio(Integer.parseInt(idPatio));
		entradaVehiculoPatio.setPatio(patio);
		entradaVehiculoPatio.setFechaEntradaVehiculo(DateUtils.getInstance().getFechaActual());
		entradaVehiculoPatio.setEstadoEntradaVehiculo("I");
		entradaVehiculoPatio.setVehiculo(vehiculo);

	}

	/**
	 * realiza la renderizacion de los componentes con relacion a nombres de la
	 * persona, ya sea segun el tipo identificacion NIT u otros
	 */
	public void cambiarComponenteNombreComercial() {
		if (idTipoIdentificacion != null) {
			if (Integer.parseInt(idTipoIdentificacion) == TiposIdentificacion.NIT) {
				renderizaNameComercial = true;
				renderizaNameNormal = false;
			} else {
				renderizaNameComercial = false;
				renderizaNameNormal = true;
			}

		}
	}

	/**
	 * almacena temporalmente todos los telefonos de las personas que indique el
	 * funcionario encargado
	 */
	public void almacenarTelefonosPersona() {
		FacesMessage message = new FacesMessage();
		FacesContext context = FacesContext.getCurrentInstance();
		if (telefonoPersona != null) {
			if (telefonoPersona.equals("")) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setDetail("Digite un número de telefono");
				message.setSummary(MessagesEstaticos.getMensajeCabeceraAlert());
				context.addMessage(null, message);
				return;
			}

			if (!Utilidades.validarNumerico(telefonoPersona)) {
				message.setSeverity(FacesMessage.SEVERITY_WARN);
				message.setDetail("Digite solo datos Númericos");
				message.setSummary(MessagesEstaticos.getMensajeCabeceraAlert());
				context.addMessage(null, message);
				return;
			}

			if (listTelefonoPersona != null && !listTelefonoPersona.isEmpty()) {
				for (String telefono : listTelefonoPersona) {
					if (telefonoPersona.equals(telefono)) {
						message.setSeverity(FacesMessage.SEVERITY_WARN);
						message.setDetail("El telefono ya ha sido digitado");
						message.setSummary(MessagesEstaticos.getMensajeCabeceraAlert());
						context.addMessage(null, message);
						return;
					} else {
						listTelefonoPersona.add(telefonoPersona);
						telefonoPersona = null;
						mostrarTelefonos = true;
						return;
					}
				}
			} else {
				if (listTelefonoPersona != null) {
					listTelefonoPersona.add(telefonoPersona);
					telefonoPersona = null;
					mostrarTelefonos = true;
				}
			}

		}
	}

	/**
	 * realiza la eliminacion de telefono temporales agregados por un
	 * funcionario
	 * 
	 * @param telefono
	 */
	public void eliminarTelefonoTemporal(String telefono) {
		listTelefonoPersona.remove(telefono);
		if (listTelefonoPersona != null && listTelefonoPersona.isEmpty()) {
			mostrarTelefonos = false;
		}

	}

	/**
	 * @return the vehiculo
	 */
	public VehiculoDTO getVehiculo() {
		return vehiculo;
	}

	/**
	 * @param vehiculo
	 *            the vehiculo to set
	 */
	public void setVehiculo(VehiculoDTO vehiculo) {
		this.vehiculo = vehiculo;
	}

	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa
	 *            the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @return the modeloVehiculo
	 */
	public ModeloVehiculoDTO getModeloVehiculo() {
		return modeloVehiculo;
	}

	/**
	 * @param modeloVehiculo
	 *            the modeloVehiculo to set
	 */
	public void setModeloVehiculo(ModeloVehiculoDTO modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}

	/**
	 * @return the usuario
	 */
	public UsuarioDTO getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the marcaVehiculo
	 */
	public MarcaVehiculoDTO getMarcaVehiculo() {
		return marcaVehiculo;
	}

	/**
	 * @param marcaVehiculo
	 *            the marcaVehiculo to set
	 */
	public void setMarcaVehiculo(MarcaVehiculoDTO marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}

	/**
	 * @return the lisVehiculos
	 */
	public List<Vehiculo> getLisVehiculos() {
		return lisVehiculos;
	}

	/**
	 * @param lisVehiculos
	 *            the lisVehiculos to set
	 */
	public void setLisVehiculos(List<Vehiculo> lisVehiculos) {
		this.lisVehiculos = lisVehiculos;
	}

	/**
	 * @return the marcasVehiculos
	 */
	public Map<String, String> getMarcasVehiculos() {
		return marcasVehiculos;
	}

	/**
	 * @param marcasVehiculos
	 *            the marcasVehiculos to set
	 */
	public void setMarcasVehiculos(Map<String, String> marcasVehiculos) {
		this.marcasVehiculos = marcasVehiculos;
	}

	/**
	 * @return the entradaVehiculoPatio
	 */
	public EntradaVehiculoPatioDTO getEntradaVehiculoPatio() {
		return entradaVehiculoPatio;
	}

	/**
	 * @param entradaVehiculoPatio
	 *            the entradaVehiculoPatio to set
	 */
	public void setEntradaVehiculoPatio(EntradaVehiculoPatioDTO entradaVehiculoPatio) {
		this.entradaVehiculoPatio = entradaVehiculoPatio;
	}

	/**
	 * @return the id_patio
	 */
	public String getIdPatio() {
		return idPatio;
	}

	/**
	 * @param id_patio
	 *            the id_patio to set
	 */
	public void setIdPatio(String idPatio) {
		this.idPatio = idPatio;
	}

	/**
	 * @return the patios
	 */
	public Map<String, String> getPatios() {
		return patios;
	}

	/**
	 * @param patios
	 *            the patios to set
	 */
	public void setPatios(Map<String, String> patios) {
		this.patios = patios;
	}

	/**
	 * @return the idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario
	 *            the idUsuario to set
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the numeroMotorVehiculo
	 */
	public String getNumeroMotorVehiculo() {
		return numeroMotorVehiculo;
	}

	/**
	 * @param numeroMotorVehiculo
	 *            the numeroMotorVehiculo to set
	 */
	public void setNumeroMotorVehiculo(String numeroMotorVehiculo) {
		this.numeroMotorVehiculo = numeroMotorVehiculo;
	}

	/**
	 * @return the numeroChasisVehiculo
	 */
	public String getNumeroChasisVehiculo() {
		return numeroChasisVehiculo;
	}

	/**
	 * @param numeroChasisVehiculo
	 *            the numeroChasisVehiculo to set
	 */
	public void setNumeroChasisVehiculo(String numeroChasisVehiculo) {
		this.numeroChasisVehiculo = numeroChasisVehiculo;
	}

	/**
	 * @return the numeroSerieVehiculo
	 */
	public String getNumeroSerieVehiculo() {
		return numeroSerieVehiculo;
	}

	/**
	 * @param numeroSerieVehiculo
	 *            the numeroSerieVehiculo to set
	 */
	public void setNumeroSerieVehiculo(String numeroSerieVehiculo) {
		this.numeroSerieVehiculo = numeroSerieVehiculo;
	}

	/**
	 * @return the mostraFormularioEdicion
	 */
	public boolean isMostraFormularioEdicion() {
		return mostraFormularioEdicion;
	}

	/**
	 * @param mostraFormularioEdicion
	 *            the mostraFormularioEdicion to set
	 */
	public void setMostraFormularioEdicion(boolean mostraFormularioEdicion) {
		this.mostraFormularioEdicion = mostraFormularioEdicion;
	}

	/**
	 * @return the marca_vehiculo
	 */
	public String getMarca_vehiculo() {
		return marca_vehiculo;
	}

	/**
	 * @param marca_vehiculo
	 *            the marca_vehiculo to set
	 */
	public void setMarca_vehiculo(String marca_vehiculo) {
		this.marca_vehiculo = marca_vehiculo;
	}

	/**
	 * @return the estadosVehiculos
	 */
	public Map<String, String> getEstadosVehiculos() {
		return estadosVehiculos;
	}

	/**
	 * @param estadosVehiculos
	 *            the estadosVehiculos to set
	 */
	public void setEstadosVehiculos(Map<String, String> estadosVehiculos) {
		this.estadosVehiculos = estadosVehiculos;
	}

	/**
	 * @return the marcaAuto
	 */
	public String getMarcaAuto() {
		return marcaAuto;
	}

	/**
	 * @param marcaAuto
	 *            the marcaAuto to set
	 */
	public void setMarcaAuto(String marcaAuto) {
		this.marcaAuto = marcaAuto;
	}

	/**
	 * @return the modeloAuto
	 */
	public String getModeloAuto() {
		return modeloAuto;
	}

	/**
	 * @param modeloAuto
	 *            the modeloAuto to set
	 */
	public void setModeloAuto(String modeloAuto) {
		this.modeloAuto = modeloAuto;
	}

	/**
	 * @return the modeloVehiculos
	 */
	public Map<String, String> getModeloVehiculos() {
		return modeloVehiculos;
	}

	/**
	 * @param modeloVehiculos
	 *            the modeloVehiculos to set
	 */
	public void setModeloVehiculos(Map<String, String> modeloVehiculos) {
		this.modeloVehiculos = modeloVehiculos;
	}

	/**
	 * @return the estadoAuto
	 */
	public String getEstadoAuto() {
		return estadoAuto;
	}

	/**
	 * @param estadoAuto
	 *            the estadoAuto to set
	 */
	public void setEstadoAuto(String estadoAuto) {
		this.estadoAuto = estadoAuto;
	}

	/**
	 * @return the components
	 */
	public UIComponent getComponents() {
		return components;
	}

	/**
	 * @param components
	 *            the components to set
	 */
	public void setComponents(UIComponent components) {
		this.components = components;
	}

	/**
	 * @return the usuarioPatio
	 */
	public UsuarioPatio getUsuarioPatio() {
		return usuarioPatio;
	}

	/**
	 * @param usuarioPatio
	 *            the usuarioPatio to set
	 */
	public void setUsuarioPatio(UsuarioPatio usuarioPatio) {
		this.usuarioPatio = usuarioPatio;
	}

	/**
	 * @return the claseVehiculos
	 */
	public String getClaseVehiculo() {
		return claseVehiculo;
	}

	/**
	 * @param claseVehiculos
	 *            the claseVehiculos to set
	 */
	public void setClaseVehiculo(String claseVehiculo) {
		this.claseVehiculo = claseVehiculo;
	}

	/**
	 * @return the clasesVehiculos
	 */
	public Map<String, String> getClasesVehiculos() {
		return clasesVehiculos;
	}

	/**
	 * @param clasesVehiculos
	 *            the clasesVehiculos to set
	 */
	public void setClasesVehiculos(Map<String, String> clasesVehiculos) {
		this.clasesVehiculos = clasesVehiculos;
	}

	/**
	 * @return the colorVehiculo
	 */
	public String getColorVehiculo() {
		return colorVehiculo;
	}

	/**
	 * @param colorVehiculo
	 *            the colorVehiculo to set
	 */
	public void setColorVehiculo(String colorVehiculo) {
		this.colorVehiculo = colorVehiculo;
	}

	/**
	 * @return the colorVehiculos
	 */
	public Map<String, String> getColorVehiculos() {
		return colorVehiculos;
	}

	/**
	 * @param colorVehiculos
	 *            the colorVehiculos to set
	 */
	public void setColorVehiculos(Map<String, String> colorVehiculos) {
		this.colorVehiculos = colorVehiculos;
	}

	/**
	 * @return the listColorVehiculos
	 */
	public List<ColorVehiculoDTO> getListColorVehiculos() {
		return listColorVehiculos;
	}

	/**
	 * @param listColorVehiculos
	 *            the listColorVehiculos to set
	 */
	public void setListColorVehiculos(List<ColorVehiculoDTO> listColorVehiculos) {
		this.listColorVehiculos = listColorVehiculos;
	}

	public ColorVehiculoDTO getColoresVehiculo() {
		return coloresVehiculo;
	}

	public void setColoresVehiculo(ColorVehiculoDTO coloresVehiculo) {
		this.coloresVehiculo = coloresVehiculo;
	}

	public String getIdOrganismoTransito() {
		return idOrganismoTransito;
	}

	public void setIdOrganismoTransito(String idOrganismoTransito) {
		this.idOrganismoTransito = idOrganismoTransito;
	}

	public Map<String, String> getOrganismosTransito() {
		return organismosTransito;
	}

	public void setOrganismosTransito(Map<String, String> organismosTransito) {
		this.organismosTransito = organismosTransito;
	}

	public String getIdTipoIdentificacion() {
		return idTipoIdentificacion;
	}

	public void setIdTipoIdentificacion(String idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public Map<String, String> getTiposIdentificacion() {
		return tiposIdentificacion;
	}

	public void setTiposIdentificacion(Map<String, String> tiposIdentificacion) {
		this.tiposIdentificacion = tiposIdentificacion;
	}

	public String getTieneInfoPersona() {
		return tieneInfoPersona;
	}

	public void setTieneInfoPersona(String tieneInfoPersona) {
		this.tieneInfoPersona = tieneInfoPersona;
	}

	public boolean isCheckInfoPersona() {
		return checkInfoPersona;
	}

	public void setCheckInfoPersona(boolean checkInfoPersona) {
		this.checkInfoPersona = checkInfoPersona;
	}

	public ClaseVehiculoDTO getClaseVehiculos() {
		return claseVehiculos;
	}

	public void setClaseVehiculos(ClaseVehiculoDTO claseVehiculos) {
		this.claseVehiculos = claseVehiculos;
	}

	public OrganismoTransitoDTO getOrganismoTransito() {
		return organismoTransito;
	}

	public void setOrganismoTransito(OrganismoTransitoDTO organismoTransito) {
		this.organismoTransito = organismoTransito;
	}

	/**
	 * @return the renderizaNameComercial
	 */
	public boolean isRenderizaNameComercial() {
		return renderizaNameComercial;
	}

	/**
	 * @param renderizaNameComercial
	 *            the renderizaNameComercial to set
	 */
	public void setRenderizaNameComercial(boolean renderizaNameComercial) {
		this.renderizaNameComercial = renderizaNameComercial;
	}

	/**
	 * @return the renderizaNameNormal
	 */
	public boolean isRenderizaNameNormal() {
		return renderizaNameNormal;
	}

	/**
	 * @param renderizaNameNormal
	 *            the renderizaNameNormal to set
	 */
	public void setRenderizaNameNormal(boolean renderizaNameNormal) {
		this.renderizaNameNormal = renderizaNameNormal;
	}

	/**
	 * @return the tipoIdentificacion
	 */
	public TipoIdentificacionDTO getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	/**
	 * @param tipoIdentificacion
	 *            the tipoIdentificacion to set
	 */
	public void setTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	/**
	 * @return the idPais
	 */
	public String getIdPais() {
		return idPais;
	}

	/**
	 * @param idPais
	 *            the idPais to set
	 */
	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	/**
	 * @return the paises
	 */
	public Map<String, String> getPaises() {
		return paises;
	}

	/**
	 * @param paises
	 *            the paises to set
	 */
	public void setPaises(Map<String, String> paises) {
		this.paises = paises;
	}

	/**
	 * @return the idDepartamento
	 */
	public String getIdDepartamento() {
		return idDepartamento;
	}

	/**
	 * @param idDepartamento
	 *            the idDepartamento to set
	 */
	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	/**
	 * @return the departamentos
	 */
	public Map<String, String> getDepartamentos() {
		return departamentos;
	}

	/**
	 * @param departamentos
	 *            the departamentos to set
	 */
	public void setDepartamentos(Map<String, String> departamentos) {
		this.departamentos = departamentos;
	}

	/**
	 * @return the idCiudad
	 */
	public String getIdCiudad() {
		return idCiudad;
	}

	/**
	 * @param idCiudad
	 *            the idCiudad to set
	 */
	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}

	/**
	 * @return the ciudades
	 */
	public Map<String, String> getCiudades() {
		return ciudades;
	}

	/**
	 * @param ciudades
	 *            the ciudades to set
	 */
	public void setCiudades(Map<String, String> ciudades) {
		this.ciudades = ciudades;
	}

	/**
	 * @return the pais
	 */
	public PaisDTO getPais() {
		return pais;
	}

	/**
	 * @param pais
	 *            the pais to set
	 */
	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

	/**
	 * @return the persona
	 */
	public PersonaDTO getPersona() {
		return persona;
	}

	/**
	 * @param persona
	 *            the persona to set
	 */
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}

	/**
	 * @return the numeroIdentificacionPersona
	 */
	public String getNumeroIdentificacionPersona() {
		return numeroIdentificacionPersona;
	}

	/**
	 * @param numeroIdentificacionPersona
	 *            the numeroIdentificacionPersona to set
	 */
	public void setNumeroIdentificacionPersona(String numeroIdentificacionPersona) {
		this.numeroIdentificacionPersona = numeroIdentificacionPersona;
	}

	/**
	 * @return the primerNombrePersona
	 */
	public String getPrimerNombrePersona() {
		return primerNombrePersona;
	}

	/**
	 * @param primerNombrePersona
	 *            the primerNombrePersona to set
	 */
	public void setPrimerNombrePersona(String primerNombrePersona) {
		this.primerNombrePersona = primerNombrePersona;
	}

	/**
	 * @return the segundoNombrePersona
	 */
	public String getSegundoNombrePersona() {
		return segundoNombrePersona;
	}

	/**
	 * @param segundoNombrePersona
	 *            the segundoNombrePersona to set
	 */
	public void setSegundoNombrePersona(String segundoNombrePersona) {
		this.segundoNombrePersona = segundoNombrePersona;
	}

	/**
	 * @return the primerApellidoPersona
	 */
	public String getPrimerApellidoPersona() {
		return primerApellidoPersona;
	}

	/**
	 * @param primerApellidoPersona
	 *            the primerApellidoPersona to set
	 */
	public void setPrimerApellidoPersona(String primerApellidoPersona) {
		this.primerApellidoPersona = primerApellidoPersona;
	}

	/**
	 * @return the segundoApellidoPersona
	 */
	public String getSegundoApellidoPersona() {
		return segundoApellidoPersona;
	}

	/**
	 * @param segundoApellidoPersona
	 *            the segundoApellidoPersona to set
	 */
	public void setSegundoApellidoPersona(String segundoApellidoPersona) {
		this.segundoApellidoPersona = segundoApellidoPersona;
	}

	/**
	 * @return the ciudad
	 */
	public CiudadDTO getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad
	 *            the ciudad to set
	 */
	public void setCiudad(CiudadDTO ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return the nombreComercialPersona
	 */
	public String getNombreComercialPersona() {
		return nombreComercialPersona;
	}

	/**
	 * @param nombreComercialPersona
	 *            the nombreComercialPersona to set
	 */
	public void setNombreComercialPersona(String nombreComercialPersona) {
		this.nombreComercialPersona = nombreComercialPersona;
	}

	/**
	 * @return the listTelefonoPersona
	 */
	public List<String> getListTelefonoPersona() {
		return listTelefonoPersona;
	}

	/**
	 * @param listTelefonoPersona
	 *            the listTelefonoPersona to set
	 */
	public void setListTelefonoPersona(List<String> listTelefonoPersona) {
		this.listTelefonoPersona = listTelefonoPersona;
	}

	/**
	 * @return the telefonoPersona
	 */
	public String getTelefonoPersona() {
		return telefonoPersona;
	}

	/**
	 * @param telefonoPersona
	 *            the telefonoPersona to set
	 */
	public void setTelefonoPersona(String telefonoPersona) {
		this.telefonoPersona = telefonoPersona;
	}

	/**
	 * @return the mostrarTelefonos
	 */
	public boolean isMostrarTelefonos() {
		return mostrarTelefonos;
	}

	/**
	 * @param mostrarTelefonos
	 *            the mostrarTelefonos to set
	 */
	public void setMostrarTelefonos(boolean mostrarTelefonos) {
		this.mostrarTelefonos = mostrarTelefonos;
	}

	/**
	 * @return the telPersona
	 */
	public TelefonoPersonaDTO getTelPersona() {
		return telPersona;
	}

	/**
	 * @param telPersona
	 *            the telPersona to set
	 */
	public void setTelPersona(TelefonoPersonaDTO telPersona) {
		this.telPersona = telPersona;
	}

	public CatalogosGenericos getCatalogosImpl() {
		return catalogosImpl;
	}

	public void setCatalogosImpl(CatalogosGenericos catalogosImpl) {
		this.catalogosImpl = catalogosImpl;
	}

	/**
	 * @return the patiosUsuario
	 */
	public PatiosUsuario getPatiosUsuario() {
		return patiosUsuario;
	}

	/**
	 * @param patiosUsuario
	 *            the patiosUsuario to set
	 */
	public void setPatiosUsuario(PatiosUsuario patiosUsuario) {
		this.patiosUsuario = patiosUsuario;
	}

	/**
	 * @return the modelosMarcas
	 */
	public ModelosMarcas getModelosMarcas() {
		return modelosMarcas;
	}

	/**
	 * @param modelosMarcas
	 *            the modelosMarcas to set
	 */
	public void setModelosMarcas(ModelosMarcas modelosMarcas) {
		this.modelosMarcas = modelosMarcas;
	}

}
