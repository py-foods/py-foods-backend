package com.py.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.py.constant.Global;
import com.py.dto.api.FavouriteDTO;
import com.py.dto.api.ProductDTO;
import com.py.dto.api.ProductOnCategoryDTO;
import com.py.dto.mapper.PageMapper;
import com.py.dto.mapper.ProductMapper;
import com.py.entity.Category;
import com.py.entity.Picture;
import com.py.entity.Product;
import com.py.exception.BadRequestException;
import com.py.exception.BussinessException;
import com.py.exception.ResourceNotFoundException;
import com.py.repository.CategoryRepository;
import com.py.repository.PictureRepository;
import com.py.repository.ProductRepository;
import com.py.service.IProductService;
import com.py.util.Arith;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PictureRepository pictureRepository;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private PageMapper pageMapper;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Optional<ProductDTO> findProductDetailById(Long id, Pageable pageable) {

		Optional<Product> productOpt = productRepository.findById(id);
		if (!productOpt.isPresent()) {
			throw new ResourceNotFoundException("product not found!");
		}
		ProductDTO productDTO = null;
		try {
			Product product = productOpt.get();
			productDTO = productMapper.toDto(product, 10);
			// Get pictures for product
			List<Picture> pictures = pictureRepository.findByProductId(product.getId());
			productDTO.setPictures(pictures.stream().map(Picture::getName).collect(Collectors.toList()));

			// Finding reference product for current product
			Long pId = product.getId();
			Long ctgId = product.getCategory().getId();
			List<Product> productList = productRepository.findReferByCategoryId(pId, ctgId, pageable);
			List<ProductDTO> productDTOList = new ArrayList<>();
			productList.forEach(v -> productDTOList.add(productMapper.toDto(v, 5)));
			productDTO.setProductRefs(productDTOList);
		} catch (Exception e) {
			log.error("findProductDetailById ERROR: ", e);
			throw new BussinessException(e.getMessage());
		}
		return Optional.of(productDTO);
	}

	@Override
	public Page<ProductDTO> productList(Long categoryId, Integer page, Integer size, String field, Boolean isDesc) {
		if (categoryId == null) {
			throw new BadRequestException("Category is null"); // for test ... will be remove in feature
		}
		// return productRepository.findAllByCategoryId(categoryId,
		// appUtils.getPageable(page, size, null, null)).map(productMapper::toDTO);
		return null;
	}

	@Override
	public Optional<FavouriteDTO> findFavouriteProducts(Pageable pageable) {

		Page<Product> productPage = productRepository.findByRating(Global.FAVOURITE_STAR, pageable);
		if (productPage.isEmpty()) {
			throw new ResourceNotFoundException("favourite product not found!!!");
		}
		FavouriteDTO favouriteDTO = null;
		try {
			favouriteDTO = new FavouriteDTO();
			favouriteDTO.setPage(pageMapper.toDto(productPage));
			List<ProductDTO> dtoList = new ArrayList<>();
			productPage.getContent().forEach(v -> dtoList.add(productMapper.toDto(v, 5)));
			favouriteDTO.setProducts(dtoList);
		} catch (Exception e) {
			throw new BussinessException(e.getMessage());
		}
		return Optional.ofNullable(favouriteDTO);
	}

	@Override
	public List<ProductOnCategoryDTO> findProductsForIndex(Pageable pageable) {
		List<ProductOnCategoryDTO> products = new ArrayList<>();
		ProductOnCategoryDTO product = new ProductOnCategoryDTO();
		Page<Category> categoryList = categoryRepository.findAll(pageable);
		categoryList.forEach(v -> {
			product.setCategoryId(v.getId());
			product.setCategoryName(v.getName());
			Page<Product> productPage = productRepository.findAllByCategoryId(v.getId(), PageRequest.of(0, 8));
			product.setProducts(productMapper.toList(productPage.getContent()));
			products.add(product);
		});
		return products;
	}

	public static void main(String[] args) {
		System.out.println(Arith.div(23, 100F, 2));
	}
}
