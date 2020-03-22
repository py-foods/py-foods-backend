package com.py.entity;

import javax.persistence.Entity;

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
}
