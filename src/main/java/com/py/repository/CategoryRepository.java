package com.py.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.py.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
