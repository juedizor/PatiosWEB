//package co.com.patios.mb.controller;
//
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import javax.ejb.EJB;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//
//
//
//
//import javax.faces.context.FacesContext;
//
//import org.primefaces.context.RequestContext;
//
//import co.com.patios.ejb.controller.EntradaVehiculoPatioEJB;
//import co.com.patios.ejb.controller.MarcaVehiculoEJB;
//import co.com.patios.ejb.controller.ModeloVehiculoEJB;
//import co.com.patios.ejb.controller.PatioEJB;
//import co.com.patios.ejb.controller.VehiculoEJB;
//import co.com.patios.entity.EntradaVehiculoPatio;
//import co.com.patios.entity.MarcaVehiculo;
//import co.com.patios.entity.ModeloVehiculo;
//import co.com.patios.entity.Patio;
//import co.com.patios.mb.util.MessagesEstaticos;
//import co.com.patios.mb.util.Utilidades;
//
//
//@ManagedBean (name = "editarEntradaVehiculoMB")
//@ViewScoped
//public class EditarEntradaVehiculoMB {
//	
//	
//	private String placa;
//	private String numeroMotor;
//	private String numeroSerie;
//	private String numeroChasis;
//	
//	private int idEntrada;
//	private EntradaVehiculoPatio entradaVehiculoPatio;
//	private MarcaVehiculo marcaVehiculo;
//	private ModeloVehiculo modeloVehiculo;
//	private Patio patio;
//	
//	
//	//maneja el onemenu de las marcas de vehiculos
//	private String marcaAuto;
//	private Map<String,String> marcasVehiculos = new LinkedHashMap<String, String>();
//		
//	// maneja el onemenu de los modelos de los vehiculos
//	private String modeloAuto;
//	private Map<String, String> modeloVehiculos = new LinkedHashMap<String, String>();
//	
//	
//	// maneja el onemenu de los patios de los vehiculos
//	private String patios;
//	private Map<String, String> patiosEntrada = new LinkedHashMap<String, String>();
//	
//	
//	@EJB
//	EntradaVehiculoPatioEJB entradaVehiculoPatioEJB;
//	@EJB 
//	MarcaVehiculoEJB marcaVehiculoEJB;
//	@EJB 
//	ModeloVehiculoEJB modeloVehiculoEJB;
//	@EJB 
//	PatioEJB patioEJB;
//	@EJB 
//	VehiculoEJB vehiculoEJB;
//	
//	
//	public EditarEntradaVehiculoMB() {
//		entradaVehiculoPatio = new EntradaVehiculoPatio();
//		marcaVehiculo = new MarcaVehiculo();
//		modeloVehiculo = new ModeloVehiculo();
//		patio = new Patio();
//	}
//
//	
//	/**
//	 * realiza la conversion de los campos de la pagina entradaPatios.xhmtl en mayuscula, una vez sean 
//	 * digitados los mismos
//	 */
//	public void convertMayuscula(){
//		if(this.placa!=null){
//			this.placa = Utilidades.convertirMayusculas(this.placa);
//		}
//		
//		if(this.numeroMotor!=null){
//			this.numeroMotor = Utilidades.convertirMayusculas(this.numeroMotor);
//		}
//		
//		if(this.numeroChasis!=null){
//			this.numeroChasis = Utilidades.convertirMayusculas(this.numeroChasis);
//		}
//		
//		if(this.numeroSerie!=null){
//			this.numeroSerie = Utilidades.convertirMayusculas(this.numeroSerie);
//		}
//	}
//	
//	
//
//	/**
//	 * captura los datos de un vehiculo a editar su entrada
//	 * @param idEntrada
//	 */
//	public void capturarDatosEditar(int idEntrada){
//		setMarcaAuto("");
//		setModeloAuto("");
//		setPatios("");
//		entradaVehiculoPatio = entradaVehiculoPatioEJB.consultarEntradaVehiculo(idEntrada);
//		setValoresEntradaSeleccionada();
//		
//		/**
//		 * llena los modelos de vehiculos, teniendo en cuenta al entrada seleccionada
//		 */
//		Map<String, String> marcaVehiculoSeleccionado = new LinkedHashMap<String, String>();
//		marcaVehiculoSeleccionado.put(entradaVehiculoPatio.getVehiculo().getMarcaVehiculo().getNombreMarcaVehiculo(), 
//				entradaVehiculoPatio.getVehiculo().getMarcaVehiculo().getIdMarcaVehiculo().toString());
//		Map<String, String> marcasAutos = new LinkedHashMap<String, String>(); 
//		marcasAutos = marcaVehiculoEJB.consultarMarcasVehiculos(entradaVehiculoPatio.getVehiculo().getMarcaVehiculo().getIdMarcaVehiculo());
//		marcasVehiculos = new LinkedHashMap<String, String>();
//		marcasVehiculos.putAll(marcaVehiculoSeleccionado);
//		marcasVehiculos.putAll(marcasAutos);
//		
//		/**
//		 * llena los modelos de vehiculos, teniendo en cuenta al entrada seleccionada
//		 */
//		Map<String, String> modeloVehiculoSeleccionado = new LinkedHashMap<String, String>();
//		modeloVehiculoSeleccionado.put(entradaVehiculoPatio.getVehiculo().getModeloVehiculo().getModeloVehiculo(), 
//				entradaVehiculoPatio.getVehiculo().getModeloVehiculo().getIdModelo().toString());
//		Map<String, String> modelosVehiculos = modeloVehiculoEJB.consultarModelosVehiculos(entradaVehiculoPatio.getVehiculo().getMarcaVehiculo().getIdMarcaVehiculo(), 
//				entradaVehiculoPatio.getVehiculo().getModeloVehiculo().getIdModelo());
//		modeloVehiculos = new LinkedHashMap<String, String>();
//		modeloVehiculos.putAll(modeloVehiculoSeleccionado);
//		modeloVehiculos.putAll(modelosVehiculos);
//		
//		
//		/**
//		 * llena los patios, teniendo en cuenta al entrada seleccionada
//		 */
//		Map<String, String> patiosVehiculoSeleccionado = new LinkedHashMap<String, String>();
//		patiosVehiculoSeleccionado.put(entradaVehiculoPatio.getPatio().getNombrePatio(), 
//				entradaVehiculoPatio.getPatio().getIdPatio().toString());
//		Map<String, String> patiosVehiculosEntrada = patioEJB.consultarPatioNotInIdPatio(entradaVehiculoPatio.getPatio().getIdPatio());
//		patiosEntrada = new LinkedHashMap<String, String>();
//		patiosEntrada.putAll(patiosVehiculoSeleccionado);
//		patiosEntrada.putAll(patiosVehiculosEntrada);
//		
//		
//		
//	}
//	
//	
//	
//	/**
//	 * set de valores para la pagina de edicion de entrada de vehiculos a patios
//	 */
//	private void setValoresEntradaSeleccionada(){
//		setPlaca(entradaVehiculoPatio.getVehiculo().getPlacaVehiculo());
//		setNumeroChasis(entradaVehiculoPatio.getVehiculo().getNumeroChasisVehiculo());
//		setNumeroMotor(entradaVehiculoPatio.getVehiculo().getNumeroMotorVehiculo());
//		setNumeroSerie(entradaVehiculoPatio.getVehiculo().getNumeroSerieVehiculo());
//	}
//	
//	
//	
//	/**
//	 * llena los modelos relacionados a una marca de un vehiculo
//	 * @param marcaVehiculo
//	 */
//	public void llenarModelos(int marcaVehiculo){
//		this.setModeloVehiculos(modeloVehiculoEJB.consultarModelosVehiculos(marcaVehiculo));
//	}
//	
//	/**
//	 * llena los modelos de vehiculos segun la marca seleccionada en la pagina entradaPatios.xhmtl
//	 */
//	public void llenarModelos(){
//		this.setModeloVehiculos(modeloVehiculoEJB.consultarModelosVehiculos(Integer.parseInt(this.marcaAuto)));
//	}
//	
//	
//	/**
//	 * realiza la edicion de la entrada de vehiculos a patios, segun la modificacion que se haga en la pagina xhtml
//	 *  listadoEntradaVehiculos
//	 * 
//	 */
//	public void editarEntradaVehiculo(){
//		FacesContext context = FacesContext.getCurrentInstance();
//		FacesMessage message = new FacesMessage();
//		setDatosEdicionEntrada();
//		vehiculoEJB.editarRegistroVehiculo(entradaVehiculoPatio.getVehiculo());
//		entradaVehiculoPatioEJB.editarEntradaVehiculo(entradaVehiculoPatio);
//		RequestContext requestContext = RequestContext.getCurrentInstance();
//		requestContext.execute("PF('dialogoEdicion').hide();");
//		requestContext.update("form");
//		message.setSeverity(FacesMessage.SEVERITY_INFO);
//		message.setSummary(MessagesEstaticos.getMensajeCabeceraExito());
//		message.setDetail(MessagesEstaticos.getEdicionExitosa());		
//		context.addMessage("", message);
//	
//		
//			
//	}
//	
//	
//	/**
//	 * set de datos que se van a editar en el sistema, para una entrada relacionada
//	 */
//	private void setDatosEdicionEntrada(){
//		marcaVehiculo.setIdMarcaVehiculo(Integer.parseInt(marcaAuto));
//		modeloVehiculo.setIdModelo(Integer.parseInt(modeloAuto));
//		entradaVehiculoPatio.getVehiculo().setMarcaVehiculo(marcaVehiculo);
//		entradaVehiculoPatio.getVehiculo().setModeloVehiculo(modeloVehiculo);
//		entradaVehiculoPatio.getVehiculo().setNumeroChasisVehiculo(numeroChasis);
//		entradaVehiculoPatio.getVehiculo().setNumeroMotorVehiculo(numeroMotor);
//		entradaVehiculoPatio.getVehiculo().setNumeroSerieVehiculo(numeroSerie);
//		patio = patioEJB.consultarPatio(Integer.parseInt(patios));
//		entradaVehiculoPatio.setPatio(patio);
//	}
//
//
//	/**
//	 * @return the idEntrada
//	 */
//	public int getIdEntrada() {
//		return idEntrada;
//	}
//
//
//	/**
//	 * @param idEntrada the idEntrada to set
//	 */
//	public void setIdEntrada(int idEntrada) {
//		this.idEntrada = idEntrada;
//	}
//
//
//	/**
//	 * @return the entradaVehiculoPatio
//	 */
//	public EntradaVehiculoPatio getEntradaVehiculoPatio() {
//		return entradaVehiculoPatio;
//	}
//
//
//	/**
//	 * @param entradaVehiculoPatio the entradaVehiculoPatio to set
//	 */
//	public void setEntradaVehiculoPatio(EntradaVehiculoPatio entradaVehiculoPatio) {
//		this.entradaVehiculoPatio = entradaVehiculoPatio;
//	}
//
//
//	/**
//	 * @return the marcaAuto
//	 */
//	public String getMarcaAuto() {
//		return marcaAuto;
//	}
//
//
//	/**
//	 * @param marcaAuto the marcaAuto to set
//	 */
//	public void setMarcaAuto(String marcaAuto) {
//		this.marcaAuto = marcaAuto;
//	}
//
//
//	/**
//	 * @return the marcasVehiculos
//	 */
//	public Map<String, String> getMarcasVehiculos() {
//		return marcasVehiculos;
//	}
//
//
//	/**
//	 * @param marcasVehiculos the marcasVehiculos to set
//	 */
//	public void setMarcasVehiculos(Map<String, String> marcasVehiculos) {
//		this.marcasVehiculos = marcasVehiculos;
//	}
//
//
//	/**
//	 * @return the modeloAuto
//	 */
//	public String getModeloAuto() {
//		return modeloAuto;
//	}
//
//
//	/**
//	 * @param modeloAuto the modeloAuto to set
//	 */
//	public void setModeloAuto(String modeloAuto) {
//		this.modeloAuto = modeloAuto;
//	}
//
//
//	/**
//	 * @return the modeloVehiculos
//	 */
//	public Map<String, String> getModeloVehiculos() {
//		return modeloVehiculos;
//	}
//
//
//	/**
//	 * @param modeloVehiculos the modeloVehiculos to set
//	 */
//	public void setModeloVehiculos(Map<String, String> modeloVehiculos) {
//		this.modeloVehiculos = modeloVehiculos;
//	}
//
//
//	/**
//	 * @return the placa
//	 */
//	public String getPlaca() {
//		return placa;
//	}
//
//
//	/**
//	 * @param placa the placa to set
//	 */
//	public void setPlaca(String placa) {
//		this.placa = placa;
//	}
//
//
//	/**
//	 * @return the numeroMotor
//	 */
//	public String getNumeroMotor() {
//		return numeroMotor;
//	}
//
//
//	/**
//	 * @param numeroMotor the numeroMotor to set
//	 */
//	public void setNumeroMotor(String numeroMotor) {
//		this.numeroMotor = numeroMotor;
//	}
//
//
//	/**
//	 * @return the numeroSerie
//	 */
//	public String getNumeroSerie() {
//		return numeroSerie;
//	}
//
//
//	/**
//	 * @param numeroSerie the numeroSerie to set
//	 */
//	public void setNumeroSerie(String numeroSerie) {
//		this.numeroSerie = numeroSerie;
//	}
//
//
//	/**
//	 * @return the numeroChasis
//	 */
//	public String getNumeroChasis() {
//		return numeroChasis;
//	}
//
//
//	/**
//	 * @param numeroChasis the numeroChasis to set
//	 */
//	public void setNumeroChasis(String numeroChasis) {
//		this.numeroChasis = numeroChasis;
//	}
//
//
//	/**
//	 * @return the patios
//	 */
//	public String getPatios() {
//		return patios;
//	}
//
//
//	/**
//	 * @param patios the patios to set
//	 */
//	public void setPatios(String patios) {
//		this.patios = patios;
//	}
//
//
//	/**
//	 * @return the patiosEntrada
//	 */
//	public Map<String, String> getPatiosEntrada() {
//		return patiosEntrada;
//	}
//
//
//	/**
//	 * @param patiosEntrada the patiosEntrada to set
//	 */
//	public void setPatiosEntrada(Map<String, String> patiosEntrada) {
//		this.patiosEntrada = patiosEntrada;
//	}
//
//
//	/**
//	 * @return the marcaVehiculo
//	 */
//	public MarcaVehiculo getMarcaVehiculo() {
//		return marcaVehiculo;
//	}
//
//
//	/**
//	 * @param marcaVehiculo the marcaVehiculo to set
//	 */
//	public void setMarcaVehiculo(MarcaVehiculo marcaVehiculo) {
//		this.marcaVehiculo = marcaVehiculo;
//	}
//
//
//	/**
//	 * @return the modeloVehiculo
//	 */
//	public ModeloVehiculo getModeloVehiculo() {
//		return modeloVehiculo;
//	}
//
//
//	/**
//	 * @param modeloVehiculo the modeloVehiculo to set
//	 */
//	public void setModeloVehiculo(ModeloVehiculo modeloVehiculo) {
//		this.modeloVehiculo = modeloVehiculo;
//	}
//
//
//	public Patio getPatio() {
//		return patio;
//	}
//
//
//	public void setPatio(Patio patio) {
//		this.patio = patio;
//	}
//
//
//	
//
//
//}
