package com.holo.ecommerce.category.repository;

import com.holo.ecommerce.category.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
