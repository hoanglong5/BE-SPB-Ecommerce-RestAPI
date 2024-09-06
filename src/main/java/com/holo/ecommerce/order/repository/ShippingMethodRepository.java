package com.holo.ecommerce.order.repository;

import com.holo.ecommerce.order.entity.ShippingMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingMethodRepository extends JpaRepository<ShippingMethod,Long> {
}
