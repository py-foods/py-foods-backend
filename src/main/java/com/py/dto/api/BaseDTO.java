package com.py.dto.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.py.constant.Status;
import com.py.dto.PageDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDTO {

	private Status status;
	private PageDTO page;
}
