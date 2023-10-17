package com.malahat.springbootcrudapp.mapper;

import com.malahat.springbootcrudapp.dto.ProductDto;
import com.malahat.springbootcrudapp.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto mapToProductDTO(Product product);

    @InheritInverseConfiguration
    Product mapToProduct(ProductDto productDTO);


}
