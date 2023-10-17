package com.malahat.springbootcrudapp.controller;


import com.malahat.springbootcrudapp.dto.CustomerDto;
import com.malahat.springbootcrudapp.service.impl.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;
    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl=customerServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok().body(customerServiceImpl.getAllCustomers());
    }

    @GetMapping("/id")
    public ResponseEntity<CustomerDto> getCustomer(@RequestParam("id") long customerId) {
        return ResponseEntity.ok().body(customerServiceImpl.getCustomer(customerId));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDTO){
        return new ResponseEntity<>(customerServiceImpl.createCustomer(customerDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable long customerId, @RequestBody CustomerDto customer){
        customer.setId(customerId);
        return ResponseEntity.ok().body(this.customerServiceImpl.updateCustomer(customer));
    }

    @DeleteMapping("/{customerId}")
    public HttpStatus deleteCustomer(@PathVariable long customerId){
        this.customerServiceImpl.deleteCustomer(customerId);
        return HttpStatus.OK;
    }



}
