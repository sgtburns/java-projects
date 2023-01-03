package Exceptions;

public class NoMoreTokensException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public NoMoreTokensException() {
		super("The tokenizer does not have any tokens left"+"\n");
	}

	public NoMoreTokensException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoMoreTokensException(String message) {
		super(message);
	}

	public NoMoreTokensException(Throwable cause) {
		super(cause);
	}
}
