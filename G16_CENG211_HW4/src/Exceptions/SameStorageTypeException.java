package Exceptions;

public class SameStorageTypeException extends Exception {
    private static final long serialVersionUID = 1L;
	
	public SameStorageTypeException() {
		super("The storage type is the same"+"\n");
	}

	public SameStorageTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public SameStorageTypeException(String message) {
		super("The storage unit " + message + " is the same as the stored unit"+"\n");
	}

	public SameStorageTypeException(Throwable cause) {
		super(cause);
	}
}
