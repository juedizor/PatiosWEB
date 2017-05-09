package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.DetalleVolantePatio;
import co.com.patios.entity.VolantePatio;

@Local
public interface DetalleVolantePatioIfaceDAO extends PersistenceIface<DetalleVolantePatio> {

	public List<DetalleVolantePatio> consultarDetallePorIdVolante(VolantePatio volantePatio) throws PersistenceException;

}
