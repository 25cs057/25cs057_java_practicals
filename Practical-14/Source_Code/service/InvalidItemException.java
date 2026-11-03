package service;

/**
 * Domain-specific exception thrown when an invalid item operation is attempted.
 *
 * @author Krupal Parmar (25CS057)
 */
public class InvalidItemException extends Exception {
    public InvalidItemException(String message) {
        super(message);
    }
}

