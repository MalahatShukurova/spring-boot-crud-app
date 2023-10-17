package com.malahat.springbootcrudapp.service;

import com.malahat.springbootcrudapp.dto.ProductDto;
import com.malahat.springbootcrudapp.model.Customer;

import java.util.List;

public interface ProductService {
    ProductDto getProduct(Long id);

    List <ProductDto> getAllProducts();

    ProductDto createProduct(ProductDto productDTO);

    ProductDto updateProduct(ProductDto productDTO);

    void deleteProduct(Long id);

    Customer buyProduct (Long id);
}



