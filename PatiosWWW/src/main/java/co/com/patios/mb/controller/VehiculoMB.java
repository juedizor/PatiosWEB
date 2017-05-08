//package co.com.patios.mb.controller;
//
//import java.io.IOException;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import javax.ejb.EJB;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpServletRequest;
//
//import org.primefaces.context.RequestContext;
//
//import co.com.patios.ejb.controller.MarcaVehiculoEJB;
//import co.com.patios.ejb.controller.ModeloVehiculoEJB;
//import co.com.patios.ejb.controller.UsuarioEJB;
//import co.com.patios.ejb.controller.VehiculoEJB;
//import co.com.patios.entity.MarcaVehiculo;
//import co.com.patios.entity.ModeloVehiculo;
//import co.com.patios.entity.Usuario;
//import co.com.patios.entity.Vehiculo;
//
//
//@ManagedBean (name = "vehiculoMB")
//@ViewScoped
//public class VehiculoMB {
//	
//	private Vehiculo vehiculo;
//	private ModeloVehiculo modeloVehiculo;
//	private MarcaVehiculo marcaVehiculo;
//	private Usuario usuario;
//	private String placa;
//	private String id_usuario;
//	private List<Vehiculo> lisVehiculos;
//	private String marca;
//	private Map<String, String> marcasVehiculos = new LinkedHashMap<String, String>();
//	private String modelo_vehiculo;
//	private Map<String, String> modelosVehiculos = new LinkedHashMap<String, String>();
//	
//	private HttpServletRequest httpServletRequestLogin;
//	private final FacesContext context;
//	
//	@EJB
//	VehiculoEJB vehiculoEJB;
//	@EJB
//	MarcaVehiculoEJB marcaVehiculoEJB;
//	@EJB
//	ModeloVehiculoEJB modeloVehiculoEJB;
//	@EJB
//	UsuarioEJB usuarioEJB;
//	
//	
//	
//	public VehiculoMB() {
//		vehiculo = new Vehiculo();
//		modeloVehiculo  = new ModeloVehiculo();
//		marcaVehiculo = new MarcaVehiculo();
//		usuario = new Usuario();
//		context = FacesContext.getCurrentInstance();
//		httpServletRequestLogin  = (HttpServletRequest) context.getExternalContext().getRequest();
//	}
//
//	
//	public void mayuscula(){
//		String textPlaca = this.vehiculo.getPlacaVehiculo();
//		this.vehiculo.setPlacaVehiculo(textPlaca.toUpperCase());
//	}
//	
//	public void editarVehiculo(){
//		MarcaVehiculo marcaVehiculo = new MarcaVehiculo();
//		ModeloVehiculo modeloVehiculo = new ModeloVehiculo();
//		modeloVehiculo.setIdModelo(Integer.parseInt(this.modelo_vehiculo));
//		marcaVehiculo.setIdMarcaVehiculo(Integer.parseInt(this.getMarca()));
//		vehiculo.setMarcaVehiculo(marcaVehiculo);
//		vehiculo.setModeloVehiculo(modeloVehiculo);
//		if(vehiculoEJB.consultarVehiculo(vehiculo.getPlacaVehiculo()) == null){
//		vehiculoEJB.editarRegistroVehiculo(vehiculo);
//		try {
//			FacesContext.getCurrentInstance().getExternalContext().redirect("listadoVehiculos.xhtml");
//			vehiculo = new Vehiculo();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		}else{
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error en edición","la placa ya existe"));
//			vehiculo = new Vehiculo();
//		}
//		
//		
//		
//	}
//	
//
//	
//	public void registrarVehiculo(String idMarca, String idModelo){
//		
//		RequestContext requestContext = RequestContext.getCurrentInstance();
//		FacesContext context = FacesContext.getCurrentInstance();
//		Usuario usuarioSession = (Usuario) httpServletRequestLogin.getSession().getAttribute("usuario");
//		
//	
//		if(!(vehiculoEJB.consultarVehiculo(this.vehiculo.getPlacaVehiculo())==null)){
//			requestContext.showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "La placa ya existe!!!"));
//		}else{
//			usuario = new Usuario();
//			if(usuarioSession==null){
//				try {
//					context.getExternalContext().redirect("../../index.xhtml");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}else{
//				usuario.setIdUsuario(usuarioEJB.buscarUsuario(usuarioSession.getIdentificacionUsuario()).getIdUsuario());
//				marcaVehiculo.setIdMarcaVehiculo(Integer.parseInt(idMarca));
//				vehiculo.setMarcaVehiculo(marcaVehiculo);
//				vehiculo.setUsuario(usuario);
//				modeloVehiculo.setIdModelo(Integer.parseInt(idModelo));
//				vehiculo.setModeloVehiculo(modeloVehiculo);
//				vehiculoEJB.insertVehiculo(vehiculo);
//				this.setPlaca("");
//				requestContext.showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito","Registro exitoso"));
//				vehiculo = new Vehiculo();
//				
//			}
//			
//			
//		}
//	}
//	
//	
//	public void llenarModelos(){
//		this.setModelosVehiculos(modeloVehiculoEJB.consultarModelosVehiculos(Integer.parseInt(this.marca)));
//	}
//	
//	public void cargarMarcasEditar(){
//		Vehiculo vehiculo = vehiculoEJB.consultarVehiculo(this.vehiculo.getIdVehiculo()); 
//		String idMarca = vehiculo.getMarcaVehiculo().getIdMarcaVehiculo().toString();
//		String descripcionMarca = vehiculo.getMarcaVehiculo().getNombreMarcaVehiculo();
//		Map<String, String> map = new LinkedHashMap<String,String>();
//		map.put(descripcionMarca,idMarca);
//		for(Entry<String, String> entryMap : marcaVehiculoEJB.consultarMarcasVehiculos().entrySet()){
//			if(!entryMap.getValue().equals(idMarca)){
//				map.put(entryMap.getKey(), entryMap.getValue());
//			}
//		}
//		this.setMarcasVehiculos(map);
//		
//	}
//
//	
//	public void capturarSeleccion(String placa){
//		this.setVehiculo(vehiculoEJB.consultarVehiculo(placa));
//		cargarMarcasEditar();
//	}
//	
//	/**
//	 * @return the vehiculo
//	 */
//	public Vehiculo getVehiculo() {
//		return vehiculo;
//	}
//
//
//	/**
//	 * @param vehiculo the vehiculo to set
//	 */
//	public void setVehiculo(Vehiculo vehiculo) {
//		this.vehiculo = vehiculo;
//	}
//
//
//	/**
//	 * @return the vehiculoEJB
//	 */
//	public VehiculoEJB getVehiculoEJB() {
//		return vehiculoEJB;
//	}
//
//
//	/**
//	 * @param vehiculoEJB the vehiculoEJB to set
//	 */
//	public void setVehiculoEJB(VehiculoEJB vehiculoEJB) {
//		this.vehiculoEJB = vehiculoEJB;
//	}
//
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
//	 * @return the modeloVehiculo
//	 */
//	public ModeloVehiculo getModeloVehiculo() {
//		return modeloVehiculo;
//	}
//
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
//	/**
//	 * @return the usuario
//	 */
//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//
//
//	/**
//	 * @param usuario the usuario to set
//	 */
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
//
//
//
//	/**
//	 * @return the modeloVehiculoEJB
//	 */
//	public ModeloVehiculoEJB getModeloVehiculoEJB() {
//		return modeloVehiculoEJB;
//	}
//
//
//
//	/**
//	 * @param modeloVehiculoEJB the modeloVehiculoEJB to set
//	 */
//	public void setModeloVehiculoEJB(ModeloVehiculoEJB modeloVehiculoEJB) {
//		this.modeloVehiculoEJB = modeloVehiculoEJB;
//	}
//
//
//
//	/**
//	 * @return the id_usuario
//	 */
//	public String getId_usuario() {
//		return id_usuario;
//	}
//
//
//
//	/**
//	 * @param id_usuario the id_usuario to set
//	 */
//	public void setId_usuario(String id_usuario) {
//		this.id_usuario = id_usuario;
//	}
//
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
//
//	/**
//	 * @param marcaVehiculo the marcaVehiculo to set
//	 */
//	public void setMarcaVehiculo(MarcaVehiculo marcaVehiculo) {
//		this.marcaVehiculo = marcaVehiculo;
//	}
//
//	/**
//	 * @return the marcaVehiculoEJB
//	 */
//	public MarcaVehiculoEJB getMarcaVehiculoEJB() {
//		return marcaVehiculoEJB;
//	}
//
//
//
//	/**
//	 * @param marcaVehiculoEJB the marcaVehiculoEJB to set
//	 */
//	public void setMarcaVehiculoEJB(MarcaVehiculoEJB marcaVehiculoEJB) {
//		this.marcaVehiculoEJB = marcaVehiculoEJB;
//	}
//
//
//
//	/**
//	 * @return the usuarioEJB
//	 */
//	public UsuarioEJB getUsuarioEJB() {
//		return usuarioEJB;
//	}
//
//
//
//	/**
//	 * @param usuarioEJB the usuarioEJB to set
//	 */
//	public void setUsuarioEJB(UsuarioEJB usuarioEJB) {
//		this.usuarioEJB = usuarioEJB;
//	}
//
//
//
//	/**
//	 * @return the lisVehiculos
//	 */
//	public List<Vehiculo> getLisVehiculos() {
//		return lisVehiculos;
//	}
//
//
//
//	/**
//	 * @param lisVehiculos the lisVehiculos to set
//	 */
//	public void setLisVehiculos(List<Vehiculo> lisVehiculos) {
//		this.lisVehiculos = lisVehiculos;
//	}
//
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
//
//	/**
//	 * @param marcasVehiculos the marcasVehiculos to set
//	 */
//	public void setMarcasVehiculos(Map<String, String> marcasVehiculos) {
//		this.marcasVehiculos = marcasVehiculos;
//	}
//
//
//
//	/**
//	 * @return the marca
//	 */
//	public String getMarca() {
//		return marca;
//	}
//
//
//
//	/**
//	 * @param marca the marca to set
//	 */
//	public void setMarca(String marca) {
//		this.marca = marca;
//	}
//
//
//	/**
//	 * @return the modelosVehiculos
//	 */
//	public Map<String, String> getModelosVehiculos() {
//		return modelosVehiculos;
//	}
//
//
//	/**
//	 * @param modelosVehiculos the modelosVehiculos to set
//	 */
//	public void setModelosVehiculos(Map<String, String> modelosVehiculos) {
//		this.modelosVehiculos = modelosVehiculos;
//	}
//
//
//	/**
//	 * @return the modelo_vehiculo
//	 */
//	public String getModelo_vehiculo() {
//		return modelo_vehiculo;
//	}
//
//
//	/**
//	 * @param modelo_vehiculo the modelo_vehiculo to set
//	 */
//	public void setModelo_vehiculo(String modelo_vehiculo) {
//		this.modelo_vehiculo = modelo_vehiculo;
//	}
//
//
//
//
//
//	
//	
//
//	
//}
