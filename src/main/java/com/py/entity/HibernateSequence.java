package com.py.entity;
// Generated May 4, 2020 10:14:57 PM by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate_sequence")
public class HibernateSequence implements java.io.Serializable {

	private static final long serialVersionUID = -4106091606575841441L;
	
	private Long nextVal;

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "next_val")
	public Long getNextVal() {
		return this.nextVal;
	}

	public void setNextVal(Long nextVal) {
		this.nextVal = nextVal;
	}

}
