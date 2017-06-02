package co.com.app.negocio.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ConsecutivoVolanteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idConsecutivoVolante;
	private Timestamp fechaConsecutivoVolante;
	private Integer numeroVolante;
	private UsuarioDTO usuario;

	public ConsecutivoVolanteDTO() {
	}

	public Integer getIdConsecutivoVolante() {
		return this.idConsecutivoVolante;
	}

	public void setIdConsecutivoVolante(Integer idConsecutivoVolante) {
		this.idConsecutivoVolante = idConsecutivoVolante;
	}

	public Timestamp getFechaConsecutivoVolante() {
		return this.fechaConsecutivoVolante;
	}

	public void setFechaConsecutivoVolante(Timestamp fechaConsecutivoVolante) {
		this.fechaConsecutivoVolante = fechaConsecutivoVolante;
	}

	public Integer getNumeroVolante() {
		return this.numeroVolante;
	}

	public void setNumeroVolante(Integer numeroVolante) {
		this.numeroVolante = numeroVolante;
	}

	public UsuarioDTO getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

}