package co.com.patios.negocio.iface;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import co.com.patios.entity.ClaseVehiculo;
import co.com.patios.entity.EstadoVehiculo;
import co.com.patios.entity.MarcaVehiculo;
import co.com.patios.entity.ModeloVehiculo;
import co.com.patios.entity.OrganismoTransito;
import co.com.patios.entity.Pais;
import co.com.patios.entity.TipoIdentificacion;
import co.com.patios.entity.UsuarioPatio;

@Local
public interface CatalogosIface {
	
	
	public List<Pais> getPaises();
	public List<MarcaVehiculo> getMarcasVehiculos();
	public List<ClaseVehiculo> getClasesVehiculos();
	public List<EstadoVehiculo> getEstadosVehiculos();
	public List<OrganismoTransito> getOrganismosTransito();
	public List<TipoIdentificacion> getTiposIdentificacion();
	public List<ModeloVehiculo> getModelosVehiculos(int idMarca);
	public List<UsuarioPatio> getPatiosUsuario(int idUsuario, Date fechaActual);

}
