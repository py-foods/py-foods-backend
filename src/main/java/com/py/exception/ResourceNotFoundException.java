package com.py.exception;

public class ResourceNotFoundException extends GenericException {

	private static final long serialVersionUID = 6186370736533279916L;

	/**
	 * Instance with message
	 *
	 * @param message
	 */
	public ResourceNotFoundException(String message) {
		super(message);
		this.status = 404;
	}
}
