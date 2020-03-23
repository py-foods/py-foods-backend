package com.py.dto.mapper;

import com.py.dto.api.ProductDTO;
import com.py.entity.Product;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

/**
 * @author vmdat
 * @create 23/03/2020
 */
@Mapper(componentModel = "spring")
@Named("ProductMapper")
public abstract class ProductMapper {

    @Named("ToProductDTO")
    public abstract ProductDTO toDTO (Product component);

    @IterableMapping(qualifiedByName = "ToProductDTO")
    @Named("ToProductDTOs")
    public abstract List<ProductDTO> toDTOs(List<Product> components);

}
