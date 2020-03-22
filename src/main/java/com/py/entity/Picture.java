package com.py.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author vmdat
 * @create 19/03/2020
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Picture extends BaseEntity {

	private String url;
	private String name;
	private Long productId;

}
