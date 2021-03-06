package com.py.dto.api;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FavouriteDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = -5305343343519835043L;

	@JsonProperty("products")
	private transient List<ProductDTO> products;
}
