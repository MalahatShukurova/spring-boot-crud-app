package com.malahat.springbootcrudapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProduct {

     @EmbeddedId
     private CustomerProductId id;

     @ManyToOne(fetch = FetchType.LAZY)
     @MapsId("customerId")
     @JoinColumn(name = "customer_id")
     private Customer customer;

     @ManyToOne(fetch = FetchType.LAZY)
     @MapsId("productId")
     @JoinColumn(name = "product_id")
     private Product product;

     int purchased;

}
