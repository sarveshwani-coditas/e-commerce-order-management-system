package com.coditas.ecommerceordermanagementsystem.controller;

import com.coditas.ecommerceordermanagementsystem.entity.Product;
import com.coditas.ecommerceordermanagementsystem.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductService productService;

    public ProductController (ProductService productService)
    {
        this.productService=productService;
    }

    @PutMapping("/products/{pid}")
    public void updateProduct(@PathVariable int pid, @RequestBody Product updatedproduct)
    {
        productService.updateProduct(pid, updatedproduct);
    }

}
