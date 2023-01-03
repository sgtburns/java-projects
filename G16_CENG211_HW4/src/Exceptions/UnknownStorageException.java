package Exceptions;

public class UnknownStorageException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnknownStorageException() {
		super("There is no such storage unit"+"\n");
	}

	public UnknownStorageException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownStorageException(String message) {
		super("There is no such storage unit with the identifier: " + message);
	}

	public UnknownStorageException(Throwable cause) {
		super(cause);
	}
}
