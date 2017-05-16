package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the usuario_patio database table.
 * 
 */
@Entity
@Table(name="usuario_patio")
@NamedQuery(name="UsuarioPatio.findAll", query="SELECT u FROM UsuarioPatio u")
public class UsuarioPatio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario_patio")
	private Integer idUsuarioPatio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_final")
	private Date fechaFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_proceso")
	private Date fechaProceso;

	//bi-directional many-to-one association to Patio
	@ManyToOne
	@JoinColumn(name="id_patio")
	private Patio patio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_asigna")
	private Usuario usuario2;

	public UsuarioPatio() {
	}

	public Integer getIdUsuarioPatio() {
		return this.idUsuarioPatio;
	}

	public void setIdUsuarioPatio(Integer idUsuarioPatio) {
		this.idUsuarioPatio = idUsuarioPatio;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaProceso() {
		return this.fechaProceso;
	}

	public void setFechaProceso(Date fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public Patio getPatio() {
		return this.patio;
	}

	public void setPatio(Patio patio) {
		this.patio = patio;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}