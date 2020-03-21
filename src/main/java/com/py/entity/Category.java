package com.py.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "category")
public class Category extends BaseEntity {

	private String code;
	private String name;
	private String description;
	private String parentCode;
	private Boolean isActive;

}
