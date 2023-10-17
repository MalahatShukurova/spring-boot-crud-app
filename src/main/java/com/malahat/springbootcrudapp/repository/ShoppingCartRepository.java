package com.malahat.springbootcrudapp.repository;

import com.malahat.springbootcrudapp.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository <ShoppingCart, Long> {
}
