package co.com.patios.negocio.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.patios.entity.ClaseVehiculo;
import co.com.patios.entity.EstadoVehiculo;
import co.com.patios.entity.MarcaVehiculo;
import co.com.patios.entity.ModeloVehiculo;
import co.com.patios.entity.OrganismoTransito;
import co.com.patios.entity.Pais;
import co.com.patios.entity.TipoIdentificacion;
import co.com.patios.entity.UsuarioPatio;
import co.com.patios.negocio.iface.CatalogosIface;
import co.com.patios.persistence.iface.ClaseVehiculoIfaceDAO;
import co.com.patios.persistence.iface.EstadoVehiculoIfaceDAO;
import co.com.patios.persistence.iface.MarcaVehiculoIfaceDAO;
import co.com.patios.persistence.iface.ModeloVehiculoIfaceDAO;
import co.com.patios.persistence.iface.OrganismoTransitoIfaceDAO;
import co.com.patios.persistence.iface.PaisIfaceDAO;
import co.com.patios.persistence.iface.TipoIdentificacionIfaceDAO;
import co.com.patios.persistence.iface.UsuarioPatioIfaceDAO;

@Stateless
public class CatalogosImpl implements CatalogosIface {

	@EJB
	private PaisIfaceDAO paisIfaceDAO;
	@EJB
	private MarcaVehiculoIfaceDAO marcaVehiculoIfaceDAO;
	@EJB
	private ClaseVehiculoIfaceDAO claseVehiculoIfaceDAO;
	@EJB
	private EstadoVehiculoIfaceDAO estadoVehiculoIfaceDAO;
	@EJB
	private OrganismoTransitoIfaceDAO organismoTransitoIfaceDAO;
	@EJB
	private TipoIdentificacionIfaceDAO tipoIdentificacionIfaceDAO;
	@EJB
	private ModeloVehiculoIfaceDAO modeloVehiculoIfaceDAO;
	@EJB
	private UsuarioPatioIfaceDAO usuarioPatioIfaceDAO;

	@Override
	public List<Pais> getPaises() {
		List<Pais> listPais = paisIfaceDAO.consultarPaises();
		return listPais;
	}

	@Override
	public List<MarcaVehiculo> getMarcasVehiculos() {
		List<MarcaVehiculo> listMarcaVehiculos = marcaVehiculoIfaceDAO.consultarMarcas();
		return listMarcaVehiculos;
	}

	@Override
	public List<ClaseVehiculo> getClasesVehiculos() {
		List<ClaseVehiculo> listClaseVehiculo = claseVehiculoIfaceDAO.consultarClaseVehiculos();
		return listClaseVehiculo;
	}

	@Override
	public List<EstadoVehiculo> getEstadosVehiculos() {
		List<EstadoVehiculo> listEstado = estadoVehiculoIfaceDAO.consultarEstadosVehiculos();
		return listEstado;
	}

	@Override
	public List<OrganismoTransito> getOrganismosTransito() {
		List<OrganismoTransito> listOrganismo = organismoTransitoIfaceDAO.consultarOrganismosTransito();
		return listOrganismo;
	}

	@Override
	public List<TipoIdentificacion> getTiposIdentificacion() {
		List<TipoIdentificacion> listIdentificacion = tipoIdentificacionIfaceDAO.consultarTiposIdentificacion();
		return listIdentificacion;
	}

	@Override
	public List<ModeloVehiculo> getModelosVehiculos(int idMarca) {
		List<ModeloVehiculo> listModelo = modeloVehiculoIfaceDAO.consultarModelosVehiculos(idMarca);
		return listModelo;
	}

	@Override
	public List<UsuarioPatio> getPatiosUsuario(int idUsuario, Date fechaActual) {
		List<UsuarioPatio> listUsuarioPatio = usuarioPatioIfaceDAO.consultarPatiosUsuario(idUsuario, fechaActual);
		return listUsuarioPatio;
	}

}
