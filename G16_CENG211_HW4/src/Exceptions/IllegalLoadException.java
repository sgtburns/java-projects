package Exceptions;

public class IllegalLoadException extends Exception {
    private static final long serialVersionUID = 1L;

    public IllegalLoadException() {
        super("Illegal load!"+"\n");
    }

    public IllegalLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalLoadException(String message) {
        super(message);
    }

    public IllegalLoadException(Throwable cause) {
        super(cause);
    }
}
