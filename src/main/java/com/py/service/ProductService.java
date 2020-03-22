package com.py.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.py.dto.api.ProductDTO;
import com.py.entity.Product;

public interface ProductService {

	public List<Product> findAll();

	public Optional<Product> findById(long id);

	public Page<Product> findByCategory(long code, Pageable pageable);

	public Optional<ProductDTO> findProductDetailById(long id, Pageable pageable);
}
