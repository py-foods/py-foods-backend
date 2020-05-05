package com.py.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "order")
@EqualsAndHashCode(callSuper = false)
public class Order extends BaseEntity {
	
	private static final long serialVersionUID = -3625987394750686282L;

	private String code;
	private Integer customerId;
	private Integer paymentId;
	private long totalPrice;
	private Date shipDate;
	private String status;
	private boolean isActive;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private List<OrderDetail> orderDetails = new ArrayList<>(0);

}
