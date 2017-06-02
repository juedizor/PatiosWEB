package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the telefono_persona database table.
 * 
 */
@Entity
@Table(name="telefono_persona")
@NamedQuery(name="TelefonoPersona.findAll", query="SELECT t FROM TelefonoPersona t")
public class TelefonoPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_telefono_persona")
	private Integer idTelefonoPersona;

	@Column(name="fecha_proceso")
	private Timestamp fechaProceso;

	@Column(name="numero_telefono_persona")
	private String numeroTelefonoPersona;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public TelefonoPersona() {
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

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}