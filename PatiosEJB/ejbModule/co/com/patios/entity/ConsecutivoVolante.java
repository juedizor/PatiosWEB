package co.com.patios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the consecutivo_volante database table.
 * 
 */
@Entity
@Table(name="consecutivo_volante")
@NamedQuery(name="ConsecutivoVolante.findAll", query="SELECT c FROM ConsecutivoVolante c")
public class ConsecutivoVolante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_consecutivo_volante")
	private Integer idConsecutivoVolante;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_consecutivo_volante")
	private Date fechaConsecutivoVolante;

	@Column(name="numero_volante")
	private Integer numeroVolante;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public ConsecutivoVolante() {
	}

	public Integer getIdConsecutivoVolante() {
		return this.idConsecutivoVolante;
	}

	public void setIdConsecutivoVolante(Integer idConsecutivoVolante) {
		this.idConsecutivoVolante = idConsecutivoVolante;
	}

	public Date getFechaConsecutivoVolante() {
		return this.fechaConsecutivoVolante;
	}

	public void setFechaConsecutivoVolante(Date fechaConsecutivoVolante) {
		this.fechaConsecutivoVolante = fechaConsecutivoVolante;
	}

	public Integer getNumeroVolante() {
		return this.numeroVolante;
	}

	public void setNumeroVolante(Integer numeroVolante) {
		this.numeroVolante = numeroVolante;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}