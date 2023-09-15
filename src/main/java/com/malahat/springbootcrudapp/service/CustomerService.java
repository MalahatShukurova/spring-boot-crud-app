package com.malahat.springbootcrudapp.service;

import com.malahat.springbootcrudapp.entity.Customer;
import com.malahat.springbootcrudapp.repository.CustomerRepository;

import java.util.List;

public interface CustomerService {

    Customer getOneCustomer(Long customerId);

    List<Customer> getAllCustomers();

    Customer createCustomer(Customer customer);
    Customer updateCustomer (Customer customer);

    void deleteCustomer(Long customerId);


}
