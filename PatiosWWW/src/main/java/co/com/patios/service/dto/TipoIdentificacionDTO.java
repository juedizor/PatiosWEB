package co.com.patios.service.dto;

import java.io.Serializable;

public class TipoIdentificacionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idTipoIdentificacion;
	private String codigoTipoIdentificacion;
	private String descripcionTipoIdentificacion;

	public TipoIdentificacionDTO() {
	}

	public Integer getIdTipoIdentificacion() {
		return this.idTipoIdentificacion;
	}

	public void setIdTipoIdentificacion(Integer idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public String getCodigoTipoIdentificacion() {
		return this.codigoTipoIdentificacion;
	}

	public void setCodigoTipoIdentificacion(String codigoTipoIdentificacion) {
		this.codigoTipoIdentificacion = codigoTipoIdentificacion;
	}

	public String getDescripcionTipoIdentificacion() {
		return this.descripcionTipoIdentificacion;
	}

	public void setDescripcionTipoIdentificacion(String descripcionTipoIdentificacion) {
		this.descripcionTipoIdentificacion = descripcionTipoIdentificacion;
	}

}