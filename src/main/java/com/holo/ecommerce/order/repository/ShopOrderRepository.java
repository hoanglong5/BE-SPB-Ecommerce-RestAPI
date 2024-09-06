package com.holo.ecommerce.order.repository;

import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.order.entity.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopOrderRepository extends JpaRepository<ShopOrder,Long> {
}
