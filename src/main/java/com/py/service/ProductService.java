package com.py.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.py.entity.Product;
import com.py.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	public List<Product> findReferenceByCode(String code) {
		Product product = new Product();
		product.setProductRef(code);
		Example<Product> exp = Example.of(product);
		return productRepository.findAll(exp);
	}
}
