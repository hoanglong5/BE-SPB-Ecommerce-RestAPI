package com.holo.ecommerce.product.repository;

import com.holo.ecommerce.product.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
}
