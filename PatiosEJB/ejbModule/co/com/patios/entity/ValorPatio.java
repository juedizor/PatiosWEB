package co.com.patios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the valor_patio database table.
 * 
 */
@Entity
@Table(name="valor_patio")
@NamedQuery(name="ValorPatio.findAll", query="SELECT v FROM ValorPatio v")
public class ValorPatio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_valor_patio")
	private Integer idValorPatio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_desde")
	private Date fechaDesde;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_hasta")
	private Date fechaHasta;

	@Column(name="valor_tarifa")
	private BigDecimal valorTarifa;

	//bi-directional many-to-one association to ClaseVehiculo
	@ManyToOne
	@JoinColumn(name="id_clase_vehiculo")
	private ClaseVehiculo claseVehiculo;

	//bi-directional many-to-one association to Patio
	@ManyToOne
	@JoinColumn(name="id_patio")
	private Patio patio;

	public ValorPatio() {
	}

	public Integer getIdValorPatio() {
		return this.idValorPatio;
	}

	public void setIdValorPatio(Integer idValorPatio) {
		this.idValorPatio = idValorPatio;
	}

	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public BigDecimal getValorTarifa() {
		return this.valorTarifa;
	}

	public void setValorTarifa(BigDecimal valorTarifa) {
		this.valorTarifa = valorTarifa;
	}

	public ClaseVehiculo getClaseVehiculo() {
		return this.claseVehiculo;
	}

	public void setClaseVehiculo(ClaseVehiculo claseVehiculo) {
		this.claseVehiculo = claseVehiculo;
	}

	public Patio getPatio() {
		return this.patio;
	}

	public void setPatio(Patio patio) {
		this.patio = patio;
	}

}