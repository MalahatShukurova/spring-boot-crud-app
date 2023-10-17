package com.malahat.springbootcrudapp.mapper;

import com.malahat.springbootcrudapp.dto.CustomerDto;
import com.malahat.springbootcrudapp.model.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto mapToCustomerDTO(Customer customer);

    @InheritInverseConfiguration
    Customer mapToCustomer(CustomerDto customerDTO);
}
