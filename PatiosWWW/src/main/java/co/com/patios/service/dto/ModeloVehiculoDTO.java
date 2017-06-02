package co.com.patios.service.dto;

import java.io.Serializable;
import java.util.List;

public class ModeloVehiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idModeloVehiculo;
	private Long anioModeloVehiculo;
	private String modeloVehiculo;
	private MarcaVehiculoDTO marcaVehiculo;
	private List<VehiculoDTO> vehiculos;

	public ModeloVehiculoDTO() {
	}

	public Integer getIdModeloVehiculo() {
		return this.idModeloVehiculo;
	}

	public void setIdModeloVehiculo(Integer idModeloVehiculo) {
		this.idModeloVehiculo = idModeloVehiculo;
	}

	public Long getAnioModeloVehiculo() {
		return this.anioModeloVehiculo;
	}

	public void setAnioModeloVehiculo(Long anioModeloVehiculo) {
		this.anioModeloVehiculo = anioModeloVehiculo;
	}

	public String getModeloVehiculo() {
		return this.modeloVehiculo;
	}

	public void setModeloVehiculo(String modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}

	public MarcaVehiculoDTO getMarcaVehiculo() {
		return this.marcaVehiculo;
	}

	public void setMarcaVehiculo(MarcaVehiculoDTO marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}

	public List<VehiculoDTO> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<VehiculoDTO> vehiculos) {
		this.vehiculos = vehiculos;
	}

}