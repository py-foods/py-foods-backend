package com.py.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.py.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "select * from product p, category c where p.category_id = c.id and c.id = :categoryId and p.id <> :productId", nativeQuery = true)
	public List<Product> findReferByCategoryId(
			@Param("productId") Long productId,
			@Param("categoryId") Long categoryId, Pageable pageable);

	@Query(value = "select * from product p where p.rating > :level and p.is_active = 1", nativeQuery = true)
	public Page<Product> findByRating(@Param("level") Integer level, Pageable pageable);

	Page<Product> findAllByCategoryId(Long categoryId, Pageable pageable);

}
