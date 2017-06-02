package co.com.app.negocio.dto;

import java.io.Serializable;
import java.math.BigDecimal;


public class DetalleVolantePatioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idDetalleVolantePatio;
	private String anioLiquidacion;
	private Integer diasLiquidacion;
	private BigDecimal valorLiquidacion;
	private BigDecimal valorLiquidacionAnio;
	private UsuarioDTO usuario;
	private VolantePatioDTO volantePatio;

	public DetalleVolantePatioDTO() {
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

	public UsuarioDTO getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public VolantePatioDTO getVolantePatio() {
		return this.volantePatio;
	}

	public void setVolantePatio(VolantePatioDTO volantePatio) {
		this.volantePatio = volantePatio;
	}

}