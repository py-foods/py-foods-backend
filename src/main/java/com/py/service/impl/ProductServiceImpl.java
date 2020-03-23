package com.py.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.py.dto.mapper.ProductMapper;
import com.py.exception.BadRequestException;
import com.py.util.AppUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.py.dto.api.ProductDTO;
import com.py.entity.Picture;
import com.py.entity.Product;
import com.py.repository.PictureRepository;
import com.py.repository.ProductRepository;
import com.py.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PictureRepository pictureRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AppUtils appUtils;

	@Autowired
	private ProductMapper productMapper;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Optional<Product> findById(long id) {
		return productRepository.findById(id);
	}

	public Page<Product> findByCategory(long code, Pageable pageable) {
		Product product = new Product();
		product.setCategoryId(code);
		return productRepository.findAll(Example.of(product), pageable);
	}

	public Optional<ProductDTO> findProductDetailById(long id, Pageable pageable) {
		Optional<Product> productOpt = productRepository.findById(id);
		if (!productOpt.isPresent()) {
			return Optional.empty();
		}

		Product product = productOpt.get();
		ProductDTO productDTO = buildDTO(product, 10);
		// Get pictures for product
		List<Picture> pictures = pictureRepository.findByProductId(product.getId());
		productDTO.setPictures(pictures.stream().map(Picture::getName).collect(Collectors.toList()));

		// Finding reference product for current product
		List<Product> products = productRepository.findReferByCategoryId(product.getId(), product.getCategoryId(), pageable);
		List<ProductDTO> productDTOs = new ArrayList<>();
		products.forEach(v -> productDTOs.add(buildDTO(v, 5)));
		productDTO.setProductRefs(productDTOs);
		return Optional.of(productDTO);
	}

	@Override
	public Page<ProductDTO> productList(Long categoryId, Integer page, Integer size, String field, Boolean isDesc) {
		if (categoryId == null) {
			throw new BadRequestException("Category is null"); // for test ... will be remove in feature
		}
		return productRepository.findAllByCategoryId(categoryId, appUtils.getPageable(page, size, null, null)).map(productMapper::toDTO);
	}

	private ProductDTO buildDTO(Product product, int sold) {
		ProductDTO dto = modelMapper.map(product, ProductDTO.class);
		dto.setSalePrice(product.getCostPrice());
		dto.setSold(sold);
		return dto;
	}
}
