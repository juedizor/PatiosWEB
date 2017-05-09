package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.Ciudad;
import co.com.patios.entity.Departamento;

@Local
public interface CiudadIfaceDAO extends PersistenceIface<Ciudad> {

	public List<Ciudad> consultarCiudades() throws PersistenceException;

	public List<Ciudad> consultarCiudadPorDepartamento(Departamento departamento) throws PersistenceException;

}
