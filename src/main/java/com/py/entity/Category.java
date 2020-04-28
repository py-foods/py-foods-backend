package com.py.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "category")
@EqualsAndHashCode(callSuper = false)
public class Category extends BaseEntity {

	private String code;
	private String name;
	private String description;
	private String parentCode;

	@OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<Product> products = new HashSet<>();
}
