package co.com.patios.service.dto;

import java.io.Serializable;
import java.util.List;

public class MarcaVehiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idMarcaVehiculo;
	private Long codigoMarcaVehiculo;
	private String descripcionMarcaVehiculo;
	private List<ModeloVehiculoDTO> modeloVehiculos;

	public MarcaVehiculoDTO() {
	}

	public Integer getIdMarcaVehiculo() {
		return this.idMarcaVehiculo;
	}

	public void setIdMarcaVehiculo(Integer idMarcaVehiculo) {
		this.idMarcaVehiculo = idMarcaVehiculo;
	}

	public Long getCodigoMarcaVehiculo() {
		return this.codigoMarcaVehiculo;
	}

	public void setCodigoMarcaVehiculo(Long codigoMarcaVehiculo) {
		this.codigoMarcaVehiculo = codigoMarcaVehiculo;
	}

	public String getDescripcionMarcaVehiculo() {
		return this.descripcionMarcaVehiculo;
	}

	public void setDescripcionMarcaVehiculo(String descripcionMarcaVehiculo) {
		this.descripcionMarcaVehiculo = descripcionMarcaVehiculo;
	}

	public List<ModeloVehiculoDTO> getModeloVehiculos() {
		return this.modeloVehiculos;
	}

	public void setModeloVehiculos(List<ModeloVehiculoDTO> modeloVehiculos) {
		this.modeloVehiculos = modeloVehiculos;
	}

}