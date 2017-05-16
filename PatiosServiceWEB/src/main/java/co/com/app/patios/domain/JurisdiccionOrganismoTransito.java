package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jurisdiccion_organismo_transito database table.
 * 
 */
@Entity
@Table(name="jurisdiccion_organismo_transito")
@NamedQuery(name="JurisdiccionOrganismoTransito.findAll", query="SELECT j FROM JurisdiccionOrganismoTransito j")
public class JurisdiccionOrganismoTransito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_jurisdiccion_organismo_transito")
	private Integer idJurisdiccionOrganismoTransito;

	@Column(name="jurisdiccion_organismo_transito")
	private String jurisdiccionOrganismoTransito;

	//bi-directional many-to-one association to OrganismoTransito
	@OneToMany(mappedBy="jurisdiccionOrganismoTransito")
	private List<OrganismoTransito> organismoTransitos;

	public JurisdiccionOrganismoTransito() {
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

	public List<OrganismoTransito> getOrganismoTransitos() {
		return this.organismoTransitos;
	}

	public void setOrganismoTransitos(List<OrganismoTransito> organismoTransitos) {
		this.organismoTransitos = organismoTransitos;
	}

	public OrganismoTransito addOrganismoTransito(OrganismoTransito organismoTransito) {
		getOrganismoTransitos().add(organismoTransito);
		organismoTransito.setJurisdiccionOrganismoTransito(this);

		return organismoTransito;
	}

	public OrganismoTransito removeOrganismoTransito(OrganismoTransito organismoTransito) {
		getOrganismoTransitos().remove(organismoTransito);
		organismoTransito.setJurisdiccionOrganismoTransito(null);

		return organismoTransito;
	}

}