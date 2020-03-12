package com.py.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.py.entity.Product;
import com.py.repository.ProductRepository;
import com.py.service.IProductService;

@Service
public class ProductImpl implements IProductService {

	 @Autowired
	 private ProductRepository productRepository;

	@Override
	public List<Product> findByName(String name) {
		 return productRepository.findAll();
	}

}
