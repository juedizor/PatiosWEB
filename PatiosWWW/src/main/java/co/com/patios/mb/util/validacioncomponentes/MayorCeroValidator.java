package co.com.patios.mb.util.validacioncomponentes;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import co.com.patios.mb.util.MessagesEstaticos;
import co.com.patios.mb.util.Utilidades;

public class MayorCeroValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		String valor = value.toString();
		if(!Utilidades.validarNumerico(valor)){
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(MessagesEstaticos.getCamposNumericos());
			context.addMessage("panel", message);	
			throw new ValidatorException(message);
		}else{
			if(Long.parseLong(valor) < 0){
				FacesMessage message = new FacesMessage();
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setDetail("El campo debe ser mayor a Cero (0)");
				context.addMessage("", message);
				throw new ValidatorException(message);
			}
		}
	
		
	}
	
	

}
