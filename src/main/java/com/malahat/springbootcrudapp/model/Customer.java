package com.malahat.springbootcrudapp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JavaType;

import java.util.List;

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

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String address;

    @Column
    private Integer age;

    @Column
    private String number;

//    @OneToOne
//    @JoinColumn(name = "product_id")
//    private Product product;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "customer_product",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
     private List<Product> products;

//    @OneToMany(mappedBy = "customer",
//    cascade = CascadeType.ALL,
//    orphanRemoval = true)
//    private List<CustomerProduct> products;


    // one to one
    // many to one
    // one to many
    // many to many

}
