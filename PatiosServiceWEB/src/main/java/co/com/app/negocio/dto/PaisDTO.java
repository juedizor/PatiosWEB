package co.com.app.negocio.dto;

import java.util.List;

public class PaisDTO {
	
	private Integer idPais;
	private Integer codigoPais;
	private String descripcionPais;
	private List<DepartamentosDTO> departamentos;
	/**
	 * @return the idPais
	 */
	public Integer getIdPais() {
		return idPais;
	}
	/**
	 * @param idPais the idPais to set
	 */
	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}
	/**
	 * @return the codigoPais
	 */
	public Integer getCodigoPais() {
		return codigoPais;
	}
	/**
	 * @param codigoPais the codigoPais to set
	 */
	public void setCodigoPais(Integer codigoPais) {
		this.codigoPais = codigoPais;
	}
	/**
	 * @return the descripcionPais
	 */
	public String getDescripcionPais() {
		return descripcionPais;
	}
	/**
	 * @param descripcionPais the descripcionPais to set
	 */
	public void setDescripcionPais(String descripcionPais) {
		this.descripcionPais = descripcionPais;
	}
	/**
	 * @return the departamentos
	 */
	public List<DepartamentosDTO> getDepartamentos() {
		return departamentos;
	}
	/**
	 * @param departamentos the departamentos to set
	 */
	public void setDepartamentos(List<DepartamentosDTO> departamentos) {
		this.departamentos = departamentos;
	}
	
	

}
