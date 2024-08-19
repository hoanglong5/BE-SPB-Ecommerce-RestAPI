package com.holo.ecommerce.product.repository;

import com.holo.ecommerce.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
