package co.com.patios.mb.catalogos;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import co.com.patios.service.dto.MarcaVehiculoDTO;
import co.com.patios.service.dto.ModeloVehiculoDTO;

@ManagedBean(name = "modelosMarcas")
@SessionScoped
public class ModelosMarcas {

	private Map<String, String> modelosMarcas;

	@ManagedProperty(value = "#{catalogosGenericos}")
	CatalogosGenericos catalogosGenericos;

	public Map<String, String> getModelos(int idMarca) throws Exception {
		List<MarcaVehiculoDTO> listMarcas = catalogosGenericos.getMarcasvehiculos();
		if (listMarcas != null && !listMarcas.isEmpty()) {
			for (MarcaVehiculoDTO marcaVehiculoDTO : listMarcas) {
				if (marcaVehiculoDTO.getIdMarcaVehiculo().equals(idMarca)) {
					List<ModeloVehiculoDTO> listModelos = marcaVehiculoDTO.getModeloVehiculos();
					if (listModelos != null && !listModelos.isEmpty()) {
						Map<String, String> mapModelos = new LinkedHashMap<>();
						for (ModeloVehiculoDTO modeloVehiculoDTO : listModelos) {
							mapModelos.put(modeloVehiculoDTO.getModeloVehiculo(),
									"" + modeloVehiculoDTO.getIdModeloVehiculo());
						}
						return mapModelos;
					}
					break;
				}
			}
		}

		return null;
	}

	/**
	 * @return the modelosMarcas
	 */
	public Map<String, String> getModelosMarcas() {
		return modelosMarcas;
	}

	/**
	 * @param modelosMarcas
	 *            the modelosMarcas to set
	 */
	public void setModelosMarcas(Map<String, String> modelosMarcas) {
		this.modelosMarcas = modelosMarcas;
	}

	/**
	 * @return the catalogosGenericos
	 */
	public CatalogosGenericos getCatalogosGenericos() {
		return catalogosGenericos;
	}

	/**
	 * @param catalogosGenericos
	 *            the catalogosGenericos to set
	 */
	public void setCatalogosGenericos(CatalogosGenericos catalogosGenericos) {
		this.catalogosGenericos = catalogosGenericos;
	}

}
