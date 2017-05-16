package co.com.patios.mb.menus;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import co.com.patios.entity.Menu;
import co.com.patios.entity.MenuItem;
import co.com.patios.mb.util.MensajesBundle;
import co.com.patios.mb.util.Utils;
import co.com.patios.negocio.iface.GestionarMenuIface;

@ManagedBean(name = "menuMB")
@SessionScoped
public class MenuMB {

	@EJB
	GestionarMenuIface gestionarMenuIface;

	List<Menu> listMenu;
	List<MenuItem> listMenuItem;
	private MenuModel model;

	private static final int MENU_PRINCIPAL = 1;
	private static final int SUBMENU = 2;
	private static final int ITEM = 3;

	public MenuMB() {
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
			listMenu = gestionarMenuIface.obtenerMenusPorTipo(MENU_PRINCIPAL);
			if (listMenu != null && !listMenu.isEmpty()) {
				for (Menu menu : listMenu) {
					DefaultSubMenu subMenu = new DefaultSubMenu(menu.getNombreMenu());
					model.addElement(subMenu);
					// verifica que el menu tenga submenu asociados
					llenarSubMenuItems(menu, subMenu);
				}
			}

		} catch (Exception e) {
			Utils.enviarMensajeVista(context, message, FacesMessage.SEVERITY_ERROR, null,
					MensajesBundle.getInstance().getMap().get("cabecera_error"), e.getMessage());
		}
	}

	public void llenarSubMenuItems(Menu menu, DefaultSubMenu subMenu) throws Exception {
		listMenuItem = gestionarMenuIface.obtenerMenusItemPorIdMenu(menu.getIdMenu());
		if (listMenuItem != null && !listMenuItem.isEmpty()) {
			
			
			for (MenuItem menuItem : listMenuItem) {
				if (menuItem.getMenu2().getTipoMenu().getIdTipoMenu().equals(ITEM)) {
					DefaultMenuItem item = new DefaultMenuItem(menuItem.getMenu2().getNombreMenu());
					item.setCommand(menuItem.getMenu2().getUrl().trim());
					subMenu.addElement(item);
				}

				if (menuItem.getMenu2().getTipoMenu().getIdTipoMenu().equals(SUBMENU)) {
					DefaultSubMenu sub = new DefaultSubMenu(menuItem.getMenu2().getNombreMenu());
					subMenu.addElement(sub);
					llenarSubMenuItems(menuItem.getMenu2(), sub);
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
