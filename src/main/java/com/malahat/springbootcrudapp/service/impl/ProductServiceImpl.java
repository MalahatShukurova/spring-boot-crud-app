package com.malahat.springbootcrudapp.service.impl;

import com.malahat.springbootcrudapp.dto.ProductDto;
import com.malahat.springbootcrudapp.exception.ResourceNotFoundException;
import com.malahat.springbootcrudapp.mapper.ProductMapper;
import com.malahat.springbootcrudapp.model.Customer;
import com.malahat.springbootcrudapp.model.Product;
import com.malahat.springbootcrudapp.repository.ProductRepository;
import com.malahat.springbootcrudapp.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private ProductMapper productMapper;


    @Override
    public ProductDto getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","id",id));
        return productMapper.mapToProductDTO(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::mapToProductDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDto createProduct(ProductDto productDTO) {
        Product product = productMapper.mapToProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToProductDTO(savedProduct);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDTO) {

         Optional<Product> product = productRepository.findById(productDTO.getId());

         if (product.isPresent()) {
             Product productUpdate = product.get();
             productUpdate.setId(productDTO.getId());
             productUpdate.setName(productDTO.getName());
             productUpdate.setPrice(productDTO.getPrice());
             productRepository.save(productUpdate);
             return productMapper.mapToProductDTO(productUpdate);
         }
         else {
             throw new ResourceNotFoundException("Product", "id", productDTO);
         }
    }

    @Override
    public void deleteProduct(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            productRepository.delete(product.get());
        } else {
            throw new ResourceNotFoundException("product");
        }

    }

    @Override
    public Customer buyProduct(Long productId) {
        Optional<Product> product = productRepository.findById(productId);


        return null;
    }

}
