package com.py.api.dto;

import lombok.Data;

@Data
public class ResponseWrapper {

	private int code;
	private Object data;
}
