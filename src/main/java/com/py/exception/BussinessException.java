package com.py.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "internal system error")
public class BussinessException extends GenericException {
	private static final long serialVersionUID = 1L;

	/**
	 * Instance with message
	 *
	 * @param message
	 */
	public BussinessException(String message) {
		super(message);
	}
}
