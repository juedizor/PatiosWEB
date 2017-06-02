package co.com.patios.service.dto;

import java.io.Serializable;

public class ColorVehiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idColorVehiculo;
	private Integer codigoColorVehiculo;
	private String descripcionColorVehiculo;

	public ColorVehiculoDTO() {
	}

	public Integer getIdColorVehiculo() {
		return this.idColorVehiculo;
	}

	public void setIdColorVehiculo(Integer idColorVehiculo) {
		this.idColorVehiculo = idColorVehiculo;
	}

	public Integer getCodigoColorVehiculo() {
		return this.codigoColorVehiculo;
	}

	public void setCodigoColorVehiculo(Integer codigoColorVehiculo) {
		this.codigoColorVehiculo = codigoColorVehiculo;
	}

	public String getDescripcionColorVehiculo() {
		return this.descripcionColorVehiculo;
	}

	public void setDescripcionColorVehiculo(String descripcionColorVehiculo) {
		this.descripcionColorVehiculo = descripcionColorVehiculo;
	}

}