package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the entrada_vehiculo_patio database table.
 * 
 */
@Entity
@Table(name="entrada_vehiculo_patio")
@NamedQuery(name="EntradaVehiculoPatio.findAll", query="SELECT e FROM EntradaVehiculoPatio e")
public class EntradaVehiculoPatio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_entrada_vehiculo_patio")
	private Integer idEntradaVehiculoPatio;

	@Column(name="estado_entrada_vehiculo")
	private String estadoEntradaVehiculo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_entrada_vehiculo")
	private Date fechaEntradaVehiculo;

	//bi-directional many-to-one association to Patio
	@ManyToOne
	@JoinColumn(name="id_patio")
	private Patio patio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="id_vehiculo")
	private Vehiculo vehiculo;

	//bi-directional many-to-one association to VolantePatio
	@OneToMany(mappedBy="entradaVehiculoPatio")
	private List<VolantePatio> volantePatios;

	public EntradaVehiculoPatio() {
	}

	public Integer getIdEntradaVehiculoPatio() {
		return this.idEntradaVehiculoPatio;
	}

	public void setIdEntradaVehiculoPatio(Integer idEntradaVehiculoPatio) {
		this.idEntradaVehiculoPatio = idEntradaVehiculoPatio;
	}

	public String getEstadoEntradaVehiculo() {
		return this.estadoEntradaVehiculo;
	}

	public void setEstadoEntradaVehiculo(String estadoEntradaVehiculo) {
		this.estadoEntradaVehiculo = estadoEntradaVehiculo;
	}

	public Date getFechaEntradaVehiculo() {
		return this.fechaEntradaVehiculo;
	}

	public void setFechaEntradaVehiculo(Date fechaEntradaVehiculo) {
		this.fechaEntradaVehiculo = fechaEntradaVehiculo;
	}

	public Patio getPatio() {
		return this.patio;
	}

	public void setPatio(Patio patio) {
		this.patio = patio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<VolantePatio> getVolantePatios() {
		return this.volantePatios;
	}

	public void setVolantePatios(List<VolantePatio> volantePatios) {
		this.volantePatios = volantePatios;
	}

	public VolantePatio addVolantePatio(VolantePatio volantePatio) {
		getVolantePatios().add(volantePatio);
		volantePatio.setEntradaVehiculoPatio(this);

		return volantePatio;
	}

	public VolantePatio removeVolantePatio(VolantePatio volantePatio) {
		getVolantePatios().remove(volantePatio);
		volantePatio.setEntradaVehiculoPatio(null);

		return volantePatio;
	}

}