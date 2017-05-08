package co.com.patios.ejb.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.patios.entity.Departamento;

/**
 * Session Bean implementation class DepartamentoEJB
 */
@Stateless
@LocalBean
public class DepartamentoEJB {
	
	
	
	@PersistenceContext (name = "PatiosDS")
	EntityManager manager;

    /**
     * Default constructor. 
     */
    public DepartamentoEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    /**
     * consulta los departamentos por id del pais enviado por parametro y retorna un Map
     * @param idpais, id del pais del cual se quieren buscar los departamentos
     * @return
     */
    @SuppressWarnings("unchecked")
	public Map<String, String> consultarDepartamentos(int idPais){
    	Map<String, String> map = new LinkedHashMap<String, String>();
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT u FROM Departamento AS u WHERE u.pais.idPais = :idPais");
    	Query query = manager.createQuery(sql.toString());
    	query.setParameter("idPais", idPais);
    	List<Departamento> listDepartamento = query.getResultList();
    	if(listDepartamento != null && !listDepartamento.isEmpty()){
    		for (Departamento departamento : listDepartamento) {
				map.put(departamento.getNombreDepartamento().trim(), departamento.getIdDepartamento().toString());
			}
    	}
    	
    	return map;
    }

}
