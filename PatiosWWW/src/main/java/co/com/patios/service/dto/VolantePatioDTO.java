package co.com.patios.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class VolantePatioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idVolantePatio;
	private Timestamp fechaVolante;
	private Integer numeroVolante;
	private List<DetalleVolantePatioDTO> detalleVolantePatios;
	private EntradaVehiculoPatioDTO entradaVehiculoPatio;
	private UsuarioDTO usuario;

	public VolantePatioDTO() {
	}

	public Integer getIdVolantePatio() {
		return this.idVolantePatio;
	}

	public void setIdVolantePatio(Integer idVolantePatio) {
		this.idVolantePatio = idVolantePatio;
	}

	public Timestamp getFechaVolante() {
		return this.fechaVolante;
	}

	public void setFechaVolante(Timestamp fechaVolante) {
		this.fechaVolante = fechaVolante;
	}

	public Integer getNumeroVolante() {
		return this.numeroVolante;
	}

	public void setNumeroVolante(Integer numeroVolante) {
		this.numeroVolante = numeroVolante;
	}

	public List<DetalleVolantePatioDTO> getDetalleVolantePatios() {
		return this.detalleVolantePatios;
	}

	public void setDetalleVolantePatios(List<DetalleVolantePatioDTO> detalleVolantePatios) {
		this.detalleVolantePatios = detalleVolantePatios;
	}

	public EntradaVehiculoPatioDTO getEntradaVehiculoPatio() {
		return this.entradaVehiculoPatio;
	}

	public void setEntradaVehiculoPatio(EntradaVehiculoPatioDTO entradaVehiculoPatio) {
		this.entradaVehiculoPatio = entradaVehiculoPatio;
	}

	public UsuarioDTO getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

}