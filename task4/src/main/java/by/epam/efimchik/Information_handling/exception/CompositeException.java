package by.epam.efimchik.Information_handling.exception;

public class CompositeException extends Throwable{
    public CompositeException() {
    }

    public CompositeException(String message) {
        super(message);
    }

    public CompositeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompositeException(Throwable cause) {
        super(cause);
    }
}
