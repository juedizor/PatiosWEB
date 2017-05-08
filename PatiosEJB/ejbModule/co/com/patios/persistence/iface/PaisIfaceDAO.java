package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.Pais;

@Local
public interface PaisIfaceDAO {
	
	
	public List<Pais> consultarPaises();

}
