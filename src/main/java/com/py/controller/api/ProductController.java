package com.py.controller.api;

import static com.py.constant.Constant.PRODUCTS_ON_CATEGORY_SIZE;
import static com.py.constant.Constant.PRODUCTS_ON_REFERENCE_SIZE;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.py.constant.Constant;
import com.py.dto.api.FavouriteDTO;
import com.py.dto.api.ProductDTO;
import com.py.dto.api.ProductOnCategoryDTO;
import com.py.dto.mapper.PageMapper;
import com.py.dto.mapper.ProductMapper;
import com.py.entity.Category;
import com.py.entity.Product;
import com.py.exception.EntityNotFoundException;
import com.py.service.ICategoryService;
import com.py.service.IProductService;

@RestController
@RequestMapping(path = "api/products")
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private PageMapper pageMapper;
	
	/**
	 * 
	 * @param productId
	 * @return
	 * @throws BadRequestException
	 * @throws ResourceNotFoundException
	 * @throws BussinessException
	 */
	@GetMapping(path = "{id}")
	public ProductDTO getProduct(@PathVariable Long id) {
		
		Product product = productService.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(Product.class, "id", String.valueOf(id)));

		ProductDTO productDto = productMapper.toDto(product, Constant.ITEMS_SOLD);
		// Finding reference product for current product		
		Long pId = product.getId();
		Long ctgId = product.getCategory().getId();
		PageRequest pageRequest = PageRequest.of(0, PRODUCTS_ON_REFERENCE_SIZE);
		List<Product> productList = productService.findReferByCategoryId(pId, ctgId, pageRequest);
		
		List<ProductDTO> productRefers = new ArrayList<>();
		productList.forEach(v -> productRefers.add(productMapper.toDto(v, Constant.ITEMS_SOLD)));
		productDto.setProductRefs(productRefers);
		// build response data
		return productDto;
	}

	/**
	 * 
	 * @param page
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws BussinessException
	 */
	@GetMapping(path = "favourite")
	public FavouriteDTO getFavouriteProducts(
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "8") Integer size) {
		
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Product> productPage = productService.findFavouriteProducts(pageRequest);
		FavouriteDTO favouriteDTO = new FavouriteDTO();
		List<ProductDTO> favourites = new ArrayList<>();		
		productPage.getContent().forEach(v -> favourites.add(productMapper.toDto(v, Constant.ITEMS_SOLD)));
		favouriteDTO.setProducts(favourites);
		// build response data
		favouriteDTO.setPage(pageMapper.toDto(productPage));
		return favouriteDTO;
	}

	/**
	 * 
	 * @param page
	 * @return
	 */
	@GetMapping(path = "index")
	public List<ProductOnCategoryDTO> getIndexProducts(
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "4") Integer size,
			@RequestParam(required = false) String sort) {

		Direction direction = "asc".equals(sort) ? Sort.Direction.ASC : Sort.Direction.DESC;
		PageRequest pageRequest = PageRequest.of(page, size, direction, "createdDate");
		Page<Category> categoryPage = categoryService.findAll(pageRequest);

		List<ProductOnCategoryDTO> products = new ArrayList<>();
		categoryPage.getContent().forEach(v -> {
			ProductOnCategoryDTO product = new ProductOnCategoryDTO();
			product.setCategoryId(v.getId());
			product.setCategoryName(v.getName());
			// hard code as 8 products per category
			Page<Product> productPage = productService.findByCategoryId(v.getId(),
					PageRequest.of(0, PRODUCTS_ON_CATEGORY_SIZE));
			product.setProducts(productMapper.toList(productPage.getContent()));
			products.add(product);
		});
		// build response data
		return products;
	}

	/**
	 * 
	 * @param category
	 * @param page
	 * @return
	 */
	@GetMapping
	public ProductOnCategoryDTO getListProductByCategory(
			@RequestParam(required = true) Long category,
			@RequestParam(required = true) String sort,
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "8") Integer size) {
		
		Direction direction = "asc".equals(sort) ? Sort.Direction.ASC : Sort.Direction.DESC;
		PageRequest pageRequest = PageRequest.of(page, size, direction, "created_date");
		Page<Product> productPage = productService.findByCategoryId(category, pageRequest);
		
		ProductOnCategoryDTO productOnCategory = new ProductOnCategoryDTO();
		productOnCategory.setPage(pageMapper.toDto(productPage));
		productOnCategory.setProducts(productMapper.toList(productPage.getContent()));
		return productOnCategory;
	}
	
	@PostMapping(path = "submit")
	public void submit(@RequestBody @Valid ProductDTO product) {
		System.out.println(product.getCode());
	}
}
