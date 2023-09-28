package com.malahat.springbootcrudapp.service.impl;

import com.malahat.springbootcrudapp.exception.ResourceNotFoundException;
import com.malahat.springbootcrudapp.model.Product;
import com.malahat.springbootcrudapp.repository.CustomerRepository;
import com.malahat.springbootcrudapp.repository.ProductRepository;
import com.malahat.springbootcrudapp.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product getOneProduct(Long id) {
        return productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","id",id));
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {

            Product productUpdate = new Product();
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setPrice(product.getPrice());
            productRepository.save(product);
            return this.productRepository.findById(product.getId()).orElseThrow(()-> new ResourceNotFoundException("Product", "id", product));

    }

    @Override
    public void deleteProduct(Long id) {

    }
}
