package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.Ciudad;
import co.com.patios.entity.Departamento;

@Local
public interface CiudadIfaceDAO {
	
	
	public List<Ciudad> consultarCiudades();
	public List<Ciudad> consultarCiudadPorDepartamento(Departamento departamento);

}
