package com.malahat.springbootcrudapp.repository;

import com.malahat.springbootcrudapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
   // @Query("select id from product inner join customer on product.id = customer.id")

}
