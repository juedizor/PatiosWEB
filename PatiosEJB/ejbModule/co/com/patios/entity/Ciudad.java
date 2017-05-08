package co.com.patios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ciudad database table.
 * 
 */
@Entity
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ciudad")
	private Integer idCiudad;

	@Column(name="codigo_div_politica")
	private Long codigoDivPolitica;

	@Column(name="nombre_ciudad")
	private String nombreCiudad;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="id_departamento")
	private Departamento departamento;

	//bi-directional many-to-one association to OrganismoTransito
	@OneToMany(mappedBy="ciudad")
	private List<OrganismoTransito> organismoTransitos;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="ciudad")
	private List<Persona> personas;

	public Ciudad() {
	}

	public Integer getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public Long getCodigoDivPolitica() {
		return this.codigoDivPolitica;
	}

	public void setCodigoDivPolitica(Long codigoDivPolitica) {
		this.codigoDivPolitica = codigoDivPolitica;
	}

	public String getNombreCiudad() {
		return this.nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<OrganismoTransito> getOrganismoTransitos() {
		return this.organismoTransitos;
	}

	public void setOrganismoTransitos(List<OrganismoTransito> organismoTransitos) {
		this.organismoTransitos = organismoTransitos;
	}

	public OrganismoTransito addOrganismoTransito(OrganismoTransito organismoTransito) {
		getOrganismoTransitos().add(organismoTransito);
		organismoTransito.setCiudad(this);

		return organismoTransito;
	}

	public OrganismoTransito removeOrganismoTransito(OrganismoTransito organismoTransito) {
		getOrganismoTransitos().remove(organismoTransito);
		organismoTransito.setCiudad(null);

		return organismoTransito;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setCiudad(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setCiudad(null);

		return persona;
	}

}