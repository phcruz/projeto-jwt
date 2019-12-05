package phc.com.br.exception;

public class ExpiredTokenException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExpiredTokenException() {
		super("Token expirado.");
	}
}
