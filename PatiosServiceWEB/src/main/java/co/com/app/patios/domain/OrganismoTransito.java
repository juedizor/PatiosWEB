package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the organismo_transito database table.
 * 
 */
@Entity
@Table(name="organismo_transito")
@NamedQuery(name="OrganismoTransito.findAll", query="SELECT o FROM OrganismoTransito o")
public class OrganismoTransito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_organismo_transito")
	private Integer idOrganismoTransito;

	@Column(name="codigo_division_politica")
	private Long codigoDivisionPolitica;

	@Column(name="estado_organismo_transito")
	private String estadoOrganismoTransito;

	@Column(name="fecha_proceso")
	private Timestamp fechaProceso;

	@Column(name="nombre_abreviado")
	private String nombreAbreviado;

	@Column(name="nombre_organismo_transito")
	private String nombreOrganismoTransito;

	//bi-directional many-to-one association to CategoriaOrganismoTransito
	@ManyToOne
	@JoinColumn(name="id_categoria_organismo_transito")
	private CategoriaOrganismoTransito categoriaOrganismoTransito;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="id_ciudad")
	private Ciudad ciudad;

	//bi-directional many-to-one association to JurisdiccionOrganismoTransito
	@ManyToOne
	@JoinColumn(name="id_jurisdiccion_organismo_transito")
	private JurisdiccionOrganismoTransito jurisdiccionOrganismoTransito;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="organismoTransito")
	private List<Vehiculo> vehiculos;

	public OrganismoTransito() {
	}

	public Integer getIdOrganismoTransito() {
		return this.idOrganismoTransito;
	}

	public void setIdOrganismoTransito(Integer idOrganismoTransito) {
		this.idOrganismoTransito = idOrganismoTransito;
	}

	public Long getCodigoDivisionPolitica() {
		return this.codigoDivisionPolitica;
	}

	public void setCodigoDivisionPolitica(Long codigoDivisionPolitica) {
		this.codigoDivisionPolitica = codigoDivisionPolitica;
	}

	public String getEstadoOrganismoTransito() {
		return this.estadoOrganismoTransito;
	}

	public void setEstadoOrganismoTransito(String estadoOrganismoTransito) {
		this.estadoOrganismoTransito = estadoOrganismoTransito;
	}

	public Timestamp getFechaProceso() {
		return this.fechaProceso;
	}

	public void setFechaProceso(Timestamp fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public String getNombreAbreviado() {
		return this.nombreAbreviado;
	}

	public void setNombreAbreviado(String nombreAbreviado) {
		this.nombreAbreviado = nombreAbreviado;
	}

	public String getNombreOrganismoTransito() {
		return this.nombreOrganismoTransito;
	}

	public void setNombreOrganismoTransito(String nombreOrganismoTransito) {
		this.nombreOrganismoTransito = nombreOrganismoTransito;
	}

	public CategoriaOrganismoTransito getCategoriaOrganismoTransito() {
		return this.categoriaOrganismoTransito;
	}

	public void setCategoriaOrganismoTransito(CategoriaOrganismoTransito categoriaOrganismoTransito) {
		this.categoriaOrganismoTransito = categoriaOrganismoTransito;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public JurisdiccionOrganismoTransito getJurisdiccionOrganismoTransito() {
		return this.jurisdiccionOrganismoTransito;
	}

	public void setJurisdiccionOrganismoTransito(JurisdiccionOrganismoTransito jurisdiccionOrganismoTransito) {
		this.jurisdiccionOrganismoTransito = jurisdiccionOrganismoTransito;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setOrganismoTransito(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setOrganismoTransito(null);

		return vehiculo;
	}

}