package com.malahat.springbootcrudapp.controller;

import com.malahat.springbootcrudapp.entity.Customer;
import com.malahat.springbootcrudapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getOneCustomer(@PathVariable long customerId) {
        return ResponseEntity.ok().body(customerService.getOneCustomer(customerId));
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok().body(this.customerService.createCustomer(customer));
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
