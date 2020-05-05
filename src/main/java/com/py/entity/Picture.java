package com.py.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author vmdat
 * @create 19/03/2020
 */
@Data
@Entity(name = "picture")
@EqualsAndHashCode(callSuper = false)
public class Picture extends BaseEntity {

	private static final long serialVersionUID = -4981640750658803558L;

	private String url;
	private String name;
	private Boolean isActive;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
}
