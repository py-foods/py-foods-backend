package com.py.api.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "picture", "sale_price", "cost_price", "discount", "discount_type", "currency",
		"description", "rating", "size", "stock", "sold", "product_refs" })
public class ProductDTO {

	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("picture")
	private List<String> picture = null;
	@JsonProperty("sale_price")
	private BigDecimal salePrice;
	@JsonProperty("cost_price")
	private Integer costPrice;
	@JsonProperty("discount")
	private Integer discount;
	@JsonProperty("discount_type")
	private String discountType;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("description")
	private String description;
	@JsonProperty("rating")
	private Integer rating;
	@JsonProperty("size")
	private String size;
	@JsonProperty("stock")
	private Integer stock;
	@JsonProperty("sold")
	private Integer sold;
	@JsonProperty("product_refs")
	private List<ProductRefDTO> productRefs = null;

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
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

	@JsonProperty("picture")
	public List<String> getPicture() {
		return picture;
	}

	@JsonProperty("picture")
	public void setPicture(List<String> picture) {
		this.picture = picture;
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
	public Integer getCostPrice() {
		return costPrice;
	}

	@JsonProperty("cost_price")
	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}

	@JsonProperty("discount")
	public Integer getDiscount() {
		return discount;
	}

	@JsonProperty("discount")
	public void setDiscount(Integer discount) {
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

	@JsonProperty("size")
	public String getSize() {
		return size;
	}

	@JsonProperty("size")
	public void setSize(String size) {
		this.size = size;
	}

	@JsonProperty("stock")
	public Integer getStock() {
		return stock;
	}

	@JsonProperty("stock")
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@JsonProperty("sold")
	public Integer getSold() {
		return sold;
	}

	@JsonProperty("sold")
	public void setSold(Integer sold) {
		this.sold = sold;
	}

	@JsonProperty("product_refs")
	public List<ProductRefDTO> getProductRefs() {
		return productRefs;
	}

	@JsonProperty("product_refs")
	public void setProductRefs(List<ProductRefDTO> productRefs) {
		this.productRefs = productRefs;
	}
}