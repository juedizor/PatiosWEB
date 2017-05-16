package co.com.app.patios.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menu_item database table.
 * 
 */
@Entity
@Table(name="menu_item")
@NamedQuery(name="MenuItem.findAll", query="SELECT m FROM MenuItem m")
public class MenuItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_menu_item")
	private Integer idMenuItem;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="id_menu_principal")
	private Menu menu1;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="id_menu_secundario")
	private Menu menu2;

	public MenuItem() {
	}

	public Integer getIdMenuItem() {
		return this.idMenuItem;
	}

	public void setIdMenuItem(Integer idMenuItem) {
		this.idMenuItem = idMenuItem;
	}

	public Menu getMenu1() {
		return this.menu1;
	}

	public void setMenu1(Menu menu1) {
		this.menu1 = menu1;
	}

	public Menu getMenu2() {
		return this.menu2;
	}

	public void setMenu2(Menu menu2) {
		this.menu2 = menu2;
	}

}