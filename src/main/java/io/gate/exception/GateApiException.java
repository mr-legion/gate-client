package io.gate.exception;

import io.gate.GateApiError;

/**
 * An exception which can occur while invoking methods of the Gate API.
 */
public class GateApiException extends RuntimeException {

    private static final long serialVersionUID = 1509578386162826374L;

    private GateApiError error;

    public GateApiException(GateApiError error) {
        this.error = error;
    }

    public GateApiException() {
        super();
    }

    public GateApiException(String message) {
        super(message);
    }

    public GateApiException(Throwable cause) {
        super(cause);
    }

    public GateApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Gate API,
     * or null if no response object was returned (e.g. server returned 500).
     */
    public GateApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
