package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.Departamento;
import co.com.patios.entity.Pais;

@Local
public interface DepartamentoIfaceDAO {
	
	
	public List<Departamento> consultarDepartamentos();
	public List<Departamento> consultarDepartamentos(Pais pais);

}
