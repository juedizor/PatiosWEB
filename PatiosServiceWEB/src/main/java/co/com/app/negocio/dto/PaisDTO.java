package co.com.app.negocio.dto;

import java.io.Serializable;
import java.util.List;

public class PaisDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idPais;
	private Integer codigoPais;
	private String descripcionPais;
	private List<DepartamentoDTO> departamentos;

	public PaisDTO() {
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

	public List<DepartamentoDTO> getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(List<DepartamentoDTO> departamentos) {
		this.departamentos = departamentos;
	}

}