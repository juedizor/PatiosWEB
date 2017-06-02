package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


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

	@Column(name="fecha_consecutivo_volante")
	private Timestamp fechaConsecutivoVolante;

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

	public Timestamp getFechaConsecutivoVolante() {
		return this.fechaConsecutivoVolante;
	}

	public void setFechaConsecutivoVolante(Timestamp fechaConsecutivoVolante) {
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