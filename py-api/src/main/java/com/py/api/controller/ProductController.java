package com.py.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.py.api.dto.ResponseWrapper;
import com.py.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping("/view")
	public ResponseEntity<ResponseWrapper> view() {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setCode(200);
		responseWrapper.setData(productService.findByName("C"));
		return ResponseEntity.ok(responseWrapper);
	}
}
