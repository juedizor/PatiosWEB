package co.com.app.negocio.dto;

import java.util.List;

public class MarcaVehiculoDTO {
	
	private Integer idMarcaVehiculo;
	private Long codigoMarcaVehiculo;
	private String descripcionMarcaVehiculo;
	private List<ModeloVehiculoDTO> modeloVehiculos;
	
	
	/**
	 * @return the idMarcaVehiculo
	 */
	public Integer getIdMarcaVehiculo() {
		return idMarcaVehiculo;
	}
	/**
	 * @param idMarcaVehiculo the idMarcaVehiculo to set
	 */
	public void setIdMarcaVehiculo(Integer idMarcaVehiculo) {
		this.idMarcaVehiculo = idMarcaVehiculo;
	}
	/**
	 * @return the codigoMarcaVehiculo
	 */
	public Long getCodigoMarcaVehiculo() {
		return codigoMarcaVehiculo;
	}
	/**
	 * @param codigoMarcaVehiculo the codigoMarcaVehiculo to set
	 */
	public void setCodigoMarcaVehiculo(Long codigoMarcaVehiculo) {
		this.codigoMarcaVehiculo = codigoMarcaVehiculo;
	}
	/**
	 * @return the descripcionMarcaVehiculo
	 */
	public String getDescripcionMarcaVehiculo() {
		return descripcionMarcaVehiculo;
	}
	/**
	 * @param descripcionMarcaVehiculo the descripcionMarcaVehiculo to set
	 */
	public void setDescripcionMarcaVehiculo(String descripcionMarcaVehiculo) {
		this.descripcionMarcaVehiculo = descripcionMarcaVehiculo;
	}
	/**
	 * @return the modeloVehiculos
	 */
	public List<ModeloVehiculoDTO> getModeloVehiculos() {
		return modeloVehiculos;
	}
	/**
	 * @param modeloVehiculos the modeloVehiculos to set
	 */
	public void setModeloVehiculos(List<ModeloVehiculoDTO> modeloVehiculos) {
		this.modeloVehiculos = modeloVehiculos;
	}
	
	

}
