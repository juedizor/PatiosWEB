package co.com.patios.mb.catalogos;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import co.com.patios.service.client.catalogos.CatalogoServiceClient;
import co.com.patios.service.dto.ClaseVehiculoDTO;
import co.com.patios.service.dto.ColorVehiculoDTO;
import co.com.patios.service.dto.EstadoVehiculoDTO;
import co.com.patios.service.dto.MarcaVehiculoDTO;
import co.com.patios.service.dto.OrganismoTransitoDTO;
import co.com.patios.service.dto.PaisDTO;
import co.com.patios.service.dto.TipoIdentificacionDTO;

@ManagedBean(name = "catalogosGenericos")
@ApplicationScoped
public class CatalogosGenericos {

	/*
	 * maneja el onemenu de las marcas de vehiculos
	 */
	private Map<String, String> marcasVehiculos;
	private List<MarcaVehiculoDTO> listMarcas;

	/*
	 * maneja el onemenu de los estados de vehiculos
	 */
	private Map<String, String> estadosVehiculos;

	/*
	 * maneja el onemenu de las clases de vehiculos
	 */
	private Map<String, String> clasesVehiculos;

	/*
	 * maneja el onemenu de los organismos de transito
	 */
	private Map<String, String> organismosTransito;

	/*
	 * maneja el onemenu de los tipo de identificacion de transito
	 */
	private Map<String, String> tiposIdentificacion;

	/*
	 * maneja el onemenu de los paises
	 */
	private Map<String, String> paises;

	/*
	 * 
	 */
	private List<ColorVehiculoDTO> listColorvehiculo;

	public List<ColorVehiculoDTO> getColores() throws Exception {
		if (listColorvehiculo == null || listColorvehiculo.isEmpty()) {
			listColorvehiculo = CatalogoServiceClient.getInstance().obtenerColorVehiculo();
		}

		return listColorvehiculo;
	}

	public Map<String, String> getPaises() throws Exception {
		if (paises == null || paises.isEmpty()) {
			List<PaisDTO> listPaises = CatalogoServiceClient.getInstance().obtenerPaises();
			if (listPaises != null && !listPaises.isEmpty()) {
				paises = new LinkedHashMap<>();
				for (PaisDTO pais : listPaises) {
					paises.put(pais.getDescripcionPais(), "" + pais.getIdPais());
				}
			}
		}
		return paises;
	}

	public List<MarcaVehiculoDTO> getMarcasvehiculos() throws Exception {
		if (listMarcas == null || listMarcas.isEmpty()) {
			listMarcas = CatalogoServiceClient.getInstance().obtenerMarcaVehiculos();
		}

		return listMarcas;
	}

	public Map<String, String> getMarcasVehiculos() throws Exception {
		if (marcasVehiculos == null || marcasVehiculos.isEmpty()) {
			List<MarcaVehiculoDTO> listMarcas = CatalogoServiceClient.getInstance().obtenerMarcaVehiculos();
			if (listMarcas != null && !listMarcas.isEmpty()) {
				marcasVehiculos = new LinkedHashMap<>();
				for (MarcaVehiculoDTO marcaVehiculo : listMarcas) {
					marcasVehiculos.put(marcaVehiculo.getDescripcionMarcaVehiculo(),
							"" + marcaVehiculo.getIdMarcaVehiculo());
				}
			}
		}
		return marcasVehiculos;
	}

	public Map<String, String> getClasesVehiculos() throws Exception {
		if (clasesVehiculos == null || clasesVehiculos.isEmpty()) {
			List<ClaseVehiculoDTO> listClasesVehiculos = CatalogoServiceClient.getInstance().obtenerClaseVehiculos();
			if (listClasesVehiculos != null && !listClasesVehiculos.isEmpty()) {
				clasesVehiculos = new LinkedHashMap<>();
				for (ClaseVehiculoDTO clasesVehiculo : listClasesVehiculos) {
					clasesVehiculos.put(clasesVehiculo.getDescripcionClaseVehiculo(),
							"" + clasesVehiculo.getIdClaseVehiculo());
				}
			}
		}
		return clasesVehiculos;
	}

	public Map<String, String> getEstadosVehiculos() throws Exception {
		if (estadosVehiculos == null || estadosVehiculos.isEmpty()) {
			List<EstadoVehiculoDTO> listEstadoVehiculo = CatalogoServiceClient.getInstance().obtenerEstadosVehiculos();
			if (listEstadoVehiculo != null && !listEstadoVehiculo.isEmpty()) {
				estadosVehiculos = new LinkedHashMap<>();
				for (EstadoVehiculoDTO EstadoVehiculo : listEstadoVehiculo) {
					estadosVehiculos.put(EstadoVehiculo.getDescripcionEstadoVehiculo(),
							"" + EstadoVehiculo.getIdEstadoVehiculo());
				}
			}
		}
		return estadosVehiculos;
	}

	public Map<String, String> getOrganismosTransito() throws Exception {
		if (organismosTransito == null || organismosTransito.isEmpty()) {
			List<OrganismoTransitoDTO> listOrganismoTransito = CatalogoServiceClient.getInstance()
					.obtenerOrganismoTransito();
			if (listOrganismoTransito != null && !listOrganismoTransito.isEmpty()) {
				organismosTransito = new LinkedHashMap<>();
				for (OrganismoTransitoDTO organismoTransito : listOrganismoTransito) {
					organismosTransito.put(organismoTransito.getNombreAbreviado(),
							"" + organismoTransito.getIdOrganismoTransito());
				}
			}
		}
		return organismosTransito;
	}

	public Map<String, String> getTiposIdentificacion() throws Exception {
		if (tiposIdentificacion == null || tiposIdentificacion.isEmpty()) {
			List<TipoIdentificacionDTO> listTipoIdentificacion = CatalogoServiceClient.getInstance()
					.obtenerTipoIdentificacion();
			if (listTipoIdentificacion != null && !listTipoIdentificacion.isEmpty()) {
				tiposIdentificacion = new LinkedHashMap<>();
				for (TipoIdentificacionDTO tipoIdentificacion : listTipoIdentificacion) {
					tiposIdentificacion.put(tipoIdentificacion.getDescripcionTipoIdentificacion(),
							"" + tipoIdentificacion.getIdTipoIdentificacion());
				}
			}
		}
		return tiposIdentificacion;
	}

}
