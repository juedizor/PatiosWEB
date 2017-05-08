package co.com.patios.mb.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.com.patios.ejb.controller.PatioEJB;
import co.com.patios.entity.Patio;


@ManagedBean (name = "listarPatiosMB")
@ViewScoped
public class ListarPatiosMB {

	

	private List<Patio> listPatio;
	
	@EJB
	PatioEJB patioEJB;
	
	
	public ListarPatiosMB() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void obtenerPatios(){
		setListPatio(patioEJB.consultarPatio());
	}
	
	
	/**
	 * @return the listPatio
	 */
	public List<Patio> getListPatio() {
		return listPatio;
	}


	/**
	 * @param listPatio the listPatio to set
	 */
	public void setListPatio(List<Patio> listPatio) {
		this.listPatio = listPatio;
	}

	

	

	

	

	

	

	
	
	
	
}
