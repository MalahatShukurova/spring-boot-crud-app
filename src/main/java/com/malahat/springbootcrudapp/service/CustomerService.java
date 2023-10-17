package com.malahat.springbootcrudapp.service;


import com.malahat.springbootcrudapp.dto.CustomerDto;
import com.malahat.springbootcrudapp.model.Customer;

import java.util.List;

public interface CustomerService {

    CustomerDto getCustomer(Long id);

    List<CustomerDto> getAllCustomers();

    CustomerDto createCustomer(CustomerDto customerDTO);
    CustomerDto updateCustomer (CustomerDto customer);

    void deleteCustomer(Long customerId);

    public Integer isCustomerPresent(Customer customer);




}
