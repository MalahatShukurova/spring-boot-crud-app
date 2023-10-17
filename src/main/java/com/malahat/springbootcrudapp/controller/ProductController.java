package com.malahat.springbootcrudapp.controller;

import com.malahat.springbootcrudapp.dto.ProductDto;
import com.malahat.springbootcrudapp.service.impl.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }


    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok().body(productServiceImpl.getAllProducts());
    }


    @GetMapping("/one")
    public ResponseEntity<ProductDto> getProduct (@RequestParam ("id") long productId){
        return ResponseEntity.ok().body(productServiceImpl.getProduct(productId));
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct (@RequestBody ProductDto productDTO){
        return new ResponseEntity<>(productServiceImpl.createProduct(productDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct (@PathVariable long productId, @RequestBody ProductDto product){
        product.setId(productId);
        return ResponseEntity.ok().body(productServiceImpl.updateProduct(product));
    }

    @DeleteMapping("/{productId}")
    public HttpStatus deleteProduct (@PathVariable long productId){
     this.productServiceImpl.deleteProduct(productId);
     return HttpStatus.OK;

    }


}
