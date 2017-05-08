package co.com.patios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona")
	private Integer idPersona;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_proceso")
	private Date fechaProceso;

	@Column(name="nombre_comercial_persona")
	private String nombreComercialPersona;

	@Column(name="numero_identificacion")
	private BigDecimal numeroIdentificacion;

	@Column(name="primer_apellido_persona")
	private String primerApellidoPersona;

	@Column(name="primer_nombre_persona")
	private String primerNombrePersona;

	@Column(name="segundo_apellido_persona")
	private String segundoApellidoPersona;

	@Column(name="segundo_nombre_persona")
	private String segundoNombrePersona;

	//bi-directional many-to-one association to DireccionPersona
	@OneToMany(mappedBy="persona")
	private List<DireccionPersona> direccionPersonas;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="id_ciudad")
	private Ciudad ciudad;

	//bi-directional many-to-one association to TipoIdentificacion
	@ManyToOne
	@JoinColumn(name="id_tipo_identificacion")
	private TipoIdentificacion tipoIdentificacion;

	//bi-directional many-to-one association to TelefonoPersona
	@OneToMany(mappedBy="persona")
	private List<TelefonoPersona> telefonoPersonas;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="persona")
	private List<Usuario> usuarios;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="persona")
	private List<Vehiculo> vehiculos;

	public Persona() {
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Date getFechaProceso() {
		return this.fechaProceso;
	}

	public void setFechaProceso(Date fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public String getNombreComercialPersona() {
		return this.nombreComercialPersona;
	}

	public void setNombreComercialPersona(String nombreComercialPersona) {
		this.nombreComercialPersona = nombreComercialPersona;
	}

	public BigDecimal getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}

	public void setNumeroIdentificacion(BigDecimal numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getPrimerApellidoPersona() {
		return this.primerApellidoPersona;
	}

	public void setPrimerApellidoPersona(String primerApellidoPersona) {
		this.primerApellidoPersona = primerApellidoPersona;
	}

	public String getPrimerNombrePersona() {
		return this.primerNombrePersona;
	}

	public void setPrimerNombrePersona(String primerNombrePersona) {
		this.primerNombrePersona = primerNombrePersona;
	}

	public String getSegundoApellidoPersona() {
		return this.segundoApellidoPersona;
	}

	public void setSegundoApellidoPersona(String segundoApellidoPersona) {
		this.segundoApellidoPersona = segundoApellidoPersona;
	}

	public String getSegundoNombrePersona() {
		return this.segundoNombrePersona;
	}

	public void setSegundoNombrePersona(String segundoNombrePersona) {
		this.segundoNombrePersona = segundoNombrePersona;
	}

	public List<DireccionPersona> getDireccionPersonas() {
		return this.direccionPersonas;
	}

	public void setDireccionPersonas(List<DireccionPersona> direccionPersonas) {
		this.direccionPersonas = direccionPersonas;
	}

	public DireccionPersona addDireccionPersona(DireccionPersona direccionPersona) {
		getDireccionPersonas().add(direccionPersona);
		direccionPersona.setPersona(this);

		return direccionPersona;
	}

	public DireccionPersona removeDireccionPersona(DireccionPersona direccionPersona) {
		getDireccionPersonas().remove(direccionPersona);
		direccionPersona.setPersona(null);

		return direccionPersona;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public List<TelefonoPersona> getTelefonoPersonas() {
		return this.telefonoPersonas;
	}

	public void setTelefonoPersonas(List<TelefonoPersona> telefonoPersonas) {
		this.telefonoPersonas = telefonoPersonas;
	}

	public TelefonoPersona addTelefonoPersona(TelefonoPersona telefonoPersona) {
		getTelefonoPersonas().add(telefonoPersona);
		telefonoPersona.setPersona(this);

		return telefonoPersona;
	}

	public TelefonoPersona removeTelefonoPersona(TelefonoPersona telefonoPersona) {
		getTelefonoPersonas().remove(telefonoPersona);
		telefonoPersona.setPersona(null);

		return telefonoPersona;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPersona(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPersona(null);

		return usuario;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setPersona(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setPersona(null);

		return vehiculo;
	}

}