package co.com.patios.service.dto;

public class MenuItemDTO {
	
	private Integer idMenuItem;
	private MenuDTO idMenuPrincipal;
	private MenuDTO idMenuSecundario;
	/**
	 * @return the idMenuItem
	 */
	public Integer getIdMenuItem() {
		return idMenuItem;
	}
	/**
	 * @param idMenuItem the idMenuItem to set
	 */
	public void setIdMenuItem(Integer idMenuItem) {
		this.idMenuItem = idMenuItem;
	}
	/**
	 * @return the idMenuPrincipal
	 */
	public MenuDTO getIdMenuPrincipal() {
		return idMenuPrincipal;
	}
	/**
	 * @param idMenuPrincipal the idMenuPrincipal to set
	 */
	public void setIdMenuPrincipal(MenuDTO idMenuPrincipal) {
		this.idMenuPrincipal = idMenuPrincipal;
	}
	/**
	 * @return the idMenuSecundario
	 */
	public MenuDTO getIdMenuSecundario() {
		return idMenuSecundario;
	}
	/**
	 * @param idMenuSecundario the idMenuSecundario to set
	 */
	public void setIdMenuSecundario(MenuDTO idMenuSecundario) {
		this.idMenuSecundario = idMenuSecundario;
	}
	
	
}
