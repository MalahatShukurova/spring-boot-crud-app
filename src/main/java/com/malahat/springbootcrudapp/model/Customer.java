package com.malahat.springbootcrudapp.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JavaType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private Set<Product> products = new HashSet<>();

    private String name;

    private String surname;

    private String address;

    private Integer age;

    private String number;

//    @ManyToMany
//    @JoinTable(
//            name = "purchased_product",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )


}
