package co.com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.app.negocio.dto.ClaseVehiculoDTO;
import co.com.app.negocio.dto.ColorVehiculoDTO;
import co.com.app.negocio.dto.EstadoVehiculoDTO;
import co.com.app.negocio.dto.MarcaVehiculoDTO;
import co.com.app.negocio.dto.OrganismoTransitoDTO;
import co.com.app.negocio.dto.PaisDTO;
import co.com.app.negocio.dto.TipoIdentificacionDTO;
import co.com.app.negocio.iface.CatalogosIface;
import co.com.app.rest.exception.CommonException;
import co.com.app.rest.exception.GeneralErrorException;
import co.com.app.rest.exception.NotFoundException;

@RestController
@RequestMapping("/catalogos")
public class CatalogosService {

	@Autowired
	CatalogosIface catalogosIface;

	@RequestMapping(value = "/paises", method = RequestMethod.GET)
	public List<PaisDTO> getPaises() throws CommonException {
		List<PaisDTO> listPaises;
		try {
			listPaises = catalogosIface.getPaises();
		} catch (Exception e) {
			throw new GeneralErrorException(e.getMessage());
		}

		if (listPaises == null || listPaises.isEmpty()) {
			throw new NotFoundException("No hay datos de paises");
		}

		return listPaises;

	}

	@RequestMapping(value = "/marcaVehiculos", method = RequestMethod.GET)
	public List<MarcaVehiculoDTO> getMarcasVehiculos() throws CommonException {
		List<MarcaVehiculoDTO> listMarcas;
		try {
			listMarcas = catalogosIface.getMarcasVehiculos();
		} catch (Exception e) {
			throw new GeneralErrorException(e.getMessage());
		}

		if (listMarcas == null || listMarcas.isEmpty()) {
			throw new NotFoundException("No hay datos de marcas de vehiculos");
		}

		return listMarcas;

	}

	@RequestMapping(value = "/claseVehiculos", method = RequestMethod.GET)
	public List<ClaseVehiculoDTO> getClaseVehiculos() throws CommonException {
		List<ClaseVehiculoDTO> listClaseVehiculo;
		try {
			listClaseVehiculo = catalogosIface.getClasesVehiculos();
		} catch (Exception e) {
			throw new GeneralErrorException(e.getMessage());
		}

		if (listClaseVehiculo == null || listClaseVehiculo.isEmpty()) {
			throw new NotFoundException("No hay datos de clases de vehiculos");
		}

		return listClaseVehiculo;
	}

	@RequestMapping(value = "/estadosVehiculos", method = RequestMethod.GET)
	public List<EstadoVehiculoDTO> getEstados() throws CommonException {
		List<EstadoVehiculoDTO> listEstados;
		try {
			listEstados = catalogosIface.getEstadosVehiculos();
		} catch (Exception e) {
			throw new GeneralErrorException(e.getMessage());
		}

		if (listEstados == null || listEstados.isEmpty()) {
			throw new NotFoundException("No hay datos de estados");
		}

		return listEstados;
	}

	@RequestMapping(value = "/organismos", method = RequestMethod.GET)
	public List<OrganismoTransitoDTO> getOrganismosTransito() throws CommonException {
		List<OrganismoTransitoDTO> listOT;
		try {
			listOT = catalogosIface.getOrganismosTransito();
		} catch (Exception e) {
			throw new GeneralErrorException(e.getMessage());
		}

		if (listOT == null || listOT.isEmpty()) {
			throw new NotFoundException("No hay datos de organismos");
		}

		return listOT;
	}

	@RequestMapping(value = "/tipoIdentificacion", method = RequestMethod.GET)
	public List<TipoIdentificacionDTO> getTiposIdentificacion() throws CommonException {
		List<TipoIdentificacionDTO> listTiposIdentificacion;
		try {
			listTiposIdentificacion = catalogosIface.getTiposIdentificacion();
		} catch (Exception e) {
			throw new GeneralErrorException(e.getMessage());
		}

		if (listTiposIdentificacion == null || listTiposIdentificacion.isEmpty()) {
			throw new NotFoundException("No hay datos de tipos de identificacion");
		}

		return listTiposIdentificacion;
	}

	@RequestMapping(value = "/colores", method = RequestMethod.GET)
	public List<ColorVehiculoDTO> getColorVehiculo() throws CommonException {
		List<ColorVehiculoDTO> listColorDTO;
		try {
			listColorDTO = catalogosIface.getColorVehiculos();
		} catch (Exception e) {
			throw new GeneralErrorException(e.getMessage());
		}

		if (listColorDTO == null || listColorDTO.isEmpty()) {
			throw new NotFoundException("No hay datos de colores");
		}

		return listColorDTO;

	}

}
