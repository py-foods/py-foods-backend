package com.py.service;

import java.util.List;

import com.py.entity.Product;

public interface IProductService {

	public List<Product> findByName(String name);
}
