package exercise1;

/**
 * Custom checked exception thrown when an arithmetic division by zero is attempted.
 */
public class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message);
    }
}

