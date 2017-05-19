package co.com.app.negocio.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.app.negocio.iface.RegistrarPatiosIface;
import co.com.app.patios.domain.Patio;
import co.com.app.patios.repository.PatioIfaceDAO;

public class RegistrarPatiosImpl implements RegistrarPatiosIface {

	@Autowired
	PatioIfaceDAO patioIfaceDAO;

	@Override
	@Transactional
	public Patio realizarRegistroPatio(Patio patio) throws Exception {
		if (patio == null) {
			throw new Exception("El parametro enviado para el registro de patios esta sin datos");
		}

		Patio patioExiste = patioIfaceDAO.findByCodigoPatio(patio.getCodigoPatio());
		if (patioExiste != null) {
			throw new Exception("Ya existe el patio:" + patioExiste.getNombrePatio() + " con el codigo: "
					+ patioExiste.getCodigoPatio());
		}

		patioIfaceDAO.save(patio);
		return patio;
	}

}
