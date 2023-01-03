package Exceptions;

public class UnknownCommandException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnknownCommandException() {
		super("The command does not exist"+"\n");
	}

	public UnknownCommandException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownCommandException(String message) {
		super("The command " + message + " does not exist");
	}

	public UnknownCommandException(Throwable cause) {
		super(cause);
	}
}
