package co.com.patios.negocio.iface;

import javax.ejb.Local;

import co.com.patios.entity.Patio;

@Local
public interface RegistrarPatiosIface {
	
	public Patio realizarRegistroPatio(Patio patio) throws Exception;

}
