package co.com.patios.persistence.iface;

import java.sql.Date;

import javax.ejb.Local;

import co.com.patios.entity.VolantePatio;

@Local
public interface VolantePatioIfaceDAO extends PersistenceIface<VolantePatio> {

	public VolantePatio consultarVolantePorEntrada(int idEntrada, Date fecha);

}
