package com.coditas.ecommerceordermanagementsystem.service;

import com.coditas.ecommerceordermanagementsystem.entity.Product;
import com.coditas.ecommerceordermanagementsystem.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void updateProduct(int pid, Product product){
        Product p = productRepository.findById(pid).orElseThrow(
                () -> new RuntimeException("not exist.... ")
        );

        if(product.getQuantity() != 0){
            p.setQuantity(product.getQuantity());
        }
        if(product.getName()!=null){
            p.setName(product.getName());
        }

        if(product.getOrders()!=null){
            p.setOrders(product.getOrders());
        }

        productRepository.save(p);

    }
}
