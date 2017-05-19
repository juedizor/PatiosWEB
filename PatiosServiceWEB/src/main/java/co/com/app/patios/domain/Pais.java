package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name="pais")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pais")
	private Integer idPais;

	@Column(name="codigo_pais")
	private Integer codigoPais;

	@Column(name="descripcion_pais")
	private String descripcionPais;

	//bi-directional many-to-one association to Departamento
	@OneToMany(mappedBy="pais", fetch = FetchType.EAGER)
	private List<Departamento> departamentos;

	public Pais() {
	}

	public Integer getIdPais() {
		return this.idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public Integer getCodigoPais() {
		return this.codigoPais;
	}

	public void setCodigoPais(Integer codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getDescripcionPais() {
		return this.descripcionPais;
	}

	public void setDescripcionPais(String descripcionPais) {
		this.descripcionPais = descripcionPais;
	}

	public List<Departamento> getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public Departamento addDepartamento(Departamento departamento) {
		getDepartamentos().add(departamento);
		departamento.setPais(this);

		return departamento;
	}

	public Departamento removeDepartamento(Departamento departamento) {
		getDepartamentos().remove(departamento);
		departamento.setPais(null);

		return departamento;
	}

}