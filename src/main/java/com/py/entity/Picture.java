package com.py.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "picture")
public class Picture extends BaseEntity {

	private String filename;
	private String productCode;
	private Boolean isActive;

}
