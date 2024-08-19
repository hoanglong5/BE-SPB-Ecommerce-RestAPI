package com.holo.ecommerce.promotion.repository;

import com.holo.ecommerce.promotion.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion,Long> {
}
