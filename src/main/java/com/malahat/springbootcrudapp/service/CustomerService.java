package com.malahat.springbootcrudapp.service;


import com.malahat.springbootcrudapp.dto.CustomerDTO;
import com.malahat.springbootcrudapp.model.Customer;

import java.util.List;

public interface CustomerService {

    CustomerDTO getOneCustomer(Long id);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer (CustomerDTO customer);

    void deleteCustomer(Long customerId);


}
