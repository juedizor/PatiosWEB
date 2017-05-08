package co.com.patios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_vehiculo database table.
 * 
 */
@Entity
@Table(name="estado_vehiculo")
@NamedQuery(name="EstadoVehiculo.findAll", query="SELECT e FROM EstadoVehiculo e")
public class EstadoVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_vehiculo")
	private Integer idEstadoVehiculo;

	@Column(name="codigo_alfa_estado_vehiculo")
	private String codigoAlfaEstadoVehiculo;

	@Column(name="descripcion_estado_vehiculo")
	private String descripcionEstadoVehiculo;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="estadoVehiculo")
	private List<Vehiculo> vehiculos;

	public EstadoVehiculo() {
	}

	public Integer getIdEstadoVehiculo() {
		return this.idEstadoVehiculo;
	}

	public void setIdEstadoVehiculo(Integer idEstadoVehiculo) {
		this.idEstadoVehiculo = idEstadoVehiculo;
	}

	public String getCodigoAlfaEstadoVehiculo() {
		return this.codigoAlfaEstadoVehiculo;
	}

	public void setCodigoAlfaEstadoVehiculo(String codigoAlfaEstadoVehiculo) {
		this.codigoAlfaEstadoVehiculo = codigoAlfaEstadoVehiculo;
	}

	public String getDescripcionEstadoVehiculo() {
		return this.descripcionEstadoVehiculo;
	}

	public void setDescripcionEstadoVehiculo(String descripcionEstadoVehiculo) {
		this.descripcionEstadoVehiculo = descripcionEstadoVehiculo;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setEstadoVehiculo(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setEstadoVehiculo(null);

		return vehiculo;
	}

}