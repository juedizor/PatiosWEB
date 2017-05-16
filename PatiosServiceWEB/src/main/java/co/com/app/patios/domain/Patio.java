package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the patio database table.
 * 
 */
@Entity
@NamedQuery(name="Patio.findAll", query="SELECT p FROM Patio p")
public class Patio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_patio")
	private Integer idPatio;

	@Column(name="capacidad_patio")
	private Integer capacidadPatio;

	@Column(name="codigo_patio")
	private String codigoPatio;

	@Column(name="direccion_patio")
	private String direccionPatio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro_patio")
	private Date fechaRegistroPatio;

	@Column(name="nombre_patio")
	private String nombrePatio;

	@Column(name="telefono_patio")
	private String telefonoPatio;

	//bi-directional many-to-one association to EntradaVehiculoPatio
	@OneToMany(mappedBy="patio")
	private List<EntradaVehiculoPatio> entradaVehiculoPatios;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to UsuarioPatio
	@OneToMany(mappedBy="patio")
	private List<UsuarioPatio> usuarioPatios;

	//bi-directional many-to-one association to ValorPatio
	@OneToMany(mappedBy="patio")
	private List<ValorPatio> valorPatios;

	public Patio() {
	}

	public Integer getIdPatio() {
		return this.idPatio;
	}

	public void setIdPatio(Integer idPatio) {
		this.idPatio = idPatio;
	}

	public Integer getCapacidadPatio() {
		return this.capacidadPatio;
	}

	public void setCapacidadPatio(Integer capacidadPatio) {
		this.capacidadPatio = capacidadPatio;
	}

	public String getCodigoPatio() {
		return this.codigoPatio;
	}

	public void setCodigoPatio(String codigoPatio) {
		this.codigoPatio = codigoPatio;
	}

	public String getDireccionPatio() {
		return this.direccionPatio;
	}

	public void setDireccionPatio(String direccionPatio) {
		this.direccionPatio = direccionPatio;
	}

	public Date getFechaRegistroPatio() {
		return this.fechaRegistroPatio;
	}

	public void setFechaRegistroPatio(Date fechaRegistroPatio) {
		this.fechaRegistroPatio = fechaRegistroPatio;
	}

	public String getNombrePatio() {
		return this.nombrePatio;
	}

	public void setNombrePatio(String nombrePatio) {
		this.nombrePatio = nombrePatio;
	}

	public String getTelefonoPatio() {
		return this.telefonoPatio;
	}

	public void setTelefonoPatio(String telefonoPatio) {
		this.telefonoPatio = telefonoPatio;
	}

	public List<EntradaVehiculoPatio> getEntradaVehiculoPatios() {
		return this.entradaVehiculoPatios;
	}

	public void setEntradaVehiculoPatios(List<EntradaVehiculoPatio> entradaVehiculoPatios) {
		this.entradaVehiculoPatios = entradaVehiculoPatios;
	}

	public EntradaVehiculoPatio addEntradaVehiculoPatio(EntradaVehiculoPatio entradaVehiculoPatio) {
		getEntradaVehiculoPatios().add(entradaVehiculoPatio);
		entradaVehiculoPatio.setPatio(this);

		return entradaVehiculoPatio;
	}

	public EntradaVehiculoPatio removeEntradaVehiculoPatio(EntradaVehiculoPatio entradaVehiculoPatio) {
		getEntradaVehiculoPatios().remove(entradaVehiculoPatio);
		entradaVehiculoPatio.setPatio(null);

		return entradaVehiculoPatio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioPatio> getUsuarioPatios() {
		return this.usuarioPatios;
	}

	public void setUsuarioPatios(List<UsuarioPatio> usuarioPatios) {
		this.usuarioPatios = usuarioPatios;
	}

	public UsuarioPatio addUsuarioPatio(UsuarioPatio usuarioPatio) {
		getUsuarioPatios().add(usuarioPatio);
		usuarioPatio.setPatio(this);

		return usuarioPatio;
	}

	public UsuarioPatio removeUsuarioPatio(UsuarioPatio usuarioPatio) {
		getUsuarioPatios().remove(usuarioPatio);
		usuarioPatio.setPatio(null);

		return usuarioPatio;
	}

	public List<ValorPatio> getValorPatios() {
		return this.valorPatios;
	}

	public void setValorPatios(List<ValorPatio> valorPatios) {
		this.valorPatios = valorPatios;
	}

	public ValorPatio addValorPatio(ValorPatio valorPatio) {
		getValorPatios().add(valorPatio);
		valorPatio.setPatio(this);

		return valorPatio;
	}

	public ValorPatio removeValorPatio(ValorPatio valorPatio) {
		getValorPatios().remove(valorPatio);
		valorPatio.setPatio(null);

		return valorPatio;
	}

}