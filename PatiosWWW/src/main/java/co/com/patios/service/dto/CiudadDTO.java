package co.com.patios.service.dto;

import java.io.Serializable;

public class CiudadDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idCiudad;
	private Long codigoDivPolitica;
	private String nombreCiudad;
	private DepartamentoDTO departamento;

	public CiudadDTO() {
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

	public DepartamentoDTO getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = departamento;
	}

}