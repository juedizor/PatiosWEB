package co.com.patios.service.dto;

import java.io.Serializable;
import java.util.List;

public class MenuDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idMenu;
	private String nombreMenu;
	private String url;
	private TipoMenuDTO tipoMenu;
	private List<MenuItemDTO> menuItems1;
	private List<MenuItemDTO> menuItems2;

	public MenuDTO() {
	}

	public Integer getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getNombreMenu() {
		return this.nombreMenu;
	}

	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TipoMenuDTO getTipoMenu() {
		return this.tipoMenu;
	}

	public void setTipoMenu(TipoMenuDTO tipoMenu) {
		this.tipoMenu = tipoMenu;
	}

	public List<MenuItemDTO> getMenuItems1() {
		return this.menuItems1;
	}

	public void setMenuItems1(List<MenuItemDTO> menuItems1) {
		this.menuItems1 = menuItems1;
	}

	public List<MenuItemDTO> getMenuItems2() {
		return this.menuItems2;
	}

	public void setMenuItems2(List<MenuItemDTO> menuItems2) {
		this.menuItems2 = menuItems2;
	}

}