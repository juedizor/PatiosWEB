package co.com.app.negocio.dto;

import java.io.Serializable;

public class ClaseVehiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idClaseVehiculo;
	private Integer codigoClaseVehiculo;
	private String descripcionClaseVehiculo;

	public ClaseVehiculoDTO() {
	}

	public Integer getIdClaseVehiculo() {
		return this.idClaseVehiculo;
	}

	public void setIdClaseVehiculo(Integer idClaseVehiculo) {
		this.idClaseVehiculo = idClaseVehiculo;
	}

	public Integer getCodigoClaseVehiculo() {
		return this.codigoClaseVehiculo;
	}

	public void setCodigoClaseVehiculo(Integer codigoClaseVehiculo) {
		this.codigoClaseVehiculo = codigoClaseVehiculo;
	}

	public String getDescripcionClaseVehiculo() {
		return this.descripcionClaseVehiculo;
	}

	public void setDescripcionClaseVehiculo(String descripcionClaseVehiculo) {
		this.descripcionClaseVehiculo = descripcionClaseVehiculo;
	}

}