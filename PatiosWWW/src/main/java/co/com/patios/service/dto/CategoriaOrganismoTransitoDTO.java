package co.com.patios.service.dto;

import java.io.Serializable;
import java.util.List;

public class CategoriaOrganismoTransitoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idCategoriaOrganismoTransito;
	private String categoriaOrganismo;
	private List<OrganismoTransitoDTO> organismoTransitos;

	public CategoriaOrganismoTransitoDTO() {
	}

	public Integer getIdCategoriaOrganismoTransito() {
		return this.idCategoriaOrganismoTransito;
	}

	public void setIdCategoriaOrganismoTransito(Integer idCategoriaOrganismoTransito) {
		this.idCategoriaOrganismoTransito = idCategoriaOrganismoTransito;
	}

	public String getCategoriaOrganismo() {
		return this.categoriaOrganismo;
	}

	public void setCategoriaOrganismo(String categoriaOrganismo) {
		this.categoriaOrganismo = categoriaOrganismo;
	}

	public List<OrganismoTransitoDTO> getOrganismoTransitos() {
		return this.organismoTransitos;
	}

	public void setOrganismoTransitos(List<OrganismoTransitoDTO> organismoTransitos) {
		this.organismoTransitos = organismoTransitos;
	}

}