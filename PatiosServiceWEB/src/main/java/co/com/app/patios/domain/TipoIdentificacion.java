package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_identificacion database table.
 * 
 */
@Entity
@Table(name="tipo_identificacion")
@NamedQuery(name="TipoIdentificacion.findAll", query="SELECT t FROM TipoIdentificacion t")
public class TipoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_identificacion")
	private Integer idTipoIdentificacion;

	@Column(name="codigo_tipo_identificacion")
	private String codigoTipoIdentificacion;

	@Column(name="descripcion_tipo_identificacion")
	private String descripcionTipoIdentificacion;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="tipoIdentificacion")
	private List<Persona> personas;

	public TipoIdentificacion() {
	}

	public Integer getIdTipoIdentificacion() {
		return this.idTipoIdentificacion;
	}

	public void setIdTipoIdentificacion(Integer idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public String getCodigoTipoIdentificacion() {
		return this.codigoTipoIdentificacion;
	}

	public void setCodigoTipoIdentificacion(String codigoTipoIdentificacion) {
		this.codigoTipoIdentificacion = codigoTipoIdentificacion;
	}

	public String getDescripcionTipoIdentificacion() {
		return this.descripcionTipoIdentificacion;
	}

	public void setDescripcionTipoIdentificacion(String descripcionTipoIdentificacion) {
		this.descripcionTipoIdentificacion = descripcionTipoIdentificacion;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setTipoIdentificacion(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setTipoIdentificacion(null);

		return persona;
	}

}