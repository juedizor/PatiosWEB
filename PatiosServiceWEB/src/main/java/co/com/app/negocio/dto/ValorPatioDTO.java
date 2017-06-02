package co.com.app.negocio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ValorPatioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idValorPatio;
	private Date fechaDesde;
	private Date fechaHasta;
	private BigDecimal valorTarifa;
	private ClaseVehiculoDTO claseVehiculo;
	private PatioDTO patio;

	public ValorPatioDTO() {
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

	public ClaseVehiculoDTO getClaseVehiculo() {
		return this.claseVehiculo;
	}

	public void setClaseVehiculo(ClaseVehiculoDTO claseVehiculo) {
		this.claseVehiculo = claseVehiculo;
	}

	public PatioDTO getPatio() {
		return this.patio;
	}

	public void setPatio(PatioDTO patio) {
		this.patio = patio;
	}

}