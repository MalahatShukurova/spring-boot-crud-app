package com.malahat.springbootcrudapp.service;


import com.malahat.springbootcrudapp.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getOneCustomer(Long id);

    List<Customer> getAllCustomers();

    Customer createCustomer(Customer customer);
    Customer updateCustomer (Customer customer);

    void deleteCustomer(Long customerId);


}
