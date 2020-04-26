package com.py.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Product extends BaseEntity {

	private String code;
	private String name;
	private String description;
	private BigDecimal costPrice;
	private String size;
	private String color;
	private String weight;
	private String thumbnail;
	private String note;
	private String currency;
	private Float discount;
	private String discountType;
	private Integer rating;
	private Integer quantity;
	private Long supplierId;
//	private Long categoryId;
	private Integer version;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;
}
