package com.py.dto.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseWrapper {

	private boolean success;
	private Object data;
}
