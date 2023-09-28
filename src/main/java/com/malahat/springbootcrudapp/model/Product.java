package com.malahat.springbootcrudapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

//    @OneToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;

    @ManyToMany(mappedBy = "products")
    private List<Customer> customers;


}
