package com.malahat.springbootcrudapp.repository;

import com.malahat.springbootcrudapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long> {
}
