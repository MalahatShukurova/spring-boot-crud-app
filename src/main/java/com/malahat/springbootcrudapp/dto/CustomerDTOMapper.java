package com.malahat.springbootcrudapp.dto;

import com.malahat.springbootcrudapp.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerDTOMapper {

    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDTOtoCustomer(CustomerDTO customerDTO);
}
