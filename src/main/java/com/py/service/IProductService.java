package com.py.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.py.dto.api.FavouriteDTO;
import com.py.dto.api.ProductDTO;
import com.py.dto.api.ProductOnCategoryDTO;
import com.py.entity.Product;
import com.py.exception.BadRequestException;
import com.py.exception.BussinessException;
import com.py.exception.ResourceNotFoundException;

import javassist.NotFoundException;

public interface IProductService {

	List<Product> findAll();

	Optional<Product> findById(Long id);

	Optional<ProductDTO> findProductDetailById(Long id, Pageable pageable)
			throws ResourceNotFoundException, BussinessException;

	/**
	 * Find all products with rating > 4
	 * 
	 * @param pageable
	 * @return
	 * @throws BussinessException
	 * @throws NotFoundException
	 */
	Optional<FavouriteDTO> findFavouriteProducts(Pageable pageable)
			throws ResourceNotFoundException, BussinessException;

	List<ProductOnCategoryDTO> findProductsForIndex(Pageable pageable);

	Page<ProductDTO> productList(Long categoryId, Integer page, Integer size, String field, Boolean isDesc)
			throws BadRequestException;
}
