package com.ProductCatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProductCatalog.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}

