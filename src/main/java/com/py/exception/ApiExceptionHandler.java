package com.py.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(GenericException.class)
	public ResponseEntity<ErrorResponse> handleGenericExceptions(GenericException ex) {
		ErrorResponse error = new ErrorResponse(ex.getStatus(), ex.getMessage());
		return ResponseEntity.status(ex.getStatus()).body(error);
	}
}
