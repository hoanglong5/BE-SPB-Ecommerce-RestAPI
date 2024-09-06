package com.holo.ecommerce.order.repository;

import com.holo.ecommerce.order.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine,Long> {
}
