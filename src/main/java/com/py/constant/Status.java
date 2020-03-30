package com.py.constant;

public enum Status {

	OK("OK"), FAILED("FAILED"), OVER_LIMIT_REQUETS("OVER_LIMITED_REQUEST");

	private String value;

	Status(String value) {
		this.value = value;
	}

	public boolean contentEquals(String value) {
		return this.value.equals(value);
	}
}
