package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria_organismo_transito database table.
 * 
 */
@Entity
@Table(name="categoria_organismo_transito")
@NamedQuery(name="CategoriaOrganismoTransito.findAll", query="SELECT c FROM CategoriaOrganismoTransito c")
public class CategoriaOrganismoTransito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categoria_organismo_transito")
	private Integer idCategoriaOrganismoTransito;

	@Column(name="categoria_organismo")
	private String categoriaOrganismo;

	//bi-directional many-to-one association to OrganismoTransito
	@OneToMany(mappedBy="categoriaOrganismoTransito")
	private List<OrganismoTransito> organismoTransitos;

	public CategoriaOrganismoTransito() {
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

	public List<OrganismoTransito> getOrganismoTransitos() {
		return this.organismoTransitos;
	}

	public void setOrganismoTransitos(List<OrganismoTransito> organismoTransitos) {
		this.organismoTransitos = organismoTransitos;
	}

	public OrganismoTransito addOrganismoTransito(OrganismoTransito organismoTransito) {
		getOrganismoTransitos().add(organismoTransito);
		organismoTransito.setCategoriaOrganismoTransito(this);

		return organismoTransito;
	}

	public OrganismoTransito removeOrganismoTransito(OrganismoTransito organismoTransito) {
		getOrganismoTransitos().remove(organismoTransito);
		organismoTransito.setCategoriaOrganismoTransito(null);

		return organismoTransito;
	}

}