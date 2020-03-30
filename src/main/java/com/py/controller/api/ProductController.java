package com.py.controller.api;

import static com.py.constant.Global.PRODUCTS_ON_CATEGORY_SIZE;
import static com.py.constant.Global.PRODUCTS_ON_REFERENCE_SIZE;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.py.constant.Status;
import com.py.constant.UrlConfig;
import com.py.dto.api.FavouriteDTO;
import com.py.dto.api.ProductByCategoryDTO;
import com.py.dto.api.ProductDTO;
import com.py.exception.BadRequestException;
import com.py.exception.ResourceNotFoundException;
import com.py.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * 
	 * @param productId
	 * @return
	 */
	@GetMapping(path = "{id}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable(value = "id") Optional<Long> productId) {

		if (!productId.isPresent()) {
			log.error("product id {} is not present", productId);
			throw new BadRequestException("productId is not present!!!");
		}
		Optional<ProductDTO> productOpt = productService.findProductDetailById(productId.get(),
				PageRequest.of(0, PRODUCTS_ON_REFERENCE_SIZE));
		if (!productOpt.isPresent()) {
			throw new ResourceNotFoundException("product not found!!!");
		}
		ProductDTO productDTO = productOpt.get();
		productDTO.setStatus(Status.OK);
		return ResponseEntity.ok(productDTO);
	}

	/**
	 * 
	 * @param page
	 * @return
	 */
	@GetMapping(path = "favourite")
	public ResponseEntity<FavouriteDTO> getFavouriteProducts(@RequestParam(value = "page") Optional<Integer> page) {

		PageRequest pageRequest = PageRequest.of(page.orElse(0), PRODUCTS_ON_CATEGORY_SIZE);
		Optional<FavouriteDTO> favouriteOpt = productService.findFavouriteProducts(pageRequest);
		if (!favouriteOpt.isPresent()) {
			throw new ResourceNotFoundException("product not found!!!");
		}
		FavouriteDTO favouriteDto = favouriteOpt.get();
		favouriteDto.setStatus(Status.OK);
		return ResponseEntity.ok(favouriteDto);
	}

	/**
	 * 
	 * @param page
	 * @return
	 */
	@GetMapping(path = "")
	public ResponseEntity<ProductByCategoryDTO> getMainProducts(@RequestParam(value = "page") Optional<Integer> page) {

		PageRequest pageRequest = PageRequest.of(page.orElse(0), PRODUCTS_ON_CATEGORY_SIZE);
		Optional<ProductByCategoryDTO> productOpt = productService.findByCategory(pageRequest);
		if (!productOpt.isPresent()) {
			throw new ResourceNotFoundException("product not found!!!");
		}
		ProductByCategoryDTO productDto = productOpt.get();
		productDto.setStatus(Status.OK);
		return ResponseEntity.ok(productDto);
	}

	/**
	 * 
	 * @param category
	 * @param page
	 * @return
	 */
	@GetMapping(UrlConfig.LIST + UrlConfig.PRODUCT)
	public Page<ProductDTO> getListProduct(@RequestParam("category") String category,
			@RequestParam(required = false) Integer page) {
		return null;
	}
}
