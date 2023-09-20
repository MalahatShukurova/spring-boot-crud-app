package com.malahat.springbootcrudapp.controller;


import com.malahat.springbootcrudapp.model.Customer;
import com.malahat.springbootcrudapp.service.CustomerService;
import liquibase.logging.mdc.CustomMdcObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    @GetMapping("/one")
    public ResponseEntity<Customer> getOneCustomer(@RequestParam("id") long customerId) {
        return ResponseEntity.ok().body(customerService.getOneCustomer(customerId));
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.createCustomer(customer),HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long customerId, @RequestBody Customer customer){
        customer.setId(customerId);
        return ResponseEntity.ok().body(this.customerService.updateCustomer(customer));
    }

    @DeleteMapping("/{customerId}")
    public HttpStatus deleteCustomer(@PathVariable long customerId){
        this.customerService.deleteCustomer(customerId);
        return HttpStatus.OK;
    }

}
