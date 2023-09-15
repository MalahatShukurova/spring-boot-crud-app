package com.malahat.springbootcrudapp.service;

import com.malahat.springbootcrudapp.entity.Customer;
import com.malahat.springbootcrudapp.exception.NotFoundException;
import com.malahat.springbootcrudapp.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getOneCustomer(Long customerId) {

        Optional <Customer> customerDb = this.customerRepository.findById(customerId);

        if (customerDb.isPresent()){
            return customerDb.get();
        } else {
            throw new NotFoundException("Record not found with id "+ customerId);
        }
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
            throw new NotFoundException("Record not found with id "+ customer.getId());
        }

    }

    @Override
    public void deleteCustomer(Long customerId) {
        Optional <Customer> customerDb = this.customerRepository.findById(customerId);
        if (customerDb.isPresent()){
            this.customerRepository.delete(customerDb.get());
        } else {
            throw new NotFoundException("Record not found with id "+ customerId);
        }

    }
}
