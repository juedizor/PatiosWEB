package co.com.app.negocio.general.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.app.negocio.dto.ClaseVehiculoDTO;
import co.com.app.negocio.dto.ColorVehiculoDTO;
import co.com.app.negocio.dto.EstadoVehiculoDTO;
import co.com.app.negocio.dto.ModeloVehiculoDTO;
import co.com.app.negocio.dto.OrganismoTransitoDTO;
import co.com.app.negocio.dto.PersonaDTO;
import co.com.app.negocio.dto.VehiculoDTO;
import co.com.app.negocio.general.iface.GestionVehiculosIface;
import co.com.app.negocio.modelmapper.ClaseVehiculoMapper;
import co.com.app.negocio.modelmapper.ColorVehiculoMapper;
import co.com.app.negocio.modelmapper.EstadoVehiculoMapper;
import co.com.app.negocio.modelmapper.ModeloVehiculoMapper;
import co.com.app.negocio.modelmapper.OrganismoTransitoMapper;
import co.com.app.negocio.modelmapper.PersonaMapper;
import co.com.app.negocio.modelmapper.VehiculoMapper;
import co.com.app.patios.domain.ClaseVehiculo;
import co.com.app.patios.domain.ColorVehiculo;
import co.com.app.patios.domain.EstadoVehiculo;
import co.com.app.patios.domain.ModeloVehiculo;
import co.com.app.patios.domain.OrganismoTransito;
import co.com.app.patios.domain.Persona;
import co.com.app.patios.domain.Vehiculo;
import co.com.app.patios.repository.VehiculoIfaceDAO;


@Service
public class GestionVehiculosImpl implements GestionVehiculosIface{

	@Autowired
	VehiculoIfaceDAO vehiculoIfaceDAO;
	
	@Override
	public VehiculoDTO consultarVehiculo(String placa) throws Exception {
		Vehiculo vehiculo = vehiculoIfaceDAO.findByPlacaVehiculo(placa);
		if(vehiculo != null){
			VehiculoDTO vehiculoDTO = VehiculoMapper.INSTANCE.vehiculoToVehiculoDTO(vehiculo);
			ClaseVehiculo claseVehiculo = vehiculo.getClaseVehiculo();
			ClaseVehiculoDTO claseVehiculoDTO = ClaseVehiculoMapper.INSTANCE.claseVehiculoToClaseVehiculoDTO(claseVehiculo);
			vehiculoDTO.setClaseVehiculo(claseVehiculoDTO);
			ColorVehiculo colorVehiculo = vehiculo.getColorVehiculo();
			ColorVehiculoDTO colorVehiculoDTO = ColorVehiculoMapper.INSTANCE.colorVehiculoToColorVehiculoDTO(colorVehiculo);
			vehiculoDTO.setColorVehiculo(colorVehiculoDTO);
			EstadoVehiculo estadoVehiculo = vehiculo.getEstadoVehiculo();
			EstadoVehiculoDTO estadoVehiculoDTO = EstadoVehiculoMapper.INSTANCE.estadoVehiculoToEstadoVehiculoDTO(estadoVehiculo);
			vehiculoDTO.setEstadoVehiculo(estadoVehiculoDTO);
			ModeloVehiculo modeloVehiculo = vehiculo.getModeloVehiculo();
			ModeloVehiculoDTO modeloVehiculoDTO = ModeloVehiculoMapper.INSTANCE.modeloVehiculoToModeloVehiculoDTO(modeloVehiculo);
			vehiculoDTO.setModeloVehiculo(modeloVehiculoDTO);
			OrganismoTransito organismoTransito = vehiculo.getOrganismoTransito();
			OrganismoTransitoDTO organismoTransitoDTO = OrganismoTransitoMapper.INSTANCE.organismoTransitoToOrganismoTransitoDTO(organismoTransito);
			vehiculoDTO.setOrganismoTransito(organismoTransitoDTO);
			Persona persona = vehiculo.getPersona();
			PersonaDTO personaDTO = PersonaMapper.INSTANCE.personaToPersonaDTO(persona);
			vehiculoDTO.setPersona(personaDTO);
			return vehiculoDTO;
		}
		
		return null;
	}

}
