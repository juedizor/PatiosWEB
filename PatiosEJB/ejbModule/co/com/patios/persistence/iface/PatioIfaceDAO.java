package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import co.com.patios.entity.Patio;

@Local
public interface PatioIfaceDAO extends PersistenceIface<Patio> {

	public List<Patio> consultarPatios(int idEntrada) throws PersistenceException;

	public List<Patio> consultarPatioNotInIdPatio(int idPatio) throws PersistenceException;

	public List<Patio> consultarPatio() throws PersistenceException;

	public Patio consultarPatioPorCodigo(String codigoPatio) throws PersistenceException;

}
