package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_menu")
	private Integer idMenu;

	@Column(name="nombre_menu")
	private String nombreMenu;

	private String url;

	//bi-directional many-to-one association to TipoMenu
	@ManyToOne
	@JoinColumn(name="id_tipo_menu")
	private TipoMenu tipoMenu;

	//bi-directional many-to-one association to MenuItem
	@OneToMany(mappedBy="menu1")
	private List<MenuItem> menuItems1;

	//bi-directional many-to-one association to MenuItem
	@OneToMany(mappedBy="menu2")
	private List<MenuItem> menuItems2;

	public Menu() {
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

	public TipoMenu getTipoMenu() {
		return this.tipoMenu;
	}

	public void setTipoMenu(TipoMenu tipoMenu) {
		this.tipoMenu = tipoMenu;
	}

	public List<MenuItem> getMenuItems1() {
		return this.menuItems1;
	}

	public void setMenuItems1(List<MenuItem> menuItems1) {
		this.menuItems1 = menuItems1;
	}

	public MenuItem addMenuItems1(MenuItem menuItems1) {
		getMenuItems1().add(menuItems1);
		menuItems1.setMenu1(this);

		return menuItems1;
	}

	public MenuItem removeMenuItems1(MenuItem menuItems1) {
		getMenuItems1().remove(menuItems1);
		menuItems1.setMenu1(null);

		return menuItems1;
	}

	public List<MenuItem> getMenuItems2() {
		return this.menuItems2;
	}

	public void setMenuItems2(List<MenuItem> menuItems2) {
		this.menuItems2 = menuItems2;
	}

	public MenuItem addMenuItems2(MenuItem menuItems2) {
		getMenuItems2().add(menuItems2);
		menuItems2.setMenu2(this);

		return menuItems2;
	}

	public MenuItem removeMenuItems2(MenuItem menuItems2) {
		getMenuItems2().remove(menuItems2);
		menuItems2.setMenu2(null);

		return menuItems2;
	}

}