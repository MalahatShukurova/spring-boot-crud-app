package com.malahat.springbootcrudapp.controller;

import com.malahat.springbootcrudapp.model.Product;
import com.malahat.springbootcrudapp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct (@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{productID}")
    public ResponseEntity<Product> updateProduct (@PathVariable long productID, @RequestBody Product product){
        product.setId(productID);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }

}
