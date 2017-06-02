package co.com.app.negocio.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class UsuarioPatioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idUsuarioPatio;
	private Date fechaFinal;
	private Date fechaInicio;
	private Timestamp fechaProceso;
	private PatioDTO patio;
	private UsuarioDTO usuario1;
	private UsuarioDTO usuario2;

	public UsuarioPatioDTO() {
	}

	public Integer getIdUsuarioPatio() {
		return this.idUsuarioPatio;
	}

	public void setIdUsuarioPatio(Integer idUsuarioPatio) {
		this.idUsuarioPatio = idUsuarioPatio;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Timestamp getFechaProceso() {
		return this.fechaProceso;
	}

	public void setFechaProceso(Timestamp fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public PatioDTO getPatio() {
		return this.patio;
	}

	public void setPatio(PatioDTO patio) {
		this.patio = patio;
	}

	public UsuarioDTO getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(UsuarioDTO usuario1) {
		this.usuario1 = usuario1;
	}

	public UsuarioDTO getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(UsuarioDTO usuario2) {
		this.usuario2 = usuario2;
	}

}