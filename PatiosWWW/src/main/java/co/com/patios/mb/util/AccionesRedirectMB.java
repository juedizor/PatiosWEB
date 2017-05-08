package co.com.patios.mb.util;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean(name="accionesRedirectMB")
public class AccionesRedirectMB {
	
	
	
	
	public AccionesRedirectMB() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void redireccionar(String ruta){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			context.getExternalContext().redirect(ruta);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
