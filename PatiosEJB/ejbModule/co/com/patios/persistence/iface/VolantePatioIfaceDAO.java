package co.com.patios.persistence.iface;

import java.sql.Date;

import javax.ejb.Local;

import co.com.patios.entity.VolantePatio;

@Local
public interface VolantePatioIfaceDAO {
	
	public void insertarVolantePatios(VolantePatio volantePatio);
	
	public VolantePatio consultarVolantePorEntrada(int idEntrada, Date fecha);

}
