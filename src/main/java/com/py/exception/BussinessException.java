package com.py.exception;

public class BussinessException extends GenericException {
	private static final long serialVersionUID = 1L;

	/**
	 * Instance with message
	 *
	 * @param message
	 */
	public BussinessException(String message) {
		super(message);
		this.status = 500;
	}
}
