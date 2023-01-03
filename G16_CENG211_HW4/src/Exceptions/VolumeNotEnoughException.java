package Exceptions;

public class VolumeNotEnoughException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VolumeNotEnoughException() {
		super("Volume of the designated storage unit can not hold this item"+"\n");
	}

	public VolumeNotEnoughException(String message, Throwable cause) {
		super(message, cause);
	}

	public VolumeNotEnoughException(String message) {
		super("Volume of the storage unit "+ message +" can not hold this item");
	}

	public VolumeNotEnoughException(Throwable cause) {
		super(cause);
	}
}
