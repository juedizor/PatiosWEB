package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.Departamento;
import co.com.patios.entity.Pais;

@Local
public interface DepartamentoIfaceDAO extends PersistenceIface<Departamento> {

	public List<Departamento> consultarDepartamentos() throws PersistenceException;

	public List<Departamento> consultarDepartamentos(Pais pais) throws PersistenceException;

}
