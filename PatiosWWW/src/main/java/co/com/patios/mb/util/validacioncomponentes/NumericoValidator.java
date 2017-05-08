package co.com.patios.mb.util.validacioncomponentes;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import co.com.patios.mb.util.MessagesEstaticos;
import co.com.patios.mb.util.Utilidades;


public class NumericoValidator implements Validator {
	
	
	
	public NumericoValidator() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	/**
	 * sobreescritura del metodo validate de la interface validator de JSF, 
	 * realiza la validacion de cualquier campo, con relacion a si digitaron un valor numerico o no
	 */
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		String identificacion = ""+value;
		if(!Utilidades.validarNumerico(""+identificacion)){
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setDetail(MessagesEstaticos.getCamposNumericos());
			message.setSummary(MessagesEstaticos.getMensajeCabeceraAlert());
			context.addMessage("", message);	
			throw new ValidatorException(message);
			
		}
		
		
	}
	
	

	

}
