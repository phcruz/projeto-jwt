package phc.com.br.exception;

public class InvalidLoginException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidLoginException() {
		super("Login inválido.");
	}

}
