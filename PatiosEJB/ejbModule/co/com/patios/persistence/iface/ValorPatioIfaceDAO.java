package co.com.patios.persistence.iface;

import java.util.Date;

import javax.ejb.Local;

import co.com.patios.entity.ValorPatio;

@Local
public interface ValorPatioIfaceDAO {
	
	public ValorPatio consultarValorPatio(Date fechaEntrada, int idPatio, int idClaseVehiculo);

}
