package co.com.patios.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class TelefonoPersonaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idTelefonoPersona;
	private Timestamp fechaProceso;
	private String numeroTelefonoPersona;
	private PersonaDTO persona;

	public TelefonoPersonaDTO() {
	}

	public Integer getIdTelefonoPersona() {
		return this.idTelefonoPersona;
	}

	public void setIdTelefonoPersona(Integer idTelefonoPersona) {
		this.idTelefonoPersona = idTelefonoPersona;
	}

	public Timestamp getFechaProceso() {
		return this.fechaProceso;
	}

	public void setFechaProceso(Timestamp fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public String getNumeroTelefonoPersona() {
		return this.numeroTelefonoPersona;
	}

	public void setNumeroTelefonoPersona(String numeroTelefonoPersona) {
		this.numeroTelefonoPersona = numeroTelefonoPersona;
	}

	public PersonaDTO getPersona() {
		return this.persona;
	}

	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}

}