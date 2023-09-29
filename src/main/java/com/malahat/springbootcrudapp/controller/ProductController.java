package com.malahat.springbootcrudapp.controller;

import com.malahat.springbootcrudapp.model.Product;
import com.malahat.springbootcrudapp.service.ProductService;
import com.malahat.springbootcrudapp.service.impl.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<List<Product>>getAllProducts(){
        return ResponseEntity.ok().body(productServiceImpl.getAllProducts());
    }

    @GetMapping("/id")
    public ResponseEntity<Product>getProduct(@RequestParam("id") long productId){
        return ResponseEntity.ok().body(productServiceImpl.getProduct(productId));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct (@RequestBody Product product){
        return new ResponseEntity<>(productServiceImpl.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{productID}")
    public ResponseEntity<Product> updateProduct (@PathVariable long productID, @RequestBody Product product){
        product.setId(productID);
        return ResponseEntity.ok().body(this.productServiceImpl.updateProduct(product));
    }

    @DeleteMapping("{id}")
    public HttpStatus deleteProduct(@RequestParam("id") long id){
        this.productServiceImpl.deleteProduct(id);
        return HttpStatus.OK;
    }

}
