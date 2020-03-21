package com.py.exception;

public class ConflictRequestException extends GenericException {
    private static final long serialVersionUID = 1L;

    /**
     * Instance with message
     * @param message
     */
    public ConflictRequestException(String message) {
        super(message);
        this.status = 409;
    }

    public ConflictRequestException() {
        super("Conflict Request");
        this.status = 409;
    }

    /**
     * Instance with code and message
     * @param code
     * @param message
     */
    public ConflictRequestException(String code, String message) {
        super(code, message, 409);
    }
}
