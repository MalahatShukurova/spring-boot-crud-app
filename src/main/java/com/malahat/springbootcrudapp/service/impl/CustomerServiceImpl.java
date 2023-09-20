package com.malahat.springbootcrudapp.service.impl;


import com.malahat.springbootcrudapp.model.Customer;
import com.malahat.springbootcrudapp.exception.ResourceNotFoundException;
import com.malahat.springbootcrudapp.repository.CustomerRepository;
import com.malahat.springbootcrudapp.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository){
        super();
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getOneCustomer(Long id) {

//        Optional <Customer> customerDb = this.customerRepository.findById(id);
//
//        if (customerDb.isPresent()){
//            return customerDb.get();
//        } else {
//            throw new ResourceNotFoundException("Customer","id",id);
//        }

        return customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer","id",id));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();

    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Optional<Customer> customerDb = this.customerRepository.findById(customer.getId());

        if(customerDb.isPresent()){
            Customer customerUpdate = customerDb.get();
            customerUpdate.setId(customer.getId());
            customerUpdate.setName(customer.getName());
            customerUpdate.setSurname(customer.getSurname());
            customerUpdate.setAddress(customer.getAddress());
            customerUpdate.setAge(customer.getAge());
            customerUpdate.setNumber(customer.getNumber());
            customerRepository.save(customerUpdate);
            return customerUpdate;
        } else {
            throw new ResourceNotFoundException("Customer","id",customer);
        }

    }

    @Override
    public void deleteCustomer(Long customerId) {
        Optional <Customer> customerDb = this.customerRepository.findById(customerId);
        if (customerDb.isPresent()){
            this.customerRepository.delete(customerDb.get());
        } else {
            throw new ResourceNotFoundException("Customer","id",customerId);
        }

    }
}
