package com.py.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "order_detail")
@EqualsAndHashCode(callSuper = false)
public class OrderDetail extends BaseEntity {

	private static final long serialVersionUID = 166892785320332806L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	
	private int quantity;
	private BigDecimal price;
	private float discount;
	private String size;
	private String color;

}
