package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_menu database table.
 * 
 */
@Entity
@Table(name="tipo_menu")
@NamedQuery(name="TipoMenu.findAll", query="SELECT t FROM TipoMenu t")
public class TipoMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_menu")
	private Integer idTipoMenu;

	private String tipo;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="tipoMenu")
	private List<Menu> menus;

	public TipoMenu() {
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

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setTipoMenu(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setTipoMenu(null);

		return menus;
	}

}