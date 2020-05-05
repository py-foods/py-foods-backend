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
public class ProductOnCategoryDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = -9174831166287622607L;

	@JsonProperty("category_id")
	private Long categoryId;

	@JsonProperty("category_name")
	private String categoryName;

	@JsonProperty("products")
	private List<ProductDTO> products;

}
