package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.DetalleVolantePatio;
import co.com.patios.entity.VolantePatio;

@Local
public interface DetalleVolantePatioIfaceDAO {
	
	 public void insertarDetalleVolantePatio(DetalleVolantePatio detalleVolantePatio);
	 public List<DetalleVolantePatio> consultarDetallePorIdVolante(VolantePatio volantePatio);

}
