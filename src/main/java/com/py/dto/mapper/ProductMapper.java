
package com.py.dto.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.py.config.AppConfig;
import com.py.dto.api.ProductDTO;
import com.py.entity.Product;
import com.py.util.PriceUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductMapper {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AppConfig appConfig;

	public ProductDTO toDto(Product source, int sold) {
		
		ProductDTO targetDto = modelMapper.map(source, ProductDTO.class);
		
		targetDto.setSold(sold); // hard code here
		Float discount = source.getDiscount();
		BigDecimal price = source.getCostPrice();
		String discountType = source.getDiscountType();
		BigDecimal salePrice = PriceUtils.getSalePrice(price, discountType, discount);
		targetDto.setSalePrice(salePrice);
		targetDto.setThumbnail(appConfig.getPictureURL(source.getThumbnail()));
		// filter only picture URLs
		List<String> pictureURLs = source.getPictures()
				.stream().map(v -> appConfig.getPictureURL(v.getName()))
				.collect(Collectors.toList());
		targetDto.setPictureURLs(pictureURLs);
		
		log.debug("price: {} - sale price: {} - type: {} - discount: {}", price, salePrice, discountType, discount);
		return targetDto;
	}

	public List<ProductDTO> toList(List<Product> sources) {
		List<ProductDTO> targets = new ArrayList<>();
		sources.forEach(v -> targets.add(toDto(v, 4)));
		return targets;
	}
}
