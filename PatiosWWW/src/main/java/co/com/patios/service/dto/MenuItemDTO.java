package co.com.patios.service.dto;

import java.io.Serializable;


public class MenuItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idMenuItem;
	private MenuDTO menu1;
	private MenuDTO menu2;

	public MenuItemDTO() {
	}

	public Integer getIdMenuItem() {
		return this.idMenuItem;
	}

	public void setIdMenuItem(Integer idMenuItem) {
		this.idMenuItem = idMenuItem;
	}

	public MenuDTO getMenu1() {
		return this.menu1;
	}

	public void setMenu1(MenuDTO menu1) {
		this.menu1 = menu1;
	}

	public MenuDTO getMenu2() {
		return this.menu2;
	}

	public void setMenu2(MenuDTO menu2) {
		this.menu2 = menu2;
	}

}