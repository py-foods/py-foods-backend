package com.py.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "product")
public class Product extends BaseEntity {

	private String name;
	private String description;
	private String supplierCode;
	private String categoryCode;
	private Integer quantity;
	private BigDecimal price;
	private String size;
	private String color;
	private String weight;
	private String thumbnail;
	private Integer ranking;
	private String note;
	private String currency;
	private Float discount;
	private String discountType;
	private Integer salePercent;
	private Boolean isActive;
	private Integer version;
}
