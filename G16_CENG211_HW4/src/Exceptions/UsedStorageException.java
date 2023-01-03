package Exceptions;

public class UsedStorageException extends Exception {
    private static final long serialVersionUID = 1L;

    public UsedStorageException() {
        super("Storage is already shipped!"+"\n");
    }

    public UsedStorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsedStorageException(String message) {
        super(message);
    }

    public UsedStorageException(Throwable cause) {
        super(cause);
    }
}
