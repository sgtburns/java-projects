package Exceptions;

public class SameSerialException  extends Exception {
    private static final long serialVersionUID = 1L;


	public SameSerialException() {
		super("Container, Box or Item with same serial number already exists!"+"\n");
	}

	public SameSerialException(String message, Throwable cause) {
		super(message, cause);
	}

	public SameSerialException(String message) {
		super(message);
	}

	public SameSerialException(Throwable cause) {
		super(cause);
	}
}
