package com.py.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "supplier")
@EqualsAndHashCode(callSuper = false)
public class Supplier extends BaseEntity {

	private static final long serialVersionUID = -6712683592180650770L;
	
	private String code;
	private String name;
	private String address;
	private String city;
	private String email;
	private String phone;
	private String payment;
	private Boolean isActive;
}
