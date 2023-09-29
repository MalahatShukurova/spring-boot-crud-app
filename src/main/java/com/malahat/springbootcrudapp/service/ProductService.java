package com.malahat.springbootcrudapp.service;

import com.malahat.springbootcrudapp.model.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(Long id);

    List <Product> getAllProducts();

    Product createProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Long id);
    }

