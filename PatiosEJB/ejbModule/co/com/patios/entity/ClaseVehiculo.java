package co.com.patios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clase_vehiculo database table.
 * 
 */
@Entity
@Table(name="clase_vehiculo")
@NamedQuery(name="ClaseVehiculo.findAll", query="SELECT c FROM ClaseVehiculo c")
public class ClaseVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clase_vehiculo")
	private Integer idClaseVehiculo;

	@Column(name="codigo_clase_vehiculo")
	private Integer codigoClaseVehiculo;

	@Column(name="descripcion_clase_vehiculo")
	private String descripcionClaseVehiculo;

	//bi-directional many-to-one association to ValorPatio
	@OneToMany(mappedBy="claseVehiculo")
	private List<ValorPatio> valorPatios;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="claseVehiculo")
	private List<Vehiculo> vehiculos;

	public ClaseVehiculo() {
	}

	public Integer getIdClaseVehiculo() {
		return this.idClaseVehiculo;
	}

	public void setIdClaseVehiculo(Integer idClaseVehiculo) {
		this.idClaseVehiculo = idClaseVehiculo;
	}

	public Integer getCodigoClaseVehiculo() {
		return this.codigoClaseVehiculo;
	}

	public void setCodigoClaseVehiculo(Integer codigoClaseVehiculo) {
		this.codigoClaseVehiculo = codigoClaseVehiculo;
	}

	public String getDescripcionClaseVehiculo() {
		return this.descripcionClaseVehiculo;
	}

	public void setDescripcionClaseVehiculo(String descripcionClaseVehiculo) {
		this.descripcionClaseVehiculo = descripcionClaseVehiculo;
	}

	public List<ValorPatio> getValorPatios() {
		return this.valorPatios;
	}

	public void setValorPatios(List<ValorPatio> valorPatios) {
		this.valorPatios = valorPatios;
	}

	public ValorPatio addValorPatio(ValorPatio valorPatio) {
		getValorPatios().add(valorPatio);
		valorPatio.setClaseVehiculo(this);

		return valorPatio;
	}

	public ValorPatio removeValorPatio(ValorPatio valorPatio) {
		getValorPatios().remove(valorPatio);
		valorPatio.setClaseVehiculo(null);

		return valorPatio;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setClaseVehiculo(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setClaseVehiculo(null);

		return vehiculo;
	}

}