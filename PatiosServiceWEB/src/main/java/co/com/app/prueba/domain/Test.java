package co.com.app.prueba.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the test database table.
 * 
 */
@Entity
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_test")
	private Integer idTest;

	private String nombre;

	public Test() {
	}

	public Integer getIdTest() {
		return this.idTest;
	}

	public void setIdTest(Integer idTest) {
		this.idTest = idTest;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}