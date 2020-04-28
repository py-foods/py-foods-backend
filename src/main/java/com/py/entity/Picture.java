package com.py.entity;

import javax.persistence.Entity;

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

	private String url;
	private String name;
	private Long productId;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "product_id", referencedColumnName = "id")
//	private Product product;
}
