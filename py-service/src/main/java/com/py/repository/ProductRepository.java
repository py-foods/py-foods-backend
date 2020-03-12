package com.py.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.py.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
