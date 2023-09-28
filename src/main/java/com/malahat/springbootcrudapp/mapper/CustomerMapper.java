package com.malahat.springbootcrudapp.mapper;

import com.malahat.springbootcrudapp.dto.CustomerDTO;
import com.malahat.springbootcrudapp.model.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO mapToCustomerDTO(Customer customer);

    @InheritInverseConfiguration
    Customer mapToCustomer(CustomerDTO customerDTO);
}
