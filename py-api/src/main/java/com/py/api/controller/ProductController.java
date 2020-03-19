package com.py.api.controller;

import java.util.ArrayList;
import java.util.List;

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
	public ResponseEntity<ResponseWrapper> getProduct(@RequestParam(value = "id", required = false) Integer id) {

		List<Product> products = productService.findAll();
		Product product = products.get(0);
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setSalePrice(product.getPrice());
		productDTO.setSize(product.getSize());
		productDTO.setRating(5);
		productDTO.setProductRefs(buidProductRef(product, 3));
		return ResponseEntity.ok(new ResponseWrapper(200, productDTO));
	}

	private List<ProductRefDTO> buidProductRef(Product product, int size) {

		List<ProductRefDTO> productDTORef = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			ProductRefDTO ref = new ProductRefDTO();
			ref.setName(product.getName() + (i + 1));
			ref.setSalePrice(product.getPrice());
			ref.setRating(i + 2);
			productDTORef.add(ref);
		}
		return productDTORef;
	}
}
