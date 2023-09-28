package com.malahat.springbootcrudapp.service.impl;


import com.malahat.springbootcrudapp.dto.CustomerDTO;
import com.malahat.springbootcrudapp.exception.ResourceNotFoundException;
import com.malahat.springbootcrudapp.mapper.CustomerMapper;
import com.malahat.springbootcrudapp.model.Customer;
import com.malahat.springbootcrudapp.repository.CustomerRepository;
import com.malahat.springbootcrudapp.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO getOneCustomer(Long id) {
        Customer customer = this.customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        return this.customerMapper.mapToCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream().map(customerMapper::mapToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {

        Customer customer = this.customerMapper.mapToCustomer(customerDTO);

        Customer savedCustomer = this.customerRepository.save(customer);

        return this.customerMapper.mapToCustomerDTO(savedCustomer);

    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customer) {
        Optional<Customer> customerDb = this.customerRepository.findById(customer.getId());

        if (customerDb.isPresent()) {
            Customer customerUpdate = customerDb.get();
            customerUpdate.setId(customer.getId());
            customerUpdate.setName(customer.getName());
            customerUpdate.setSurname(customer.getSurname());
            customerUpdate.setAddress(customer.getAddress());
            customerUpdate.setAge(customer.getAge());
            customerUpdate.setNumber(customer.getNumber());
            this.customerRepository.save(customerUpdate);
            return customerMapper.mapToCustomerDTO(customerUpdate);
        } else {
            throw new ResourceNotFoundException("Customer", "id", customer);
        }

    }

    @Override
    public void deleteCustomer(Long customerId) {
        Optional<Customer> customerDb = this.customerRepository.findById(customerId);
        if (customerDb.isPresent()) {
            this.customerRepository.delete(customerDb.get());
        } else {
            throw new ResourceNotFoundException("Customer", "id", customerId);
        }

    }
}
