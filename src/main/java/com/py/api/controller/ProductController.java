package com.py.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.py.api.dto.ProductDTO;
import com.py.api.dto.ProductRefDTO;
import com.py.api.dto.ResponseWrapper;
import com.py.entity.Product;
import com.py.service.ProductService;

@RestController
@RequestMapping(path = "products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(path = "view", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseWrapper> getProduct(@RequestParam(value = "id", required = false) Long id) {

		Optional<Product> productOpt = productService.findById(id);
		if (!productOpt.isPresent()) {
			return ResponseEntity.badRequest().build();
		}

		Product product = productOpt.get();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setSalePrice(product.getPrice());
		productDTO.setSize(product.getSize());
		productDTO.setRating(5);

		List<Product> productRefs = productService.findReferenceByCode(product.getCode());
		List<ProductRefDTO> productRefDtos = new ArrayList<>();

		productRefs.forEach(v -> {
			ProductRefDTO refDto = new ProductRefDTO();
			refDto.setName(v.getName());
			refDto.setCurrency(v.getCurrency());
			refDto.setCostPrice(v.getPrice());
			refDto.setDiscountType(v.getDiscountType());
			productRefDtos.add(refDto);
		});
		productDTO.setProductRefs(productRefDtos);
		return ResponseEntity.ok(new ResponseWrapper(200, productDTO));
	}
}
