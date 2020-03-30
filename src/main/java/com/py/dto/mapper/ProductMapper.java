
package com.py.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.py.dto.api.ProductDTO;
import com.py.entity.Product;

@Component
public class ProductMapper {

	@Autowired
	private ModelMapper modelMapper;

	public ProductDTO toDto(Product product) {
		return modelMapper.map(product, ProductDTO.class);
	}

}
