package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the color_vehiculo database table.
 * 
 */
@Entity
@Table(name="color_vehiculo")
@NamedQuery(name="ColorVehiculo.findAll", query="SELECT c FROM ColorVehiculo c")
public class ColorVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_color_vehiculo")
	private Integer idColorVehiculo;

	@Column(name="codigo_color_vehiculo")
	private Integer codigoColorVehiculo;

	@Column(name="descripcion_color_vehiculo")
	private String descripcionColorVehiculo;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="colorVehiculo")
	private List<Vehiculo> vehiculos;

	public ColorVehiculo() {
	}

	public Integer getIdColorVehiculo() {
		return this.idColorVehiculo;
	}

	public void setIdColorVehiculo(Integer idColorVehiculo) {
		this.idColorVehiculo = idColorVehiculo;
	}

	public Integer getCodigoColorVehiculo() {
		return this.codigoColorVehiculo;
	}

	public void setCodigoColorVehiculo(Integer codigoColorVehiculo) {
		this.codigoColorVehiculo = codigoColorVehiculo;
	}

	public String getDescripcionColorVehiculo() {
		return this.descripcionColorVehiculo;
	}

	public void setDescripcionColorVehiculo(String descripcionColorVehiculo) {
		this.descripcionColorVehiculo = descripcionColorVehiculo;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setColorVehiculo(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setColorVehiculo(null);

		return vehiculo;
	}

}