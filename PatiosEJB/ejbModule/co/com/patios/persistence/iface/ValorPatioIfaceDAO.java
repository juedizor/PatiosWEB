package co.com.patios.persistence.iface;

import java.util.Date;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.ValorPatio;

@Local
public interface ValorPatioIfaceDAO extends PersistenceIface<ValorPatio> {

	public ValorPatio consultarValorPatio(Date fechaEntrada, int idPatio, int idClaseVehiculo) throws PersistenceException;

}
