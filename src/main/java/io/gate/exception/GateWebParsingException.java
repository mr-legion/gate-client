package io.gate.exception;

/**
 * The exception is thrown when the parsing of the web page fails.
 */
public class GateWebParsingException extends RuntimeException {

    private static final long serialVersionUID = -3022173693051234976L;

    public GateWebParsingException(String message) {
        super(message);
    }

    public GateWebParsingException(Throwable cause) {
        super(cause);
    }

    public GateWebParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}