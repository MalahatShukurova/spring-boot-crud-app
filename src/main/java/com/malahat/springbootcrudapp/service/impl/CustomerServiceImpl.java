package com.malahat.springbootcrudapp.service.impl;


import com.malahat.springbootcrudapp.dto.CustomerDto;
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
    public CustomerDto getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        return customerMapper.mapToCustomerDTO(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customerMapper::mapToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDTO) {

        Customer customer = customerMapper.mapToCustomer(customerDTO);

        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.mapToCustomerDTO(savedCustomer);

    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDTO) {
        Optional<Customer> customer = customerRepository.findById(customerDTO.getId());

        if (customer.isPresent()) {
            Customer customerUpdate = customer.get();
            customerUpdate.setId(customerDTO.getId());
            customerUpdate.setName(customerDTO.getName());
            customerUpdate.setSurname(customerDTO.getSurname());
            customerUpdate.setAddress(customerDTO.getAddress());
            customerUpdate.setAge(customerDTO.getAge());
            customerUpdate.setNumber(customerDTO.getNumber());
            customerRepository.save(customerUpdate);
            return customerMapper.mapToCustomerDTO(customerUpdate);
        } else {
            throw new ResourceNotFoundException("Customer", "id", customerDTO);
        }

    }

    @Override
    public void deleteCustomer(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            customerRepository.delete(customer.get());
        } else {
            throw new ResourceNotFoundException("Customer", "id", customerId);
        }

    }

    @Override
    public Integer isCustomerPresent(Customer customer) {
        return null;
    }

//


}
