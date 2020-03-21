package com.py.exception;

public class NoContentException extends GenericException {
    private static final long serialVersionUID = 1L;

    /**
     * Instance with message
     *
     * @param message
     */
    public NoContentException(String message) {
        super(message);
        status = 204;
    }
}
