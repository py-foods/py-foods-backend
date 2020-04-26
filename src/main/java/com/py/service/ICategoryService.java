package com.py.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.py.entity.Category;

public interface ICategoryService {

	public Optional<Category> findByCategoryId(long id);

	public Page<Category> findAll(Pageable pageable);
}
