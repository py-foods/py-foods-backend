package com.py.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "product")
public class Product extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "supplier_code")
	private String supplierCode;

	@Column(name = "category_code")
	private String categoryCode;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "size")
	private String size;

	@Column(name = "color")
	private String color;

	@Column(name = "weight")
	private String weight;

	@Column(name = "thumbnail")
	private String thumbnail;

	@Column(name = "ranking")
	private Integer ranking;

	@Column(name = "note")
	private String note;

	@Column(name = "currency")
	private String currency;

	@Column(name = "discount")
	private Float discount;

	@Column(name = "discount_type")
	private String discountType;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "version")
	private Integer version;

	@Column(name = "product_ref")
	private String productRef;
}
