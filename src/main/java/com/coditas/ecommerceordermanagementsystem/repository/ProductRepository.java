package com.coditas.ecommerceordermanagementsystem.repository;

import com.coditas.ecommerceordermanagementsystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
