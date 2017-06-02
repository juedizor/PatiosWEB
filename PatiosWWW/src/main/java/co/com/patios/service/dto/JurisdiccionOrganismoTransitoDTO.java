package co.com.patios.service.dto;

import java.io.Serializable;
import java.util.List;


public class JurisdiccionOrganismoTransitoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idJurisdiccionOrganismoTransito;
	private String jurisdiccionOrganismoTransito;
	private List<OrganismoTransitoDTO> organismoTransitos;

	public JurisdiccionOrganismoTransitoDTO() {
	}

	public Integer getIdJurisdiccionOrganismoTransito() {
		return this.idJurisdiccionOrganismoTransito;
	}

	public void setIdJurisdiccionOrganismoTransito(Integer idJurisdiccionOrganismoTransito) {
		this.idJurisdiccionOrganismoTransito = idJurisdiccionOrganismoTransito;
	}

	public String getJurisdiccionOrganismoTransito() {
		return this.jurisdiccionOrganismoTransito;
	}

	public void setJurisdiccionOrganismoTransito(String jurisdiccionOrganismoTransito) {
		this.jurisdiccionOrganismoTransito = jurisdiccionOrganismoTransito;
	}

	public List<OrganismoTransitoDTO> getOrganismoTransitos() {
		return this.organismoTransitos;
	}

	public void setOrganismoTransitos(List<OrganismoTransitoDTO> organismoTransitos) {
		this.organismoTransitos = organismoTransitos;
	}

}