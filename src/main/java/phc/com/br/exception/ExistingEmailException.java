package phc.com.br.exception;

public class ExistingEmailException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExistingEmailException() {
		super("Email já existente.");
	}
}
