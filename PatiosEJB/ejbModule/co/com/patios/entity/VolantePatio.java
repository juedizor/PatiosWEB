package co.com.patios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the volante_patio database table.
 * 
 */
@Entity
@Table(name="volante_patio")
@NamedQuery(name="VolantePatio.findAll", query="SELECT v FROM VolantePatio v")
public class VolantePatio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_volante_patio")
	private Integer idVolantePatio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_volante")
	private Date fechaVolante;

	@Column(name="numero_volante")
	private Integer numeroVolante;

	//bi-directional many-to-one association to EntradaVehiculoPatio
	@ManyToOne
	@JoinColumn(name="id_entrada_vehiculo_patio")
	private EntradaVehiculoPatio entradaVehiculoPatio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to DetalleVolantePatio
	@OneToMany(mappedBy="volantePatio")
	private List<DetalleVolantePatio> detalleVolantePatios;

	public VolantePatio() {
	}

	public Integer getIdVolantePatio() {
		return this.idVolantePatio;
	}

	public void setIdVolantePatio(Integer idVolantePatio) {
		this.idVolantePatio = idVolantePatio;
	}

	public Date getFechaVolante() {
		return this.fechaVolante;
	}

	public void setFechaVolante(Date fechaVolante) {
		this.fechaVolante = fechaVolante;
	}

	public Integer getNumeroVolante() {
		return this.numeroVolante;
	}

	public void setNumeroVolante(Integer numeroVolante) {
		this.numeroVolante = numeroVolante;
	}

	public EntradaVehiculoPatio getEntradaVehiculoPatio() {
		return this.entradaVehiculoPatio;
	}

	public void setEntradaVehiculoPatio(EntradaVehiculoPatio entradaVehiculoPatio) {
		this.entradaVehiculoPatio = entradaVehiculoPatio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<DetalleVolantePatio> getDetalleVolantePatios() {
		return this.detalleVolantePatios;
	}

	public void setDetalleVolantePatios(List<DetalleVolantePatio> detalleVolantePatios) {
		this.detalleVolantePatios = detalleVolantePatios;
	}

	public DetalleVolantePatio addDetalleVolantePatio(DetalleVolantePatio detalleVolantePatio) {
		getDetalleVolantePatios().add(detalleVolantePatio);
		detalleVolantePatio.setVolantePatio(this);

		return detalleVolantePatio;
	}

	public DetalleVolantePatio removeDetalleVolantePatio(DetalleVolantePatio detalleVolantePatio) {
		getDetalleVolantePatios().remove(detalleVolantePatio);
		detalleVolantePatio.setVolantePatio(null);

		return detalleVolantePatio;
	}

}