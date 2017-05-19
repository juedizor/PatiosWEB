package co.com.app.negocio.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.app.negocio.dto.ClaseVehiculoDTO;
import co.com.app.negocio.dto.ColorVehiculoDTO;
import co.com.app.negocio.dto.EstadoVehiculoDTO;
import co.com.app.negocio.dto.MarcaVehiculoDTO;
import co.com.app.negocio.dto.ModeloVehiculoDTO;
import co.com.app.negocio.dto.OrganismoTransitoDTO;
import co.com.app.negocio.dto.PaisDTO;
import co.com.app.negocio.dto.TipoIdentificacionDTO;
import co.com.app.negocio.iface.CatalogosIface;
import co.com.app.negocio.modelmapper.ClaseVehiculoMapper;
import co.com.app.negocio.modelmapper.ColorVehiculoMapper;
import co.com.app.negocio.modelmapper.EstadoVehiculoMapper;
import co.com.app.negocio.modelmapper.MarcaVehiculoMapper;
import co.com.app.negocio.modelmapper.ModeloVehiculoMapper;
import co.com.app.negocio.modelmapper.OrganismoTransitoMapper;
import co.com.app.negocio.modelmapper.PaisMapper;
import co.com.app.negocio.modelmapper.TipoIdentificacionMapper;
import co.com.app.patios.domain.ClaseVehiculo;
import co.com.app.patios.domain.ColorVehiculo;
import co.com.app.patios.domain.EstadoVehiculo;
import co.com.app.patios.domain.MarcaVehiculo;
import co.com.app.patios.domain.ModeloVehiculo;
import co.com.app.patios.domain.OrganismoTransito;
import co.com.app.patios.domain.Pais;
import co.com.app.patios.domain.TipoIdentificacion;
import co.com.app.patios.domain.UsuarioPatio;
import co.com.app.patios.repository.ClaseVehiculoIfaceDAO;
import co.com.app.patios.repository.ColorVehiculoIfaceDAO;
import co.com.app.patios.repository.EstadoVehiculoIfaceDAO;
import co.com.app.patios.repository.MarcaVehiculoIfaceDAO;
import co.com.app.patios.repository.ModeloVehiculoIfaceDAO;
import co.com.app.patios.repository.OrganismoTransitoIfaceDAO;
import co.com.app.patios.repository.PaisIfaceDAO;
import co.com.app.patios.repository.TipoIdentificacionIfaceDAO;
import co.com.app.patios.repository.UsuarioPatioIfaceDAO;

@Service
public class CatalogosImpl implements CatalogosIface {

	@Autowired
	private PaisIfaceDAO paisIfaceDAO;
	@Autowired
	private MarcaVehiculoIfaceDAO marcaVehiculoIfaceDAO;
	@Autowired
	private ClaseVehiculoIfaceDAO claseVehiculoIfaceDAO;
	@Autowired
	private EstadoVehiculoIfaceDAO estadoVehiculoIfaceDAO;
	@Autowired
	private OrganismoTransitoIfaceDAO organismoTransitoIfaceDAO;
	@Autowired
	private TipoIdentificacionIfaceDAO tipoIdentificacionIfaceDAO;
	@Autowired
	private ModeloVehiculoIfaceDAO modeloVehiculoIfaceDAO;
	@Autowired
	private UsuarioPatioIfaceDAO usuarioPatioIfaceDAO;
	@Autowired
	private ColorVehiculoIfaceDAO colorVehiculoIfaceDAO;

	@Override
	public List<PaisDTO> getPaises() {
		List<Pais> listPais = paisIfaceDAO.findAll();
		List<PaisDTO> listPaisDTO = PaisMapper.INSTANCE.paisToPaisDTOs(listPais);
		return listPaisDTO;
	}

	@Override
	public List<MarcaVehiculoDTO> getMarcasVehiculos() {
		List<MarcaVehiculo> listMarcaVehiculos = marcaVehiculoIfaceDAO.findAll();
		List<MarcaVehiculoDTO> listMarcaVehiculoDTO = MarcaVehiculoMapper.INSTANCE
				.marcasVehiculosToMarcaVehiculoDTOs(listMarcaVehiculos);
		return listMarcaVehiculoDTO;
	}

	@Override
	public List<ClaseVehiculoDTO> getClasesVehiculos() {
		List<ClaseVehiculo> listClaseVehiculo = claseVehiculoIfaceDAO.findAll();
		List<ClaseVehiculoDTO> listClaseVehiculoDTO = ClaseVehiculoMapper.INSTANCE
				.claseVehiculosToClaseVehiculoDTOs(listClaseVehiculo);
		return listClaseVehiculoDTO;
	}

	@Override
	public List<EstadoVehiculoDTO> getEstadosVehiculos() {
		List<EstadoVehiculo> listEstado = estadoVehiculoIfaceDAO.findAll();
		List<EstadoVehiculoDTO> listEstadoVehiculoDTO = EstadoVehiculoMapper.INSTANCE
				.estadoVehiculosToEstadoVehiculoDTOs(listEstado);
		return listEstadoVehiculoDTO;
	}

	@Override
	public List<OrganismoTransitoDTO> getOrganismosTransito() {
		List<OrganismoTransito> listOrganismo = organismoTransitoIfaceDAO.findAll();
		List<OrganismoTransitoDTO> listOrganismoTransitoDTO = OrganismoTransitoMapper.INSTANCE
				.organismoTransitosToOrganismoTransitoDTOs(listOrganismo);
		return listOrganismoTransitoDTO;
	}

	@Override
	public List<TipoIdentificacionDTO> getTiposIdentificacion() {
		List<TipoIdentificacion> listIdentificacion = tipoIdentificacionIfaceDAO.findAll();
		List<TipoIdentificacionDTO> listTipoIdentificacionDTO = TipoIdentificacionMapper.INSTANCE
				.tipoIdentificacionToTipoIdentificacionDTOs(listIdentificacion);
		return listTipoIdentificacionDTO;
	}

	@Override
	public List<ModeloVehiculoDTO> getModelosVehiculos(int idMarca) {
		List<ModeloVehiculo> listModelo = modeloVehiculoIfaceDAO.findByIdMarca(idMarca);
		List<ModeloVehiculoDTO> listModeloVehiculoDTO = ModeloVehiculoMapper.INSTANCE
				.modeloVehiculosToModeloVehiculoDTOs(listModelo);
		return listModeloVehiculoDTO;
	}

	@Override
	public List<UsuarioPatio> getPatiosUsuario(int idUsuario, Date fechaActual) {
		List<UsuarioPatio> listUsuarioPatio = usuarioPatioIfaceDAO.consultarPatiosUsuario(idUsuario, fechaActual);
		return listUsuarioPatio;
	}

	@Override
	public List<ColorVehiculoDTO> getColorVehiculos() {
		List<ColorVehiculo> listColor = colorVehiculoIfaceDAO.findAll();
		List<ColorVehiculoDTO> listColorDTO = ColorVehiculoMapper.INSTANCE.colorVehiculosToColorVehiculoDTOs(listColor);
		return listColorDTO;
	}

}
