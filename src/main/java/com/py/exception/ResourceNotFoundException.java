package com.py.exception;

public class ResourceNotFoundException extends GenericException {
    private static final long serialVersionUID = 1L;

    /**
     * Instance with message
     *
     * @param message
     */
    public ResourceNotFoundException(String message) {
        super(message);
        status = 404;
    }
}
