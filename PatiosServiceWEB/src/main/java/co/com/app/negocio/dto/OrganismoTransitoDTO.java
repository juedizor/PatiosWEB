package co.com.app.negocio.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrganismoTransitoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idOrganismoTransito;
	private Long codigoDivisionPolitica;
	private String estadoOrganismoTransito;
	private Timestamp fechaProceso;
	private String nombreAbreviado;
	private String nombreOrganismoTransito;
	private CategoriaOrganismoTransitoDTO categoriaOrganismoTransito;
	private CiudadDTO ciudad;
	private JurisdiccionOrganismoTransitoDTO jurisdiccionOrganismoTransito;
	private UsuarioDTO usuario;

	public OrganismoTransitoDTO() {
	}

	public Integer getIdOrganismoTransito() {
		return this.idOrganismoTransito;
	}

	public void setIdOrganismoTransito(Integer idOrganismoTransito) {
		this.idOrganismoTransito = idOrganismoTransito;
	}

	public Long getCodigoDivisionPolitica() {
		return this.codigoDivisionPolitica;
	}

	public void setCodigoDivisionPolitica(Long codigoDivisionPolitica) {
		this.codigoDivisionPolitica = codigoDivisionPolitica;
	}

	public String getEstadoOrganismoTransito() {
		return this.estadoOrganismoTransito;
	}

	public void setEstadoOrganismoTransito(String estadoOrganismoTransito) {
		this.estadoOrganismoTransito = estadoOrganismoTransito;
	}

	public Timestamp getFechaProceso() {
		return this.fechaProceso;
	}

	public void setFechaProceso(Timestamp fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public String getNombreAbreviado() {
		return this.nombreAbreviado;
	}

	public void setNombreAbreviado(String nombreAbreviado) {
		this.nombreAbreviado = nombreAbreviado;
	}

	public String getNombreOrganismoTransito() {
		return this.nombreOrganismoTransito;
	}

	public void setNombreOrganismoTransito(String nombreOrganismoTransito) {
		this.nombreOrganismoTransito = nombreOrganismoTransito;
	}

	public CategoriaOrganismoTransitoDTO getCategoriaOrganismoTransito() {
		return this.categoriaOrganismoTransito;
	}

	public void setCategoriaOrganismoTransito(CategoriaOrganismoTransitoDTO categoriaOrganismoTransito) {
		this.categoriaOrganismoTransito = categoriaOrganismoTransito;
	}

	public CiudadDTO getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(CiudadDTO ciudad) {
		this.ciudad = ciudad;
	}

	public JurisdiccionOrganismoTransitoDTO getJurisdiccionOrganismoTransito() {
		return this.jurisdiccionOrganismoTransito;
	}

	public void setJurisdiccionOrganismoTransito(JurisdiccionOrganismoTransitoDTO jurisdiccionOrganismoTransito) {
		this.jurisdiccionOrganismoTransito = jurisdiccionOrganismoTransito;
	}

	public UsuarioDTO getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

}