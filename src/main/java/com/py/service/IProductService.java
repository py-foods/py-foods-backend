package com.py.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.py.dto.api.ProductDTO;
import com.py.dto.api.ProductOnCategoryDTO;
import com.py.entity.Product;

public interface IProductService {

	Optional<Product> findById(Long id);
	
	List<Product> findAll();
	
	List<ProductDTO> search(String query, Long categoryId, Pageable pageable);
				
	List<Product> findReferByCategoryId(Long id, Long categoryId, Pageable pageable);
	
	/**
	 * Find all products with rating > 4
	 * 
	 * @param pageable
	 * @return
	 * @throws BussinessException
	 */
	Page<Product> findFavouriteProducts(Pageable pageable);

	List<ProductOnCategoryDTO> findProductsForIndex(Pageable pageable);
	
	Page<Product> findByCategoryId(Long id, Pageable pageable);
}
