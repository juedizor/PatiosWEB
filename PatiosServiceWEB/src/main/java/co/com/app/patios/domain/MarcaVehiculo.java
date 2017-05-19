package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marca_vehiculo database table.
 * 
 */
@Entity
@Table(name="marca_vehiculo")
@NamedQuery(name="MarcaVehiculo.findAll", query="SELECT m FROM MarcaVehiculo m")
public class MarcaVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_marca_vehiculo")
	private Integer idMarcaVehiculo;

	@Column(name="codigo_marca_vehiculo")
	private Long codigoMarcaVehiculo;

	@Column(name="descripcion_marca_vehiculo")
	private String descripcionMarcaVehiculo;

	//bi-directional many-to-one association to ModeloVehiculo
	@OneToMany(mappedBy="marcaVehiculo", fetch = FetchType.EAGER)
	private List<ModeloVehiculo> modeloVehiculos;

	public MarcaVehiculo() {
	}

	public Integer getIdMarcaVehiculo() {
		return this.idMarcaVehiculo;
	}

	public void setIdMarcaVehiculo(Integer idMarcaVehiculo) {
		this.idMarcaVehiculo = idMarcaVehiculo;
	}

	public Long getCodigoMarcaVehiculo() {
		return this.codigoMarcaVehiculo;
	}

	public void setCodigoMarcaVehiculo(Long codigoMarcaVehiculo) {
		this.codigoMarcaVehiculo = codigoMarcaVehiculo;
	}

	public String getDescripcionMarcaVehiculo() {
		return this.descripcionMarcaVehiculo;
	}

	public void setDescripcionMarcaVehiculo(String descripcionMarcaVehiculo) {
		this.descripcionMarcaVehiculo = descripcionMarcaVehiculo;
	}

	public List<ModeloVehiculo> getModeloVehiculos() {
		return this.modeloVehiculos;
	}

	public void setModeloVehiculos(List<ModeloVehiculo> modeloVehiculos) {
		this.modeloVehiculos = modeloVehiculos;
	}

	public ModeloVehiculo addModeloVehiculo(ModeloVehiculo modeloVehiculo) {
		getModeloVehiculos().add(modeloVehiculo);
		modeloVehiculo.setMarcaVehiculo(this);

		return modeloVehiculo;
	}

	public ModeloVehiculo removeModeloVehiculo(ModeloVehiculo modeloVehiculo) {
		getModeloVehiculos().remove(modeloVehiculo);
		modeloVehiculo.setMarcaVehiculo(null);

		return modeloVehiculo;
	}

}