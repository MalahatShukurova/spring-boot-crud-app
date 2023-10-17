package com.malahat.springbootcrudapp.controller;

import com.malahat.springbootcrudapp.dto.OrderDto;
import com.malahat.springbootcrudapp.dto.ResponseOrderDto;
import com.malahat.springbootcrudapp.model.Customer;
import com.malahat.springbootcrudapp.service.impl.CustomerServiceImpl;
import com.malahat.springbootcrudapp.service.impl.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderServiceImpl orderServiceImpl;
    private final CustomerServiceImpl customerServiceImpl;

    public OrderController(OrderServiceImpl orderServiceImpl, CustomerServiceImpl customerServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
        this.customerServiceImpl = customerServiceImpl;
    }

//    public ResponseEntity<ResponseOrderDto> placeOrder (@RequestBody OrderDto orderDto){
//        ResponseOrderDto responseOrderDTO = new ResponseOrderDto();
//        double amount = orderServiceImpl.getCartAmount(orderDto.getCartItems());
//
//        Customer customer = new Customer(orderDto.getCustomerName(),orderDto.getCustomerEmail());
//        //Integer customerIdFromDb = customerServiceImpl.
//    }





}
