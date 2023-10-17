package com.malahat.springbootcrudapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrderDto {

    private float amount;
    private int invoiceNumber;
    private String date;
    private String OrderDescription;
    private int orderId;

}
