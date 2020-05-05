package com.py.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "user")
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {

	private static final long serialVersionUID = 2690060625893934742L;
	
	private String username;
	private String password;
	private String type;
	private String session;
	private boolean isActive;
}
