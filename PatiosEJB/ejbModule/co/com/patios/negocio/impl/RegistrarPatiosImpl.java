package co.com.patios.negocio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import co.com.patios.entity.Patio;
import co.com.patios.negocio.iface.RegistrarPatiosIface;
import co.com.patios.persistence.iface.PatioIfaceDAO;

@Stateless
public class RegistrarPatiosImpl implements RegistrarPatiosIface {

	@EJB
	PatioIfaceDAO patioIfaceDAO;
	
	@Override
	@Transactional
	public Patio realizarRegistroPatio(Patio patio) throws Exception {
		if(patio == null){
			throw new Exception("El parametro enviado para el registro de patios esta sin datos");
		}
		
		Patio patioExiste = patioIfaceDAO.consultarPatioPorCodigo(patio.getCodigoPatio());
		if(patioExiste != null){
			throw new Exception("Ya existe el patio:" + patioExiste.getNombrePatio() + " con el codigo: " + patioExiste.getCodigoPatio());
		}
			
		patioIfaceDAO.save(patio);
		return patio;
	}

}
