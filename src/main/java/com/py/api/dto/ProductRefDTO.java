package com.py.api.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "thumbnail", "sale_price", "cost_price", "discount", "discount_type", "currency",
		"description", "rating" })
public class ProductRefDTO {

	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("thumbnail")
	private String thumbnail;
	@JsonProperty("sale_price")
	private BigDecimal salePrice;
	@JsonProperty("cost_price")
	private BigDecimal costPrice;
	@JsonProperty("discount")
	private Float discount;
	@JsonProperty("discount_type")
	private String discountType;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("description")
	private String description;
	@JsonProperty("rating")
	private Integer rating;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("thumbnail")
	public String getThumbnail() {
		return thumbnail;
	}

	@JsonProperty("thumbnail")
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@JsonProperty("sale_price")
	public BigDecimal getSalePrice() {
		return salePrice;
	}

	@JsonProperty("sale_price")
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	@JsonProperty("cost_price")
	public BigDecimal getCostPrice() {
		return costPrice;
	}

	@JsonProperty("cost_price")
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	@JsonProperty("discount")
	public Float getDiscount() {
		return discount;
	}

	@JsonProperty("discount")
	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	@JsonProperty("discount_type")
	public String getDiscountType() {
		return discountType;
	}

	@JsonProperty("discount_type")
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("rating")
	public Integer getRating() {
		return rating;
	}

	@JsonProperty("rating")
	public void setRating(Integer rating) {
		this.rating = rating;
	}
}