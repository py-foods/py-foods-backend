package com.py.controller.api;

import java.util.ArrayList;
import java.util.Optional;

import com.py.constant.UrlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.py.constant.GlobalConstant;
import com.py.dto.api.ProductDTO;
import com.py.dto.api.ResponseWrapper;
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
	public ResponseEntity<ResponseWrapper> getProduct(@PathVariable(value = "id") Long productId)
			throws Exception {

		if (productId == null) {
			log.error("product id {} is not present", productId);
			return ResponseEntity.badRequest().build();
		}

		Optional<ProductDTO> productDTO = productService.findProductDetailById(productId,
				PageRequest.of(0, GlobalConstant.PRODUCTS_ON_REFERENCE_SIZE));
		if (!productDTO.isPresent()) {
			throw new ResourceNotFoundException("product not found!!!");
		}
		return ResponseEntity.ok(new ResponseWrapper(true, productDTO.get()));
	}

	@GetMapping(UrlConfig.LIST + UrlConfig.PRODUCT)
	public Page<ProductDTO> getListProduct(@RequestParam("category") String category, @RequestParam(required = false) Integer page) {
		return null;
	}
}
