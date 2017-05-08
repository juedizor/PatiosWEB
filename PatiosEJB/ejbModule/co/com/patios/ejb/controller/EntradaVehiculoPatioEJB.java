package co.com.patios.ejb.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.EntradaVehiculoPatio;

/**
 * Session Bean implementation class EntradaVehiculoEJB
 */
@Stateless
@LocalBean
public class EntradaVehiculoPatioEJB {

	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;
	
	
    /**
     * Default constructor. 
     */
    public EntradaVehiculoPatioEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public void registrarEntradaVehiculo(EntradaVehiculoPatio entradaVehiculoPatio){
    	manager.persist(entradaVehiculoPatio);
    }
    
    public void editarEntradaVehiculo(EntradaVehiculoPatio entradaVehiculoPatio){
    	manager.merge(entradaVehiculoPatio);
    }
    
    @SuppressWarnings("unchecked")
	public List<EntradaVehiculoPatio> obtenerVehiculoEnPatio(){
    	String sql = "SELECT u FROM EntradaVehiculoPatio AS u";
    	Query query = manager.createQuery(sql);
    	List<EntradaVehiculoPatio> listEntradas = query.getResultList();
    	if(listEntradas != null){
    		return listEntradas;
    	}
    	return  null;
    }
    
    /**
     * realiza la consulta de una entrada del vehiculo teniendo en cuenta el id_entrada de la tabla referenciada
     * @param idEntrada, identificador de la entrada
     * @return
     */
	@SuppressWarnings("unchecked")
	public EntradaVehiculoPatio consultarEntradaVehiculo(int idEntrada){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM EntradaVehiculoPatio AS u WHERE u.idEntradaVehiculoPatio = :idEntrada");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idEntrada", idEntrada);
		List<EntradaVehiculoPatio> vehiculo = query.getResultList();
		if(vehiculo != null){
			if(!vehiculo.isEmpty()){
				return vehiculo.get(0);
			}
		}
		
		return null;
		
	}
	
	
	/**
	 * realiza la consulta de la entrada del vehiculo teniendo en cuenta el id_vehiculo y el estado de la entrada 
	 * al patio
	 * @param idVehiculo
	 * @param estadoEntrada
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EntradaVehiculoPatio consultarEntradaVehiculoPorIdVehiculo(int idVehiculo, String estadoEntradaVehiculo){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM EntradaVehiculoPatio AS u WHERE u.vehiculo.idVehiculo = :idVehiculo "
				+ "AND u.estadoEntradaVehiculo = :estadoEntradaVehiculo ");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idVehiculo", idVehiculo);
		query.setParameter("estadoEntradaVehiculo", estadoEntradaVehiculo);
		List<EntradaVehiculoPatio> vehiculo = query.getResultList();
		if(vehiculo != null){
			if(!vehiculo.isEmpty()){
				return vehiculo.get(0);
			}
			
		}
		return null;
	}
	
	/**
	 * realiza la consulta de la entrada del vehiculo teniendo en cuenta el id_vehiculo, el estado de la entrada y el id del  patio 
	 * al patio
	 * @param idVehiculo
	 * @param estadoEntrada
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EntradaVehiculoPatio consultarEntradaVehiculoPorIdVehiculo(int idVehiculo, String estadoEntradaVehiculo, int idPatio){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM EntradaVehiculoPatio AS u WHERE u.vehiculo.idVehiculo = :idVehiculo "
				+ "AND u.estadoEntradaVehiculo = :estadoEntradaVehiculo AND u.patio.idPatio = :idPatio");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("idVehiculo", idVehiculo);
		query.setParameter("estadoEntradaVehiculo", estadoEntradaVehiculo);
		query.setParameter("idPatio", idPatio);
		List<EntradaVehiculoPatio> vehiculo = query.getResultList();
		if(vehiculo.isEmpty()){
			return null;
		}
		return vehiculo.get(0);
	}
	
	/**
	 * realiza la consulta de la entrada del vehiculo teniendo en cuenta el estado de la entrada 
	 * al patio
	 * @param estadoEntrada
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<EntradaVehiculoPatio> consultarEntradaVehiculoPorEstado(String estadoEntradaVehiculo, int idPatio){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM EntradaVehiculoPatio AS u WHERE u.estadoEntradaVehiculo = :estadoEntradaVehiculo ");
		sql.append("AND u.patio.idPatio = :idPatio ");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("estadoEntradaVehiculo", estadoEntradaVehiculo);
		query.setParameter("idPatio", idPatio);
		List<EntradaVehiculoPatio> vehiculo = query.getResultList();
		if(vehiculo.isEmpty()){
			return null;
		}
		return vehiculo;
	}
	
	/**
	 * realiza la consulta de una entrada a patios teniendo en cuenta la placa del vehiculo
	 * @param placa
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EntradaVehiculoPatio consultarEntradaPorPlaca(String placa){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM EntradaVehiculoPatio AS u WHERE u.vehiculo.placaVehiculo = :placa");
		Query query = manager.createQuery(sql.toString());
		query.setParameter("placa", placa);
		List<EntradaVehiculoPatio> vehiculo = query.getResultList();
		if(vehiculo.isEmpty()){
			return null;
		}
		return vehiculo.get(0);
	}
    
	

    
    

}
