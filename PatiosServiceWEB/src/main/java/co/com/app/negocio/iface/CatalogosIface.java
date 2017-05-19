package co.com.app.negocio.iface;

import java.util.Date;
import java.util.List;

import co.com.app.negocio.dto.ClaseVehiculoDTO;
import co.com.app.negocio.dto.ColorVehiculoDTO;
import co.com.app.negocio.dto.EstadoVehiculoDTO;
import co.com.app.negocio.dto.MarcaVehiculoDTO;
import co.com.app.negocio.dto.ModeloVehiculoDTO;
import co.com.app.negocio.dto.OrganismoTransitoDTO;
import co.com.app.negocio.dto.PaisDTO;
import co.com.app.negocio.dto.TipoIdentificacionDTO;
import co.com.app.patios.domain.UsuarioPatio;

public interface CatalogosIface {
	
	
	public List<PaisDTO> getPaises();
	public List<MarcaVehiculoDTO> getMarcasVehiculos();
	public List<ClaseVehiculoDTO> getClasesVehiculos();
	public List<EstadoVehiculoDTO> getEstadosVehiculos();
	public List<OrganismoTransitoDTO> getOrganismosTransito();
	public List<TipoIdentificacionDTO> getTiposIdentificacion();
	public List<ColorVehiculoDTO> getColorVehiculos();
	public List<ModeloVehiculoDTO> getModelosVehiculos(int idMarca);
	public List<UsuarioPatio> getPatiosUsuario(int idUsuario, Date fechaActual);

}
