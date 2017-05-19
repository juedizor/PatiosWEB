package co.com.patios.mb.menus;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import co.com.patios.mb.util.ParamsBundle;
import co.com.patios.mb.util.Utils;
import co.com.patios.service.client.menu.MenuClientService;
import co.com.patios.service.dto.MenuDTO;
import co.com.patios.service.dto.MenuItemDTO;

@ManagedBean(name = "menuMB")
@SessionScoped
public class MenuMB {


	List<MenuDTO> listMenu;
	List<MenuItemDTO> listMenuItem;
	private MenuModel model;

	private static final int MENU_PRINCIPAL = 1;
	private static final int SUBMENU = 2;
	private static final int ITEM = 3;

	public MenuMB()  {
		// TODO Auto-generated constructor stub
		
	}

	@PostConstruct
	public void init() {
		model = new DefaultMenuModel();
		construirMenus();
		
	}

	public void construirMenus() {

		/*
		 * captura el contexto del bean que se ejecuta, en este caso el bean
		 * IngresoMB.
		 */
		FacesContext context = FacesContext.getCurrentInstance();

		/*
		 * inicializa el contexto de los mensajes
		 */
		FacesMessage message = new FacesMessage();
		try {
			listMenu = MenuClientService.getInstance().consultarMenus(MENU_PRINCIPAL);;
			if (listMenu != null && !listMenu.isEmpty()) {
				for (MenuDTO menu : listMenu) {
					DefaultSubMenu subMenu = new DefaultSubMenu(menu.getNombreMenu());
					model.addElement(subMenu);
					// verifica que el menu tenga submenu asociados
					llenarSubMenuItems(menu, subMenu);
				}
			}

		} catch (Exception e) {
			Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, null,
					ParamsBundle.getInstance().getMapMensajes().get("cabecera_error"), e.getMessage());
		}
	}

	public void llenarSubMenuItems(MenuDTO menu, DefaultSubMenu subMenu) throws Exception {
		listMenuItem = MenuClientService.getInstance().consultarMenuItems(menu.getIdMenu());
		if (listMenuItem != null && !listMenuItem.isEmpty()) {
			
			
			for (MenuItemDTO menuItem : listMenuItem) {
				if (menuItem.getIdMenuSecundario().getIdTipoMenu().equals(ITEM)) {
					DefaultMenuItem item = new DefaultMenuItem(menuItem.getIdMenuSecundario().getNombreMenu());
					item.setCommand(menuItem.getIdMenuSecundario().getUrl().trim());
					subMenu.addElement(item);
				}

				if (menuItem.getIdMenuSecundario().getIdTipoMenu().equals(SUBMENU)) {
					DefaultSubMenu sub = new DefaultSubMenu(menuItem.getIdMenuSecundario().getNombreMenu());
					subMenu.addElement(sub);
					llenarSubMenuItems(menuItem.getIdMenuSecundario(), sub);
				}
			}
		}
	}

	/**
	 * @return the model
	 */
	public MenuModel getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(MenuModel model) {
		this.model = model;
	}

}
