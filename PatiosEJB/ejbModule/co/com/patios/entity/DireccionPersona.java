package co.com.patios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the direccion_persona database table.
 * 
 */
@Entity
@Table(name="direccion_persona")
@NamedQuery(name="DireccionPersona.findAll", query="SELECT d FROM DireccionPersona d")
public class DireccionPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_direccion_persona")
	private Integer idDireccionPersona;

	@Column(name="descripcion_direccion")
	private String descripcionDireccion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_final_direccion")
	private Date fechaFinalDireccion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_direccion")
	private Date fechaInicioDireccion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_proceso")
	private Date fechaProceso;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public DireccionPersona() {
	}

	public Integer getIdDireccionPersona() {
		return this.idDireccionPersona;
	}

	public void setIdDireccionPersona(Integer idDireccionPersona) {
		this.idDireccionPersona = idDireccionPersona;
	}

	public String getDescripcionDireccion() {
		return this.descripcionDireccion;
	}

	public void setDescripcionDireccion(String descripcionDireccion) {
		this.descripcionDireccion = descripcionDireccion;
	}

	public Date getFechaFinalDireccion() {
		return this.fechaFinalDireccion;
	}

	public void setFechaFinalDireccion(Date fechaFinalDireccion) {
		this.fechaFinalDireccion = fechaFinalDireccion;
	}

	public Date getFechaInicioDireccion() {
		return this.fechaInicioDireccion;
	}

	public void setFechaInicioDireccion(Date fechaInicioDireccion) {
		this.fechaInicioDireccion = fechaInicioDireccion;
	}

	public Date getFechaProceso() {
		return this.fechaProceso;
	}

	public void setFechaProceso(Date fechaProceso) {
		this.fechaProceso = fechaProceso;
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