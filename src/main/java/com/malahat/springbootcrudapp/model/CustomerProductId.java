package com.malahat.springbootcrudapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

  public class CustomerProductId implements Serializable {

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "product_id")
    private Long productId;
}
