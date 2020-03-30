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
public class ProductByCategoryDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = -9174831166287622607L;

	@JsonProperty("category_id")
	private String categoryId;

	@JsonProperty("category")
	private String category;

	@JsonProperty("products")
	private transient List<ProductDTO> products;

}
