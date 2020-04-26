package com.py.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.py.dto.api.FavouriteDTO;
import com.py.dto.api.ProductDTO;
import com.py.dto.api.ProductOnCategoryDTO;
import com.py.entity.Product;
import com.py.exception.BussinessException;

public interface IProductService {

	List<Product> findAll();

	ProductDTO findProductDetailById(Long id, Pageable pageable);

	/**
	 * Find all products with rating > 4
	 * 
	 * @param pageable
	 * @return
	 * @throws BussinessException
	 */
	FavouriteDTO findFavouriteProducts(Pageable pageable);

	List<ProductOnCategoryDTO> findProductsForIndex(Pageable pageable);

	Page<ProductDTO> productList(Long categoryId, Integer page, Integer size, String field, Boolean isDesc);
}
