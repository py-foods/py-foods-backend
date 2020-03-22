package com.py.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.py.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "select p.* from product p, category c where p.category_id = c.id and c.id = :categoryId and p.id <> :productId", nativeQuery = true)
	public List<Product> findReferByCategoryId(
			@Param("productId") long productId,
			@Param("categoryId") long categoryId, Pageable pageable);

	
}
