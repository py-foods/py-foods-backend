package com.py.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "product")
@EqualsAndHashCode(callSuper = false)
public class Product extends BaseEntity {

	private static final long serialVersionUID = -1816187449312271791L;

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
	private Integer version;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<OrderDetail> orderDetails = new ArrayList<>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<Picture> pictures = new ArrayList<>(0);

}
