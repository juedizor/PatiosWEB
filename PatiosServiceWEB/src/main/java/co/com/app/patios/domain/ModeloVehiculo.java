package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modelo_vehiculo database table.
 * 
 */
@Entity
@Table(name="modelo_vehiculo")
@NamedQuery(name="ModeloVehiculo.findAll", query="SELECT m FROM ModeloVehiculo m")
public class ModeloVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_modelo_vehiculo")
	private Integer idModeloVehiculo;

	@Column(name="anio_modelo_vehiculo")
	private Long anioModeloVehiculo;

	@Column(name="modelo_vehiculo")
	private String modeloVehiculo;

	//bi-directional many-to-one association to MarcaVehiculo
	@ManyToOne
	@JoinColumn(name="id_marca_vehiculo")
	private MarcaVehiculo marcaVehiculo;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="modeloVehiculo")
	private List<Vehiculo> vehiculos;

	public ModeloVehiculo() {
	}

	public Integer getIdModeloVehiculo() {
		return this.idModeloVehiculo;
	}

	public void setIdModeloVehiculo(Integer idModeloVehiculo) {
		this.idModeloVehiculo = idModeloVehiculo;
	}

	public Long getAnioModeloVehiculo() {
		return this.anioModeloVehiculo;
	}

	public void setAnioModeloVehiculo(Long anioModeloVehiculo) {
		this.anioModeloVehiculo = anioModeloVehiculo;
	}

	public String getModeloVehiculo() {
		return this.modeloVehiculo;
	}

	public void setModeloVehiculo(String modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}

	public MarcaVehiculo getMarcaVehiculo() {
		return this.marcaVehiculo;
	}

	public void setMarcaVehiculo(MarcaVehiculo marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setModeloVehiculo(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setModeloVehiculo(null);

		return vehiculo;
	}

}