package com.py.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.py.dto.api.FavouriteDTO;
import com.py.dto.api.ProductByCategoryDTO;
import com.py.dto.api.ProductDTO;
import com.py.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Optional<Product> findById(Long id);

	Optional<ProductDTO> findProductDetailById(Long id, Pageable pageable);

	/**
	 * Find all products with rating > 4
	 * 
	 * @param pageable
	 * @return
	 */
	Optional<FavouriteDTO> findFavouriteProducts(Pageable pageable);

	Optional<ProductByCategoryDTO> findByCategory(Pageable pageable);
	
	Page<ProductDTO> productList(Long categoryId, Integer page, Integer size, String field, Boolean isDesc);
}
