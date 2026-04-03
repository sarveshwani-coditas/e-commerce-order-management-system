package com.coditas.ecommerceordermanagementsystem.service;

import com.coditas.ecommerceordermanagementsystem.entity.Order;
import com.coditas.ecommerceordermanagementsystem.entity.Product;
import com.coditas.ecommerceordermanagementsystem.repository.OrderRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    public OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String placeOrder(Order neworder) {

        orderRepository.save(neworder);

        return "Order Placed";
    }

    public String deleteOrder(int id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Order does not exist with id "+id)
        );

        orderRepository.delete(order);
        return "Order cancelled";

    }
}
