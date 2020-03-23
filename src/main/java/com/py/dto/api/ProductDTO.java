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

	private PageDTO page;
	
	private Long id;

	private String code;
	
	private String name;

	private BigDecimal salePrice;

	private BigDecimal costPrice;

	private Integer discount;

	private String discountType;

	private String currency;

	private String description;

	private Integer rating;

	private String size;

	private Integer sold;

	private transient List<String> pictures;

	private transient List<ProductDTO> productRefs;
}