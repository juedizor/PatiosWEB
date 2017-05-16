package co.com.app.rest.exception;

public class GeneralErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msgError;

	public GeneralErrorException() {
		super();
	}

	public GeneralErrorException(String msgError) {
		super(msgError);
		this.msgError = msgError;
	}

	public String getMsgError() {
		return msgError;
	}

	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}

}
