package co.com.patios.persistence.iface;

import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.TipoIdentificacion;

@Local
public interface TipoIdentificacionIfaceDAO {

	public void create(TipoIdentificacion tipoIdentificacion);

	public TipoIdentificacion edit(TipoIdentificacion tipoIdentificacion);

	public void remove(TipoIdentificacion tipoIdentificacion);

	public TipoIdentificacion find(Object o);

	/**
	 * lista todos los tipos de identificacion disponibles en el sistema
	 * 
	 * @return
	 */
	public List<TipoIdentificacion> consultarTiposIdentificacion();

	/**
	 * devuelve el tipo de identificación de la tabla tipo_identificacion,
	 * teniendo en cuenta el id de la tabla
	 * 
	 * @param idTipoIdentificacion
	 * @return
	 */
	public TipoIdentificacion consultarTipoIdentificacionPorId(int idTipoIdentificacion);

}
