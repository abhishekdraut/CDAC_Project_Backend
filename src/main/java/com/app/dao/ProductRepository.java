package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
