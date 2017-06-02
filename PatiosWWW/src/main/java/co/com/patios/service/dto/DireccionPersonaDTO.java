package co.com.patios.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class DireccionPersonaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idDireccionPersona;
	private String descripcionDireccion;
	private Date fechaFinalDireccion;
	private Date fechaInicioDireccion;
	private Timestamp fechaProceso;
	private PersonaDTO persona;

	public DireccionPersonaDTO() {
	}

	public Integer getIdDireccionPersona() {
		return this.idDireccionPersona;
	}

	public void setIdDireccionPersona(Integer idDireccionPersona) {
		this.idDireccionPersona = idDireccionPersona;
	}

	public String getDescripcionDireccion() {
		return this.descripcionDireccion;
	}

	public void setDescripcionDireccion(String descripcionDireccion) {
		this.descripcionDireccion = descripcionDireccion;
	}

	public Date getFechaFinalDireccion() {
		return this.fechaFinalDireccion;
	}

	public void setFechaFinalDireccion(Date fechaFinalDireccion) {
		this.fechaFinalDireccion = fechaFinalDireccion;
	}

	public Date getFechaInicioDireccion() {
		return this.fechaInicioDireccion;
	}

	public void setFechaInicioDireccion(Date fechaInicioDireccion) {
		this.fechaInicioDireccion = fechaInicioDireccion;
	}

	public Timestamp getFechaProceso() {
		return this.fechaProceso;
	}

	public void setFechaProceso(Timestamp fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public PersonaDTO getPersona() {
		return this.persona;
	}

	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}

}