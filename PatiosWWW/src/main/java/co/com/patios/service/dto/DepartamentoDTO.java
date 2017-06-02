package co.com.patios.service.dto;

import java.io.Serializable;
import java.util.List;

public class DepartamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idDepartamento;
	private Integer codigoDepartamento;
	private String nombreDepartamento;
	private List<CiudadDTO> ciudads;
	private PaisDTO pais;

	public DepartamentoDTO() {
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

	public List<CiudadDTO> getCiudads() {
		return this.ciudads;
	}

	public void setCiudads(List<CiudadDTO> ciudads) {
		this.ciudads = ciudads;
	}

	public PaisDTO getPais() {
		return this.pais;
	}

	public void setPais(PaisDTO pai) {
		this.pais = pai;
	}

}