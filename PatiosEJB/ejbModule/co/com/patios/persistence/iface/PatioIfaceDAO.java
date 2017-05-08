package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.Patio;

@Local
public interface PatioIfaceDAO {
	
	public List<Patio> consultarPatios(int idEntrada);
	public List<Patio> consultarPatioNotInIdPatio(int idPatio);
	public Patio consultarPatio(int idPatio);
	public List<Patio> consultarPatio();
	public Patio consultarPatioPorCodigo(String codigoPatio);
	

}
