package com.py.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author vmdat
 * @create 19/03/2020
 */
@Entity
public class Picture extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "pictures")
	@JsonIgnore
	private Product product;

	private String imgUrl;
	private String name;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
