package com.malahat.springbootcrudapp.controller;


import com.malahat.springbootcrudapp.dto.CustomerDTO;
import com.malahat.springbootcrudapp.service.CustomerService;
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
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok().body(customerServiceImpl.getAllCustomers());
    }

    @GetMapping("/id")
    public ResponseEntity<CustomerDTO> getCustomer(@RequestParam("id") long customerId) {
        return ResponseEntity.ok().body(customerServiceImpl.getOneCustomer(customerId));
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(this.customerServiceImpl.createCustomer(customerDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable long customerId, @RequestBody CustomerDTO customer){
        customer.setId(customerId);
        return ResponseEntity.ok().body(this.customerServiceImpl.updateCustomer(customer));
    }

    @DeleteMapping("/{customerId}")
    public HttpStatus deleteCustomer(@PathVariable long customerId){
        this.customerServiceImpl.deleteCustomer(customerId);
        return HttpStatus.OK;
    }



}
