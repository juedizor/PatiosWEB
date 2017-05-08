package co.com.patios.mb.util.validacioncomponentes;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class PasswordValidator implements Validator {

	
	/**
	 * realiza la validacion de contrase�as de cualquier formulario, 
	 * En el formulario se debe asociar el campo de la primera contrase�a a un atributo del campo
	 * de la contrase�a con la cual se va a realizar la validacion, en este caso clave_usuario2 sera llamada la
	 * contrase�a en todos los formularios. 
	 */
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		//se captura el valor de campo (en este caso la primera contrase�a)
		String password = value.toString();

		// se captura el valor de la segunda contrase�a
		UIInput uiInputConfirmPassword = (UIInput) component.getAttributes().get("clave_usuario2");
		String confirmPassword = uiInputConfirmPassword.getSubmittedValue().toString();

		if (!password.equals(confirmPassword)) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setDetail("Las contrase�as no son iguales, Verifique !!!");
			context.addMessage("clave_usuario2", message);
			throw new ValidatorException(message);
		}
		
		
	}

}
