package co.com.patios.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class EntradaVehiculoPatioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idEntradaVehiculoPatio;
	private String estadoEntradaVehiculo;
	private Timestamp fechaEntradaVehiculo;
	private PatioDTO patio;
	private UsuarioDTO usuario;
	private VehiculoDTO vehiculo;
	private List<VolantePatioDTO> volantePatios;

	public EntradaVehiculoPatioDTO() {
	}

	public Integer getIdEntradaVehiculoPatio() {
		return this.idEntradaVehiculoPatio;
	}

	public void setIdEntradaVehiculoPatio(Integer idEntradaVehiculoPatio) {
		this.idEntradaVehiculoPatio = idEntradaVehiculoPatio;
	}

	public String getEstadoEntradaVehiculo() {
		return this.estadoEntradaVehiculo;
	}

	public void setEstadoEntradaVehiculo(String estadoEntradaVehiculo) {
		this.estadoEntradaVehiculo = estadoEntradaVehiculo;
	}

	public Timestamp getFechaEntradaVehiculo() {
		return this.fechaEntradaVehiculo;
	}

	public void setFechaEntradaVehiculo(Timestamp fechaEntradaVehiculo) {
		this.fechaEntradaVehiculo = fechaEntradaVehiculo;
	}

	public PatioDTO getPatio() {
		return this.patio;
	}

	public void setPatio(PatioDTO patio) {
		this.patio = patio;
	}

	public UsuarioDTO getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public VehiculoDTO getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(VehiculoDTO vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<VolantePatioDTO> getVolantePatios() {
		return this.volantePatios;
	}

	public void setVolantePatios(List<VolantePatioDTO> volantePatios) {
		this.volantePatios = volantePatios;
	}

}