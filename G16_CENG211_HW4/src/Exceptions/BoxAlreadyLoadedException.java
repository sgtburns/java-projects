package Exceptions;

public class BoxAlreadyLoadedException extends Exception {
    private static final long serialVersionUID = 1L;

     public BoxAlreadyLoadedException() {
        super("Box is already loaded!" +"\n");
    }

    public BoxAlreadyLoadedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoxAlreadyLoadedException(String message) {
        super(message);
    }

    public BoxAlreadyLoadedException(Throwable cause) {
        super(cause);
    }
}
