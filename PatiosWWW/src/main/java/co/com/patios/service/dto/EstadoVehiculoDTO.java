package co.com.patios.service.dto;

import java.io.Serializable;

public class EstadoVehiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idEstadoVehiculo;
	private String codigoAlfaEstadoVehiculo;
	private String descripcionEstadoVehiculo;

	public EstadoVehiculoDTO() {
	}

	public Integer getIdEstadoVehiculo() {
		return this.idEstadoVehiculo;
	}

	public void setIdEstadoVehiculo(Integer idEstadoVehiculo) {
		this.idEstadoVehiculo = idEstadoVehiculo;
	}

	public String getCodigoAlfaEstadoVehiculo() {
		return this.codigoAlfaEstadoVehiculo;
	}

	public void setCodigoAlfaEstadoVehiculo(String codigoAlfaEstadoVehiculo) {
		this.codigoAlfaEstadoVehiculo = codigoAlfaEstadoVehiculo;
	}

	public String getDescripcionEstadoVehiculo() {
		return this.descripcionEstadoVehiculo;
	}

	public void setDescripcionEstadoVehiculo(String descripcionEstadoVehiculo) {
		this.descripcionEstadoVehiculo = descripcionEstadoVehiculo;
	}

}