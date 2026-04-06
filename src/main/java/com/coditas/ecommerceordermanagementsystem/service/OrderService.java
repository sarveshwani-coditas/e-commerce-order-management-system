package com.coditas.ecommerceordermanagementsystem.service;

import com.coditas.ecommerceordermanagementsystem.entity.Order;
import com.coditas.ecommerceordermanagementsystem.entity.Product;
import com.coditas.ecommerceordermanagementsystem.repository.OrderRepository;

import com.sun.net.httpserver.Authenticator;
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

    public String paymentGateway(int transaction_id, int payableAmount){
//        int transaction_id = 11;

        if(payableAmount <= 0){
            throw new RuntimeException("Amount Can't be negative or zero!");
        }

        //Calling external Payment Gateway

        if(transaction_id > 10){
            return "Success";
        }
        else{
            throw new RuntimeException("Transaction failed");
        }
    }
}
