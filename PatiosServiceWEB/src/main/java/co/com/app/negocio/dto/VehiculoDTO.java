package co.com.app.negocio.dto;

import java.io.Serializable;
import java.sql.Timestamp;


public class VehiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idVehiculo;
	private Timestamp fechaProceso;
	private String numeroChasisVehiculo;
	private String numeroMotorVehiculo;
	private String numeroSerieVehiculo;
	private String placaVehiculo;
	private ClaseVehiculoDTO claseVehiculo;
	private ColorVehiculoDTO colorVehiculo;
	private EstadoVehiculoDTO estadoVehiculo;
	private ModeloVehiculoDTO modeloVehiculo;
	private OrganismoTransitoDTO organismoTransito;
	private PersonaDTO persona;
	private UsuarioDTO usuario;

	public VehiculoDTO() {
	}

	public Integer getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Timestamp getFechaProceso() {
		return this.fechaProceso;
	}

	public void setFechaProceso(Timestamp fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public String getNumeroChasisVehiculo() {
		return this.numeroChasisVehiculo;
	}

	public void setNumeroChasisVehiculo(String numeroChasisVehiculo) {
		this.numeroChasisVehiculo = numeroChasisVehiculo;
	}

	public String getNumeroMotorVehiculo() {
		return this.numeroMotorVehiculo;
	}

	public void setNumeroMotorVehiculo(String numeroMotorVehiculo) {
		this.numeroMotorVehiculo = numeroMotorVehiculo;
	}

	public String getNumeroSerieVehiculo() {
		return this.numeroSerieVehiculo;
	}

	public void setNumeroSerieVehiculo(String numeroSerieVehiculo) {
		this.numeroSerieVehiculo = numeroSerieVehiculo;
	}

	public String getPlacaVehiculo() {
		return this.placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public ClaseVehiculoDTO getClaseVehiculo() {
		return this.claseVehiculo;
	}

	public void setClaseVehiculo(ClaseVehiculoDTO claseVehiculo) {
		this.claseVehiculo = claseVehiculo;
	}

	public ColorVehiculoDTO getColorVehiculo() {
		return this.colorVehiculo;
	}

	public void setColorVehiculo(ColorVehiculoDTO colorVehiculo) {
		this.colorVehiculo = colorVehiculo;
	}

	public EstadoVehiculoDTO getEstadoVehiculo() {
		return this.estadoVehiculo;
	}

	public void setEstadoVehiculo(EstadoVehiculoDTO estadoVehiculo) {
		this.estadoVehiculo = estadoVehiculo;
	}

	public ModeloVehiculoDTO getModeloVehiculo() {
		return this.modeloVehiculo;
	}

	public void setModeloVehiculo(ModeloVehiculoDTO modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}

	public OrganismoTransitoDTO getOrganismoTransito() {
		return this.organismoTransito;
	}

	public void setOrganismoTransito(OrganismoTransitoDTO organismoTransito) {
		this.organismoTransito = organismoTransito;
	}

	public PersonaDTO getPersona() {
		return this.persona;
	}

	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}

	public UsuarioDTO getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

}