package co.com.patios.mb.util.validacioncomponentes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class CaracteresEspecialesValidator implements Validator{

	
	
	private static String patronCaracteresEspeciales = "[A-Z a-z]+";
	
	/**
	 * realiza la validacion de caracteres especiales de los campos, teniendo en cuenta una expresion regular
	 */
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		String campo = ""+value;
		if(campo != null && !campo.equals("")){
			if(!validarCaracterEspecial(patronCaracteresEspeciales, campo)){
				FacesMessage message = new FacesMessage();
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				message.setDetail("No se aceptan caracteres especiales, verifique !!!");
				context.addMessage("", message);
				throw new ValidatorException(message);
			}
		}
	}
	
	
	
	/**
	 * realiza la validacion de un texto con una expresion regular
	 * @param expresion, expresion regular
	 * @param texto, texto a validar
	 * @return
	 */
	private boolean validarCaracterEspecial(String expresion, String texto){
		Pattern pattern = Pattern.compile(expresion);
		Matcher matcher = pattern.matcher(texto);
		return matcher.matches();
	}

}
