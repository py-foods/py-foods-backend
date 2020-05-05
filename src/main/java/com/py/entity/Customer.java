package com.py.entity;

import java.sql.Date;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "customer")
@EqualsAndHashCode(callSuper = false)
public class Customer extends BaseEntity {

	private static final long serialVersionUID = 8676410032529355435L;
	
	private String code;
	private String firstname;
	private String lastname;
	private Date birthDate;
	private String phone;
	private String address1;
	private String address2;
	private String building;
	private String city;
	private String country;
	private String email;
	private String creditCard;
	private boolean isActive;
}
