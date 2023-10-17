package com.malahat.springbootcrudapp.service;

import com.malahat.springbootcrudapp.model.Order;
import com.malahat.springbootcrudapp.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Order getOrderDetail(Long orderId);

    public double getCartAmount(List<ShoppingCart> shoppingCartList);

    public Order saveOrder (Order order);
    }

