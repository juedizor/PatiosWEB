package co.com.patios.mb.util.validacioncomponentes;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class PasswordValidator implements Validator {

	
	/**
	 * realiza la validacion de contraseñas de cualquier formulario, 
	 * En el formulario se debe asociar el campo de la primera contraseña a un atributo del campo
	 * de la contraseña con la cual se va a realizar la validacion, en este caso clave_usuario2 sera llamada la
	 * contraseña en todos los formularios. 
	 */
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		//se captura el valor de campo (en este caso la primera contraseña)
		String password = value.toString();

		// se captura el valor de la segunda contraseña
		UIInput uiInputConfirmPassword = (UIInput) component.getAttributes().get("clave_usuario2");
		String confirmPassword = uiInputConfirmPassword.getSubmittedValue().toString();

		if (!password.equals(confirmPassword)) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setDetail("Las contraseñas no son iguales, Verifique !!!");
			context.addMessage("clave_usuario2", message);
			throw new ValidatorException(message);
		}
		
		
	}

}
