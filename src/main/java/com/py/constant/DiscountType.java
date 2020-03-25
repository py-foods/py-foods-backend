package com.py.constant;

/**
 * @author vmdat
 * @create 19/03/2020
 */
public enum DiscountType {

	PERCENT("percent"), AMOUNT("amount");

	private String code;

	DiscountType(String code) {
		this.code = code;
	}

	public boolean contentEquals(String value) {
		return this.code.equals(value);
	}
}
