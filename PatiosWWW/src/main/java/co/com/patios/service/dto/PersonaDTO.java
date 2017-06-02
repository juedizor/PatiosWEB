package co.com.patios.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class PersonaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idPersona;
	private Timestamp fechaProceso;
	private String nombreComercialPersona;
	private BigDecimal numeroIdentificacion;
	private String primerApellidoPersona;
	private String primerNombrePersona;
	private String segundoApellidoPersona;
	private String segundoNombrePersona;
	private List<DireccionPersonaDTO> direccionPersonas;
	private CiudadDTO ciudad;
	private TipoIdentificacionDTO tipoIdentificacion;
	private List<TelefonoPersonaDTO> telefonoPersonas;
	private List<UsuarioDTO> usuarios;
	private List<VehiculoDTO> vehiculos;

	public PersonaDTO() {
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Timestamp getFechaProceso() {
		return this.fechaProceso;
	}

	public void setFechaProceso(Timestamp fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public String getNombreComercialPersona() {
		return this.nombreComercialPersona;
	}

	public void setNombreComercialPersona(String nombreComercialPersona) {
		this.nombreComercialPersona = nombreComercialPersona;
	}

	public BigDecimal getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}

	public void setNumeroIdentificacion(BigDecimal numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getPrimerApellidoPersona() {
		return this.primerApellidoPersona;
	}

	public void setPrimerApellidoPersona(String primerApellidoPersona) {
		this.primerApellidoPersona = primerApellidoPersona;
	}

	public String getPrimerNombrePersona() {
		return this.primerNombrePersona;
	}

	public void setPrimerNombrePersona(String primerNombrePersona) {
		this.primerNombrePersona = primerNombrePersona;
	}

	public String getSegundoApellidoPersona() {
		return this.segundoApellidoPersona;
	}

	public void setSegundoApellidoPersona(String segundoApellidoPersona) {
		this.segundoApellidoPersona = segundoApellidoPersona;
	}

	public String getSegundoNombrePersona() {
		return this.segundoNombrePersona;
	}

	public void setSegundoNombrePersona(String segundoNombrePersona) {
		this.segundoNombrePersona = segundoNombrePersona;
	}

	public List<DireccionPersonaDTO> getDireccionPersonas() {
		return this.direccionPersonas;
	}

	public void setDireccionPersonas(List<DireccionPersonaDTO> direccionPersonas) {
		this.direccionPersonas = direccionPersonas;
	}

	public CiudadDTO getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(CiudadDTO ciudad) {
		this.ciudad = ciudad;
	}

	public TipoIdentificacionDTO getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public List<TelefonoPersonaDTO> getTelefonoPersonas() {
		return this.telefonoPersonas;
	}

	public void setTelefonoPersonas(List<TelefonoPersonaDTO> telefonoPersonas) {
		this.telefonoPersonas = telefonoPersonas;
	}

	public List<UsuarioDTO> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}

	public List<VehiculoDTO> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<VehiculoDTO> vehiculos) {
		this.vehiculos = vehiculos;
	}

}