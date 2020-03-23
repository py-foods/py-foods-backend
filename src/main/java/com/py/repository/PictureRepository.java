package com.py.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.py.entity.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long> {
	
	List<Picture> findByProductId(Long id);
}
