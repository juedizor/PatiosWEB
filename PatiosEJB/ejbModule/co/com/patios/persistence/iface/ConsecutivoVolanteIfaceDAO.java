package co.com.patios.persistence.iface;

import java.util.Date;

import javax.ejb.Local;

import co.com.patios.entity.ConsecutivoVolante;

@Local
public interface ConsecutivoVolanteIfaceDAO {
	
	public void registrarConsecutivoVolante(ConsecutivoVolante consecutivoVolante);
	public void actualizarConsecutivoVolante(ConsecutivoVolante consecutivoVolante);
	public ConsecutivoVolante consultarConsecutivoVolante(Date fecha);

}
