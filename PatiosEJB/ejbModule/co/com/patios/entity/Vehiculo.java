package co.com.patios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vehiculo database table.
 * 
 */
@Entity
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vehiculo")
	private Integer idVehiculo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_proceso")
	private Date fechaProceso;

	@Column(name="numero_chasis_vehiculo")
	private String numeroChasisVehiculo;

	@Column(name="numero_motor_vehiculo")
	private String numeroMotorVehiculo;

	@Column(name="numero_serie_vehiculo")
	private String numeroSerieVehiculo;

	@Column(name="placa_vehiculo")
	private String placaVehiculo;

	//bi-directional many-to-one association to EntradaVehiculoPatio
	@OneToMany(mappedBy="vehiculo")
	private List<EntradaVehiculoPatio> entradaVehiculoPatios;

	//bi-directional many-to-one association to ClaseVehiculo
	@ManyToOne
	@JoinColumn(name="id_clase_vehiculo")
	private ClaseVehiculo claseVehiculo;

	//bi-directional many-to-one association to ColorVehiculo
	@ManyToOne
	@JoinColumn(name="id_color_vehiculo")
	private ColorVehiculo colorVehiculo;

	//bi-directional many-to-one association to EstadoVehiculo
	@ManyToOne
	@JoinColumn(name="id_estado_vehiculo")
	private EstadoVehiculo estadoVehiculo;

	//bi-directional many-to-one association to ModeloVehiculo
	@ManyToOne
	@JoinColumn(name="id_modelo_vehiculo")
	private ModeloVehiculo modeloVehiculo;

	//bi-directional many-to-one association to OrganismoTransito
	@ManyToOne
	@JoinColumn(name="id_organismo_transito")
	private OrganismoTransito organismoTransito;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Vehiculo() {
	}

	public Integer getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Date getFechaProceso() {
		return this.fechaProceso;
	}

	public void setFechaProceso(Date fechaProceso) {
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

	public List<EntradaVehiculoPatio> getEntradaVehiculoPatios() {
		return this.entradaVehiculoPatios;
	}

	public void setEntradaVehiculoPatios(List<EntradaVehiculoPatio> entradaVehiculoPatios) {
		this.entradaVehiculoPatios = entradaVehiculoPatios;
	}

	public EntradaVehiculoPatio addEntradaVehiculoPatio(EntradaVehiculoPatio entradaVehiculoPatio) {
		getEntradaVehiculoPatios().add(entradaVehiculoPatio);
		entradaVehiculoPatio.setVehiculo(this);

		return entradaVehiculoPatio;
	}

	public EntradaVehiculoPatio removeEntradaVehiculoPatio(EntradaVehiculoPatio entradaVehiculoPatio) {
		getEntradaVehiculoPatios().remove(entradaVehiculoPatio);
		entradaVehiculoPatio.setVehiculo(null);

		return entradaVehiculoPatio;
	}

	public ClaseVehiculo getClaseVehiculo() {
		return this.claseVehiculo;
	}

	public void setClaseVehiculo(ClaseVehiculo claseVehiculo) {
		this.claseVehiculo = claseVehiculo;
	}

	public ColorVehiculo getColorVehiculo() {
		return this.colorVehiculo;
	}

	public void setColorVehiculo(ColorVehiculo colorVehiculo) {
		this.colorVehiculo = colorVehiculo;
	}

	public EstadoVehiculo getEstadoVehiculo() {
		return this.estadoVehiculo;
	}

	public void setEstadoVehiculo(EstadoVehiculo estadoVehiculo) {
		this.estadoVehiculo = estadoVehiculo;
	}

	public ModeloVehiculo getModeloVehiculo() {
		return this.modeloVehiculo;
	}

	public void setModeloVehiculo(ModeloVehiculo modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}

	public OrganismoTransito getOrganismoTransito() {
		return this.organismoTransito;
	}

	public void setOrganismoTransito(OrganismoTransito organismoTransito) {
		this.organismoTransito = organismoTransito;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}