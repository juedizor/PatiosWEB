package co.com.patios.mb.catalogos;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import co.com.patios.entity.ClaseVehiculo;
import co.com.patios.entity.EstadoVehiculo;
import co.com.patios.entity.MarcaVehiculo;
import co.com.patios.entity.OrganismoTransito;
import co.com.patios.entity.Pais;
import co.com.patios.entity.TipoIdentificacion;
import co.com.patios.negocio.iface.CatalogosIface;

@ManagedBean(name = "catalogosImplBean")
@ApplicationScoped
public class CatalogosImpl  {

	@EJB
	CatalogosIface catalogosIface;

	// maneja el onemenu de las marcas de vehiculos
	private Map<String, String> marcasVehiculos;

	// maneja el onemenu de los estados de vehiculos
	private Map<String, String> estadosVehiculos;

	// maneja el onemenu de las clases de vehiculos
	private Map<String, String> clasesVehiculos;

	// maneja el onemenu de los organismos de transito
	private Map<String, String> organismosTransito;

	// maneja el onemenu de los tipo de identificacion de transito
	private Map<String, String> tiposIdentificacion;

	// maneja el onemenu de los paises
	private Map<String, String> paises;

	
	public Map<String, String> getPaises() {
		if (paises == null || paises.isEmpty()) {
			List<Pais> listPaises = catalogosIface.getPaises();
			if (listPaises != null && !listPaises.isEmpty()) {
				paises = new LinkedHashMap<>();
				for (Pais pais : listPaises) {
					paises.put(pais.getDescripcionPais(), "" + pais.getIdPais());
				}
			}
		}
		return paises;
	}

	
	public Map<String, String> getMarcasVehiculos() {
		if (marcasVehiculos == null || marcasVehiculos.isEmpty()) {
			List<MarcaVehiculo> listMarcas = catalogosIface.getMarcasVehiculos();
			if (listMarcas != null && !listMarcas.isEmpty()) {
				marcasVehiculos = new LinkedHashMap<>();
				for (MarcaVehiculo marcaVehiculo : listMarcas) {
					marcasVehiculos.put(marcaVehiculo.getDescripcionMarcaVehiculo(),
							"" + marcaVehiculo.getIdMarcaVehiculo());
				}
			}
		}
		return marcasVehiculos;
	}

	
	public Map<String, String> getClasesVehiculos() {
		if (clasesVehiculos == null || clasesVehiculos.isEmpty()) {
			List<ClaseVehiculo> listClasesVehiculos = catalogosIface.getClasesVehiculos();
			if (listClasesVehiculos != null && !listClasesVehiculos.isEmpty()) {
				clasesVehiculos = new LinkedHashMap<>();
				for (ClaseVehiculo clasesVehiculo : listClasesVehiculos) {
					clasesVehiculos.put(clasesVehiculo.getDescripcionClaseVehiculo(),
							"" + clasesVehiculo.getIdClaseVehiculo());
				}
			}
		}
		return clasesVehiculos;
	}

	
	public Map<String, String> getEstadosVehiculos() {
		if (estadosVehiculos == null || estadosVehiculos.isEmpty()) {
			List<EstadoVehiculo> listEstadoVehiculo = catalogosIface.getEstadosVehiculos();
			if (listEstadoVehiculo != null && !listEstadoVehiculo.isEmpty()) {
				estadosVehiculos = new LinkedHashMap<>();
				for (EstadoVehiculo EstadoVehiculo : listEstadoVehiculo) {
					estadosVehiculos.put(EstadoVehiculo.getDescripcionEstadoVehiculo(),
							"" + EstadoVehiculo.getIdEstadoVehiculo());
				}
			}
		}
		return estadosVehiculos;
	}

	
	public Map<String, String> getOrganismosTransito() {
		if (organismosTransito == null || organismosTransito.isEmpty()) {
			List<OrganismoTransito> listOrganismoTransito = catalogosIface.getOrganismosTransito();
			if (listOrganismoTransito != null && !listOrganismoTransito.isEmpty()) {
				organismosTransito = new LinkedHashMap<>();
				for (OrganismoTransito organismoTransito : listOrganismoTransito) {
					organismosTransito.put(organismoTransito.getNombreAbreviado(),
							"" + organismoTransito.getIdOrganismoTransito());
				}
			}
		}
		return organismosTransito;
	}

	
	public Map<String, String> getTiposIdentificacion() {
		if (tiposIdentificacion == null || tiposIdentificacion.isEmpty()) {
			List<TipoIdentificacion> listTipoIdentificacion = catalogosIface.getTiposIdentificacion();
			if (listTipoIdentificacion != null && !listTipoIdentificacion.isEmpty()) {
				tiposIdentificacion = new LinkedHashMap<>();
				for (TipoIdentificacion tipoIdentificacion : listTipoIdentificacion) {
					tiposIdentificacion.put(tipoIdentificacion.getDescripcionTipoIdentificacion(),
							"" + tipoIdentificacion.getIdTipoIdentificacion());
				}
			}
		}
		return tiposIdentificacion;
	}

}
