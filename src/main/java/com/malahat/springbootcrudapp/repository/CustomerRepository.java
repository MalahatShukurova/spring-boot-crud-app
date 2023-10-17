package com.malahat.springbootcrudapp.repository;

import com.malahat.springbootcrudapp.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long> {


}
