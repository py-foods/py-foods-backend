package com.py.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.py.dto.api.ProductDTO;
import com.py.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Optional<Product> findById(long id);

	Page<Product> findByCategory(long code, Pageable pageable);

	Optional<ProductDTO> findProductDetailById(long id, Pageable pageable);

	Page<ProductDTO> productList(Long categoryId, Integer page, Integer size, String field, Boolean isDesc);
}
