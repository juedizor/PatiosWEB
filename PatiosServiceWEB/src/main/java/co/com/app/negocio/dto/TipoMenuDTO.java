package co.com.app.negocio.dto;

import java.io.Serializable;

public class TipoMenuDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idTipoMenu;
	private String tipo;

	public TipoMenuDTO() {
	}

	public Integer getIdTipoMenu() {
		return this.idTipoMenu;
	}

	public void setIdTipoMenu(Integer idTipoMenu) {
		this.idTipoMenu = idTipoMenu;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}