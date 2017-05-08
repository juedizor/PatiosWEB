package co.com.patios.negocio.iface;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.patios.persistence.iface.VehiculoIfaceDAO;


@Stateless
public class EntradaVehiculosIface {
	
	@EJB
	VehiculoIfaceDAO vehiculoIfaceDAO;
	
		
	
	
	

}
