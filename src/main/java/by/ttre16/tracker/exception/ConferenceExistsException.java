package by.ttre16.tracker.exception;

public class ConferenceExistsException extends Exception {
    public ConferenceExistsException() {
    }

    public ConferenceExistsException(String message) {
        super(message);
    }

    public ConferenceExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
