package com.coditas.ecommerceordermanagementsystem.controller;

import com.coditas.ecommerceordermanagementsystem.entity.Product;
import com.coditas.ecommerceordermanagementsystem.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService= orderService;
    }

    @PostMapping("/orders")
    public String orderPlacement(@RequestBody List<Product> productsList)
    {
        return orderService.placeOrder(productsList);
    }

    @DeleteMapping("/orders/{id}")
    public String cancelOrder(@PathVariable int id)
    {
        return orderService.deleteOrder(id);
    }



}
