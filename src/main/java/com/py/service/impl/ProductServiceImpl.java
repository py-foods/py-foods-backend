package com.py.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//import com.py.dto.mapper.ProductMapper;
//import com.py.util.AppUtils;
import com.py.exception.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.py.constant.GlobalConstant;
import com.py.dto.PageDTO;
import com.py.dto.api.FavouriteDTO;
import com.py.dto.api.ProductDTO;
import com.py.entity.Picture;
import com.py.entity.Product;
import com.py.repository.PictureRepository;
import com.py.repository.ProductRepository;
import com.py.service.ProductService;
import com.py.util.Arith;
import com.py.util.PriceUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PictureRepository pictureRepository;

	@Autowired
	private ModelMapper modelMapper;

//	@Autowired
//	private AppUtils appUtils;

//	@Autowired
//	private ProductMapper productMapper;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Page<Product> findByCategory(Long code, Pageable pageable) {
		Product product = new Product();
		product.setCategoryId(code);
		return productRepository.findAll(Example.of(product), pageable);
	}

	@Override
	public Optional<ProductDTO> findProductDetailById(Long id, Pageable pageable) {
		
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
		List<Product> productList = productRepository.findReferByCategoryId(product.getId(), product.getCategoryId(),
				pageable);
		List<ProductDTO> productDTOList = new ArrayList<>();
		productList.forEach(v -> productDTOList.add(buildDTO(v, 5)));
		productDTO.setProductRefs(productDTOList);
		return Optional.of(productDTO);
	}

	@Override
	public Page<ProductDTO> productList(Long categoryId, Integer page, Integer size, String field, Boolean isDesc) {
		if (categoryId == null) {
			throw new BadRequestException("Category is null"); // for test ... will be remove in feature
		}
		//return productRepository.findAllByCategoryId(categoryId, appUtils.getPageable(page, size, null, null)).map(productMapper::toDTO);
		return null;
	}
	
	@Override
	public Optional<FavouriteDTO> findFavouriteProducts(Pageable pageable) {

		Page<Product> pageData = productRepository.findByRating(GlobalConstant.FAVOURITE_STAR, pageable);
		if (CollectionUtils.isEmpty(pageData.getContent())) {
			return Optional.empty();
		}
		FavouriteDTO favouriteDTO = new FavouriteDTO();
		PageDTO page = modelMapper.map(pageData, PageDTO.class);
		favouriteDTO.setPage(page);
		List<ProductDTO> productDTOList = new ArrayList<>();
		pageData.getContent().forEach(v -> productDTOList.add(buildDTO(v, 5)));
		favouriteDTO.setProducts(productDTOList);
		return Optional.ofNullable(favouriteDTO);
	}

	private ProductDTO buildDTO(Product product, int sold) {
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		productDTO.setSold(sold); // hard code here
		Float discount = product.getDiscount();
		BigDecimal price = product.getCostPrice();
		String discountType = product.getDiscountType();
		BigDecimal salePrice = PriceUtil.getSalePrice(price, discountType, discount);
		productDTO.setSalePrice(salePrice);
		log.debug("price: {} - sale price: {} - type: {} - discount: {}", price, salePrice, discountType, discount);
		return productDTO;
	}

	public static void main(String[] args) {
		System.out.println(Arith.div(23, 100F, 2));
	}
}
