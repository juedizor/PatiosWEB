package co.com.patios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer idUsuario;

	@Column(name="clave_usuario")
	private String claveUsuario;

	@Column(name="estado_usuario")
	private String estadoUsuario;

	@Column(name="login_usuario")
	private String loginUsuario;

	//bi-directional many-to-one association to ConsecutivoVolante
	@OneToMany(mappedBy="usuario")
	private List<ConsecutivoVolante> consecutivoVolantes;

	//bi-directional many-to-one association to DetalleVolantePatio
	@OneToMany(mappedBy="usuario")
	private List<DetalleVolantePatio> detalleVolantePatios;

	//bi-directional many-to-one association to DireccionPersona
	@OneToMany(mappedBy="usuario")
	private List<DireccionPersona> direccionPersonas;

	//bi-directional many-to-one association to EntradaVehiculoPatio
	@OneToMany(mappedBy="usuario")
	private List<EntradaVehiculoPatio> entradaVehiculoPatios;

	//bi-directional many-to-one association to OrganismoTransito
	@OneToMany(mappedBy="usuario")
	private List<OrganismoTransito> organismoTransitos;

	//bi-directional many-to-one association to Patio
	@OneToMany(mappedBy="usuario")
	private List<Patio> patios;

	//bi-directional many-to-one association to TelefonoPersona
	@OneToMany(mappedBy="usuario")
	private List<TelefonoPersona> telefonoPersonas;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	//bi-directional many-to-one association to UsuarioPatio
	@OneToMany(mappedBy="usuario1")
	private List<UsuarioPatio> usuarioPatios1;

	//bi-directional many-to-one association to UsuarioPatio
	@OneToMany(mappedBy="usuario2")
	private List<UsuarioPatio> usuarioPatios2;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="usuario")
	private List<Vehiculo> vehiculos;

	//bi-directional many-to-one association to VolantePatio
	@OneToMany(mappedBy="usuario")
	private List<VolantePatio> volantePatios;

	public Usuario() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getClaveUsuario() {
		return this.claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public String getEstadoUsuario() {
		return this.estadoUsuario;
	}

	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public String getLoginUsuario() {
		return this.loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public List<ConsecutivoVolante> getConsecutivoVolantes() {
		return this.consecutivoVolantes;
	}

	public void setConsecutivoVolantes(List<ConsecutivoVolante> consecutivoVolantes) {
		this.consecutivoVolantes = consecutivoVolantes;
	}

	public ConsecutivoVolante addConsecutivoVolante(ConsecutivoVolante consecutivoVolante) {
		getConsecutivoVolantes().add(consecutivoVolante);
		consecutivoVolante.setUsuario(this);

		return consecutivoVolante;
	}

	public ConsecutivoVolante removeConsecutivoVolante(ConsecutivoVolante consecutivoVolante) {
		getConsecutivoVolantes().remove(consecutivoVolante);
		consecutivoVolante.setUsuario(null);

		return consecutivoVolante;
	}

	public List<DetalleVolantePatio> getDetalleVolantePatios() {
		return this.detalleVolantePatios;
	}

	public void setDetalleVolantePatios(List<DetalleVolantePatio> detalleVolantePatios) {
		this.detalleVolantePatios = detalleVolantePatios;
	}

	public DetalleVolantePatio addDetalleVolantePatio(DetalleVolantePatio detalleVolantePatio) {
		getDetalleVolantePatios().add(detalleVolantePatio);
		detalleVolantePatio.setUsuario(this);

		return detalleVolantePatio;
	}

	public DetalleVolantePatio removeDetalleVolantePatio(DetalleVolantePatio detalleVolantePatio) {
		getDetalleVolantePatios().remove(detalleVolantePatio);
		detalleVolantePatio.setUsuario(null);

		return detalleVolantePatio;
	}

	public List<DireccionPersona> getDireccionPersonas() {
		return this.direccionPersonas;
	}

	public void setDireccionPersonas(List<DireccionPersona> direccionPersonas) {
		this.direccionPersonas = direccionPersonas;
	}

	public DireccionPersona addDireccionPersona(DireccionPersona direccionPersona) {
		getDireccionPersonas().add(direccionPersona);
		direccionPersona.setUsuario(this);

		return direccionPersona;
	}

	public DireccionPersona removeDireccionPersona(DireccionPersona direccionPersona) {
		getDireccionPersonas().remove(direccionPersona);
		direccionPersona.setUsuario(null);

		return direccionPersona;
	}

	public List<EntradaVehiculoPatio> getEntradaVehiculoPatios() {
		return this.entradaVehiculoPatios;
	}

	public void setEntradaVehiculoPatios(List<EntradaVehiculoPatio> entradaVehiculoPatios) {
		this.entradaVehiculoPatios = entradaVehiculoPatios;
	}

	public EntradaVehiculoPatio addEntradaVehiculoPatio(EntradaVehiculoPatio entradaVehiculoPatio) {
		getEntradaVehiculoPatios().add(entradaVehiculoPatio);
		entradaVehiculoPatio.setUsuario(this);

		return entradaVehiculoPatio;
	}

	public EntradaVehiculoPatio removeEntradaVehiculoPatio(EntradaVehiculoPatio entradaVehiculoPatio) {
		getEntradaVehiculoPatios().remove(entradaVehiculoPatio);
		entradaVehiculoPatio.setUsuario(null);

		return entradaVehiculoPatio;
	}

	public List<OrganismoTransito> getOrganismoTransitos() {
		return this.organismoTransitos;
	}

	public void setOrganismoTransitos(List<OrganismoTransito> organismoTransitos) {
		this.organismoTransitos = organismoTransitos;
	}

	public OrganismoTransito addOrganismoTransito(OrganismoTransito organismoTransito) {
		getOrganismoTransitos().add(organismoTransito);
		organismoTransito.setUsuario(this);

		return organismoTransito;
	}

	public OrganismoTransito removeOrganismoTransito(OrganismoTransito organismoTransito) {
		getOrganismoTransitos().remove(organismoTransito);
		organismoTransito.setUsuario(null);

		return organismoTransito;
	}

	public List<Patio> getPatios() {
		return this.patios;
	}

	public void setPatios(List<Patio> patios) {
		this.patios = patios;
	}

	public Patio addPatio(Patio patio) {
		getPatios().add(patio);
		patio.setUsuario(this);

		return patio;
	}

	public Patio removePatio(Patio patio) {
		getPatios().remove(patio);
		patio.setUsuario(null);

		return patio;
	}

	public List<TelefonoPersona> getTelefonoPersonas() {
		return this.telefonoPersonas;
	}

	public void setTelefonoPersonas(List<TelefonoPersona> telefonoPersonas) {
		this.telefonoPersonas = telefonoPersonas;
	}

	public TelefonoPersona addTelefonoPersona(TelefonoPersona telefonoPersona) {
		getTelefonoPersonas().add(telefonoPersona);
		telefonoPersona.setUsuario(this);

		return telefonoPersona;
	}

	public TelefonoPersona removeTelefonoPersona(TelefonoPersona telefonoPersona) {
		getTelefonoPersonas().remove(telefonoPersona);
		telefonoPersona.setUsuario(null);

		return telefonoPersona;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<UsuarioPatio> getUsuarioPatios1() {
		return this.usuarioPatios1;
	}

	public void setUsuarioPatios1(List<UsuarioPatio> usuarioPatios1) {
		this.usuarioPatios1 = usuarioPatios1;
	}

	public UsuarioPatio addUsuarioPatios1(UsuarioPatio usuarioPatios1) {
		getUsuarioPatios1().add(usuarioPatios1);
		usuarioPatios1.setUsuario1(this);

		return usuarioPatios1;
	}

	public UsuarioPatio removeUsuarioPatios1(UsuarioPatio usuarioPatios1) {
		getUsuarioPatios1().remove(usuarioPatios1);
		usuarioPatios1.setUsuario1(null);

		return usuarioPatios1;
	}

	public List<UsuarioPatio> getUsuarioPatios2() {
		return this.usuarioPatios2;
	}

	public void setUsuarioPatios2(List<UsuarioPatio> usuarioPatios2) {
		this.usuarioPatios2 = usuarioPatios2;
	}

	public UsuarioPatio addUsuarioPatios2(UsuarioPatio usuarioPatios2) {
		getUsuarioPatios2().add(usuarioPatios2);
		usuarioPatios2.setUsuario2(this);

		return usuarioPatios2;
	}

	public UsuarioPatio removeUsuarioPatios2(UsuarioPatio usuarioPatios2) {
		getUsuarioPatios2().remove(usuarioPatios2);
		usuarioPatios2.setUsuario2(null);

		return usuarioPatios2;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setUsuario(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setUsuario(null);

		return vehiculo;
	}

	public List<VolantePatio> getVolantePatios() {
		return this.volantePatios;
	}

	public void setVolantePatios(List<VolantePatio> volantePatios) {
		this.volantePatios = volantePatios;
	}

	public VolantePatio addVolantePatio(VolantePatio volantePatio) {
		getVolantePatios().add(volantePatio);
		volantePatio.setUsuario(this);

		return volantePatio;
	}

	public VolantePatio removeVolantePatio(VolantePatio volantePatio) {
		getVolantePatios().remove(volantePatio);
		volantePatio.setUsuario(null);

		return volantePatio;
	}

}