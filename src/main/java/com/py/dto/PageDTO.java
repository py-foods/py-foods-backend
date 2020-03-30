package com.py.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDTO implements Serializable {

	private static final long serialVersionUID = -573287585899631407L;

	private int size;
	private int offset;
	private int totalPages;
	private long totalElements;
	private boolean hasNext;
	private boolean hasPrevious;
}
