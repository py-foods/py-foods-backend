package com.py.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "carts")
public class CartController {

	@GetMapping(path = "save")
	public ResponseEntity<Boolean> save() {
		return ResponseEntity.ok(true);
	}
}
