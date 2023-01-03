package Exceptions;

public class BoxNotFoundException extends Exception {
    
        private static final long serialVersionUID = 1L;

    public BoxNotFoundException() {
        super("Box not found!"+"\n");
    }

    public BoxNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoxNotFoundException(String message) {
        super(message);
    }

    public BoxNotFoundException(Throwable cause) {
        super(cause);
    }

}
