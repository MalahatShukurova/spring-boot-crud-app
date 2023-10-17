package com.malahat.springbootcrudapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long id;
    private String name;
    private String surname;
    private String address;
    private int age;
    private String number;
}
