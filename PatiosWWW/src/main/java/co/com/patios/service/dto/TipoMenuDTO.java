package co.com.patios.service.dto;

import java.io.Serializable;
import java.util.List;

public class TipoMenuDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idTipoMenu;
	private String tipo;
	private List<MenuDTO> menus;

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

	public List<MenuDTO> getMenus() {
		return this.menus;
	}

	public void setMenus(List<MenuDTO> menus) {
		this.menus = menus;
	}

}