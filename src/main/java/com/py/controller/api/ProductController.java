package com.py.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.py.constant.GlobalConstant;
import com.py.constant.UrlConfig;
import com.py.dto.api.FavouriteDTO;
import com.py.dto.api.ProductDTO;
import com.py.dto.api.ResponseWrapper;
import com.py.exception.BadRequestException;
import com.py.exception.ResourceNotFoundException;
import com.py.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseWrapper> getProduct(@PathVariable(value = "id") Optional<Long> productId) {

		if (!productId.isPresent()) {
			log.error("product id {} is not present", productId);
			throw new BadRequestException("productId is not present!!!");
		}
		Optional<ProductDTO> productDTO = productService.findProductDetailById(productId.get(),
				PageRequest.of(0, GlobalConstant.PRODUCTS_ON_REFERENCE_SIZE));
		if (!productDTO.isPresent()) {
			throw new ResourceNotFoundException("product not found!!!");
		}
		return ResponseEntity.ok(new ResponseWrapper(true, productDTO.get()));
	}

	@GetMapping(path = "favourite", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseWrapper> getProducts(@RequestParam(value = "page") Optional<Integer> page) {

		PageRequest pageRequest = PageRequest.of(page.orElse(0), GlobalConstant.PRODUCTS_ON_CATEGORY_SIZE);
		Optional<FavouriteDTO> favouriteOpt = productService.findFavouriteProducts(pageRequest);
		if (!favouriteOpt.isPresent()) {
			throw new ResourceNotFoundException("product not found!!!");
		}
		return ResponseEntity.ok(new ResponseWrapper(true, favouriteOpt.get()));
	}

	@GetMapping(UrlConfig.LIST + UrlConfig.PRODUCT)
	public Page<ProductDTO> getListProduct(@RequestParam("category") String category,
			@RequestParam(required = false) Integer page) {
		return null;
	}
}
