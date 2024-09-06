package com.holo.ecommerce.review.repository;

import com.holo.ecommerce.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
