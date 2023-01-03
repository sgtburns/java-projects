package Exceptions;

public class WrongBoxException extends Exception {
    
        /**
        * 
        */
        private static final long serialVersionUID = 1L;
        
        public WrongBoxException() {
            super("Wrong box type!"+"\n");
        }
        public WrongBoxException(String message, Throwable cause) {
            super(message, cause);
        }

        public WrongBoxException(String message) {
            super(message);
        }

        public WrongBoxException(Throwable cause) {
            super(cause);
        }

}
