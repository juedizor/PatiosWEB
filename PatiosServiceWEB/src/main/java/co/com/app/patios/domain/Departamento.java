package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_departamento")
	private Integer idDepartamento;

	@Column(name="codigo_departamento")
	private Integer codigoDepartamento;

	@Column(name="nombre_departamento")
	private String nombreDepartamento;

	//bi-directional many-to-one association to Ciudad
	@OneToMany(mappedBy="departamento")
	private List<Ciudad> ciudads;

	//bi-directional many-to-one association to Pai
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Pai pai;

	public Departamento() {
	}

	public Integer getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Integer getCodigoDepartamento() {
		return this.codigoDepartamento;
	}

	public void setCodigoDepartamento(Integer codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getNombreDepartamento() {
		return this.nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public List<Ciudad> getCiudads() {
		return this.ciudads;
	}

	public void setCiudads(List<Ciudad> ciudads) {
		this.ciudads = ciudads;
	}

	public Ciudad addCiudad(Ciudad ciudad) {
		getCiudads().add(ciudad);
		ciudad.setDepartamento(this);

		return ciudad;
	}

	public Ciudad removeCiudad(Ciudad ciudad) {
		getCiudads().remove(ciudad);
		ciudad.setDepartamento(null);

		return ciudad;
	}

	public Pai getPai() {
		return this.pai;
	}

	public void setPai(Pai pai) {
		this.pai = pai;
	}

}