package co.com.patios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detalle_volante_patio database table.
 * 
 */
@Entity
@Table(name="detalle_volante_patio")
@NamedQuery(name="DetalleVolantePatio.findAll", query="SELECT d FROM DetalleVolantePatio d")
public class DetalleVolantePatio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle_volante_patio")
	private Integer idDetalleVolantePatio;

	@Column(name="anio_liquidacion")
	private String anioLiquidacion;

	@Column(name="dias_liquidacion")
	private Integer diasLiquidacion;

	@Column(name="valor_liquidacion")
	private BigDecimal valorLiquidacion;

	@Column(name="valor_liquidacion_anio")
	private BigDecimal valorLiquidacionAnio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to VolantePatio
	@ManyToOne
	@JoinColumn(name="id_volante_patio")
	private VolantePatio volantePatio;

	public DetalleVolantePatio() {
	}

	public Integer getIdDetalleVolantePatio() {
		return this.idDetalleVolantePatio;
	}

	public void setIdDetalleVolantePatio(Integer idDetalleVolantePatio) {
		this.idDetalleVolantePatio = idDetalleVolantePatio;
	}

	public String getAnioLiquidacion() {
		return this.anioLiquidacion;
	}

	public void setAnioLiquidacion(String anioLiquidacion) {
		this.anioLiquidacion = anioLiquidacion;
	}

	public Integer getDiasLiquidacion() {
		return this.diasLiquidacion;
	}

	public void setDiasLiquidacion(Integer diasLiquidacion) {
		this.diasLiquidacion = diasLiquidacion;
	}

	public BigDecimal getValorLiquidacion() {
		return this.valorLiquidacion;
	}

	public void setValorLiquidacion(BigDecimal valorLiquidacion) {
		this.valorLiquidacion = valorLiquidacion;
	}

	public BigDecimal getValorLiquidacionAnio() {
		return this.valorLiquidacionAnio;
	}

	public void setValorLiquidacionAnio(BigDecimal valorLiquidacionAnio) {
		this.valorLiquidacionAnio = valorLiquidacionAnio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public VolantePatio getVolantePatio() {
		return this.volantePatio;
	}

	public void setVolantePatio(VolantePatio volantePatio) {
		this.volantePatio = volantePatio;
	}

}