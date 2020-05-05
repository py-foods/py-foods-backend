package com.py.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "category")
@EqualsAndHashCode(callSuper = false)
public class Category extends BaseEntity {

	private static final long serialVersionUID = -2856074491878061012L;
	
	private String code;
	private String name;
	private String description;
	private String parentCode;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private List<Product> products = new ArrayList<>(0);
}
