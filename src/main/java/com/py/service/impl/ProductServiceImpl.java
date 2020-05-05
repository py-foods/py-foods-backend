package com.py.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.py.constant.Constant;
import com.py.dto.api.ProductDTO;
import com.py.dto.api.ProductOnCategoryDTO;
import com.py.dto.mapper.ProductMapper;
import com.py.entity.Category;
import com.py.entity.Product;
import com.py.repository.CategoryRepository;
import com.py.repository.ProductRepository;
import com.py.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductMapper productMapper;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<ProductDTO> search(String query, Long categoryId, Pageable pageable) {
		return null;
	}

	@Override
	public Page<Product> findFavouriteProducts(Pageable pageable) {
		return productRepository.findByRating(Constant.FAVOURITE_STAR, pageable);
	}

	@Override
	public List<ProductOnCategoryDTO> findProductsForIndex(Pageable pageable) {
		List<ProductOnCategoryDTO> products = new ArrayList<>();
		Page<Category> categoryList = categoryRepository.findAll(pageable);
		categoryList.forEach(v -> {
			ProductOnCategoryDTO product = new ProductOnCategoryDTO();
			product.setCategoryId(v.getId());
			product.setCategoryName(v.getName());
			// hard code as 8 products per category
			Page<Product> productPage = productRepository.findAllByCategoryId(v.getId(), PageRequest.of(0, 8));
			product.setProducts(productMapper.toList(productPage.getContent()));
			products.add(product);
		});
		return products;
	}

	@Override
	public Page<Product> findByCategoryId(Long id, Pageable pageable) {
		return productRepository.findAllByCategoryId(id, pageable);
	}

	@Override
	public List<Product> findReferByCategoryId(Long id, Long categoryId, Pageable pageable) {
		return productRepository.findReferByCategoryId(id, categoryId, pageable);
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}
}
