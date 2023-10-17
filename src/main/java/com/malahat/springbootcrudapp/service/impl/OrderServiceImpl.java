package com.malahat.springbootcrudapp.service.impl;

import com.malahat.springbootcrudapp.exception.ResourceNotFoundException;
import com.malahat.springbootcrudapp.model.Order;
import com.malahat.springbootcrudapp.model.Product;
import com.malahat.springbootcrudapp.model.ShoppingCart;
import com.malahat.springbootcrudapp.repository.OrderRepository;
import com.malahat.springbootcrudapp.repository.ProductRepository;
import com.malahat.springbootcrudapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order getOrderDetail(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("Order"));
    }

    @Override
    public double getCartAmount(List<ShoppingCart> shoppingCartList) {
        double totalCartAmount = 0;
        double singleCartAmount;
        int availableQuantity = 0;

        for (ShoppingCart cart : shoppingCartList){

            long productId = cart.getProductId();
            Optional<Product> product = productRepository.findById(productId);
            if (product.isPresent()){
                Product product1 = product.get();
                if (product1.getAvailableQuantity() < cart.getQuantity()){
                    singleCartAmount = product1.getPrice() * product1.getAvailableQuantity();
                    cart.setQuantity(product1.getAvailableQuantity());
                } else {
                        singleCartAmount = cart.getQuantity() * product1.getPrice();
                        availableQuantity = product1.getAvailableQuantity() - cart.getQuantity();
                }

                totalCartAmount+=singleCartAmount;
                product1.setAvailableQuantity(availableQuantity);
                availableQuantity = 0;
                cart.setProductName(product1.getName());
                cart.setAmount(singleCartAmount);
                productRepository.save(product1);
            }
        }
        return totalCartAmount;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
