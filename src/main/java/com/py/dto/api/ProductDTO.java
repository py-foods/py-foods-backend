package com.py.dto.api;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.py.dto.PageDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = -2775746332178047291L;

	@JsonProperty("page")
	private PageDTO page;
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("code")
	private String code;
	
	@JsonProperty("name")
	private String name;

	@JsonProperty("sale_price")
	private BigDecimal salePrice;

	@JsonProperty("cost_price")
	private BigDecimal costPrice;

	@JsonProperty("discount")
	private Integer discount;

	@JsonProperty("discount_type")
	private String discountType;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("description")
	private String description;

	@JsonProperty("rating")
	private Integer rating;

	@JsonProperty("size")
	private String size;

	@JsonProperty("sold")
	private Integer sold;

	@JsonProperty("pictures")
	private transient List<String> pictures;

	@JsonProperty("product_refs")
	private transient List<ProductDTO> productRefs;
}