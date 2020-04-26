package com.py.controller.api;

import static com.py.constant.Global.PRODUCTS_ON_CATEGORY_SIZE;
import static com.py.constant.Global.PRODUCTS_ON_REFERENCE_SIZE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.py.constant.Status;
import com.py.constant.UrlConfig;
import com.py.dto.api.FavouriteDTO;
import com.py.dto.api.ProductDTO;
import com.py.dto.api.ProductOnCategoryDTO;
import com.py.exception.BadRequestException;
import com.py.exception.BussinessException;
import com.py.exception.ResourceNotFoundException;
import com.py.service.IProductService;

@RestController
@RequestMapping(path = "api/products")
public class ProductController {

	@Autowired
	private IProductService productService;

	/**
	 * 
	 * @param productId
	 * @return
	 * @throws BadRequestException
	 * @throws ResourceNotFoundException
	 * @throws BussinessException
	 */
	@GetMapping(path = "{id}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable Optional<Long> id) {

		if (!id.isPresent()) {
			throw new BadRequestException("productId is not present!!!");
		}
		Pageable pageable = PageRequest.of(0, PRODUCTS_ON_REFERENCE_SIZE);
		Optional<ProductDTO> productOpt = productService.findProductDetailById(id.get(), pageable);
		ProductDTO productDTO = productOpt.get();
		productDTO.setStatus(Status.OK);
		return ResponseEntity.ok(productDTO);
	}

	/**
	 * 
	 * @param page
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws BussinessException
	 */
	@GetMapping(path = "favourite")
	public ResponseEntity<FavouriteDTO> getFavouriteProducts(@RequestParam(value = "page") Optional<Integer> page) {
		PageRequest pageRequest = PageRequest.of(page.orElse(0), PRODUCTS_ON_CATEGORY_SIZE);
		Optional<FavouriteDTO> favouriteOpt = productService.findFavouriteProducts(pageRequest);
		FavouriteDTO favouriteDto = favouriteOpt.get();
		favouriteDto.setStatus(Status.OK);
		return ResponseEntity.ok(favouriteDto);
	}

	/**
	 * 
	 * @param page
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<ProductOnCategoryDTO>> getProducts() {
		Pageable pageable = PageRequest.of(0, 4, Sort.Direction.DESC, "createdDate");
		List<ProductOnCategoryDTO> products = productService.findProductsForIndex(pageable);
		return ResponseEntity.ok(products);

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
