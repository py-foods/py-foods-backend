package com.py.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.LinkedList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseModal {
	private List<ErrorField> errors = new LinkedList<>();
	private int code;
	private String message;

	/**
	 *
	 */
	public ResponseModal() {
		super();
	}

	/**
	 *
	 * @param msg
	 */
	public ResponseModal(String msg) {
		this.code = 200;
		this.message = msg;
	}

	/**
	 *
	 * @param code
	 * @param msg
	 */
	public ResponseModal(int code, String msg) {
		this.code = code;
		this.message = msg;
	}

	public List<ErrorField> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorField> errors) {
		this.errors = errors;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String msg) {
		this.message = msg;
	}
}
