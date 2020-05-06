package com.py.controller.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

	private HttpStatus status;
	private String message;
	private List<String> errors;
	private List<ApiSubError> subErrors;
	
	public ApiError() {
		super();
	}

	public ApiError(final HttpStatus status, final String message, final List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public ApiError(final HttpStatus status, final String message, final String error) {
		super();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}
	
	public ApiError(final HttpStatus status, final String message, final List<ApiSubError> subErrors, final List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.subErrors = subErrors;
		this.errors = errors;
	}

	//

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(final HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(final List<String> errors) {
		this.errors = errors;
	}

	public void setError(final String error) {
		errors = Arrays.asList(error);
	}
	
	public void setSubErrors(final List<ApiSubError> subErrors) {
		this.subErrors = subErrors;
	}
	
	public List<ApiSubError> getSubErrors() {
		return this.subErrors;
	}

}
