package com.py.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/booking")
public class BookingController {

	@PostMapping(path = "create")
	public ResponseEntity<Object> create(@RequestBody Object request) {
		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "cancel")
	public ResponseEntity<Object> cancel(@RequestBody Object request) {
		return ResponseEntity.ok().build();
	}
}
