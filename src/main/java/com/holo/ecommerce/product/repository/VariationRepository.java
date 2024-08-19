package com.holo.ecommerce.product.repository;

import com.holo.ecommerce.product.entity.Variation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariationRepository extends JpaRepository<Variation,Long> {
}
