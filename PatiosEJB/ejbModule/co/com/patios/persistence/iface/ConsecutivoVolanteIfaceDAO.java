package co.com.patios.persistence.iface;

import java.util.Date;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.ConsecutivoVolante;

@Local
public interface ConsecutivoVolanteIfaceDAO extends PersistenceIface<ConsecutivoVolante>{
	
	public ConsecutivoVolante consultarConsecutivoVolante(Date fecha) throws PersistenceException;

}
