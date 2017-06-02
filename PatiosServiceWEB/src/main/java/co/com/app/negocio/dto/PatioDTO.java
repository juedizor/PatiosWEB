package co.com.app.negocio.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class PatioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idPatio;
	private Integer capacidadPatio;
	private String codigoPatio;
	private String direccionPatio;
	private Timestamp fechaRegistroPatio;
	private String nombrePatio;
	private String telefonoPatio;
	private List<EntradaVehiculoPatioDTO> entradaVehiculoPatios;
	private UsuarioDTO usuario;
	private List<UsuarioPatioDTO> usuarioPatios;
	private List<ValorPatioDTO> valorPatios;

	public PatioDTO() {
	}

	public Integer getIdPatio() {
		return this.idPatio;
	}

	public void setIdPatio(Integer idPatio) {
		this.idPatio = idPatio;
	}

	public Integer getCapacidadPatio() {
		return this.capacidadPatio;
	}

	public void setCapacidadPatio(Integer capacidadPatio) {
		this.capacidadPatio = capacidadPatio;
	}

	public String getCodigoPatio() {
		return this.codigoPatio;
	}

	public void setCodigoPatio(String codigoPatio) {
		this.codigoPatio = codigoPatio;
	}

	public String getDireccionPatio() {
		return this.direccionPatio;
	}

	public void setDireccionPatio(String direccionPatio) {
		this.direccionPatio = direccionPatio;
	}

	public Timestamp getFechaRegistroPatio() {
		return this.fechaRegistroPatio;
	}

	public void setFechaRegistroPatio(Timestamp fechaRegistroPatio) {
		this.fechaRegistroPatio = fechaRegistroPatio;
	}

	public String getNombrePatio() {
		return this.nombrePatio;
	}

	public void setNombrePatio(String nombrePatio) {
		this.nombrePatio = nombrePatio;
	}

	public String getTelefonoPatio() {
		return this.telefonoPatio;
	}

	public void setTelefonoPatio(String telefonoPatio) {
		this.telefonoPatio = telefonoPatio;
	}

	public List<EntradaVehiculoPatioDTO> getEntradaVehiculoPatios() {
		return this.entradaVehiculoPatios;
	}

	public void setEntradaVehiculoPatios(List<EntradaVehiculoPatioDTO> entradaVehiculoPatios) {
		this.entradaVehiculoPatios = entradaVehiculoPatios;
	}

	public UsuarioDTO getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioPatioDTO> getUsuarioPatios() {
		return this.usuarioPatios;
	}

	public void setUsuarioPatios(List<UsuarioPatioDTO> usuarioPatios) {
		this.usuarioPatios = usuarioPatios;
	}

	public List<ValorPatioDTO> getValorPatios() {
		return this.valorPatios;
	}

	public void setValorPatios(List<ValorPatioDTO> valorPatios) {
		this.valorPatios = valorPatios;
	}

}