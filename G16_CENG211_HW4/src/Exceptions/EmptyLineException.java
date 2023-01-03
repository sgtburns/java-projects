package Exceptions;

public class EmptyLineException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public EmptyLineException() {
		super();
	}

	public EmptyLineException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyLineException(String message) {
		super(message);
	}

	public EmptyLineException(Throwable cause) {
		super(cause);
	}
}
