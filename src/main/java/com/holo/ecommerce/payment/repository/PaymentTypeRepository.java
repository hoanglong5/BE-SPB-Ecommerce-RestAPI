package com.holo.ecommerce.payment.repository;

import com.holo.ecommerce.payment.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType,Long> {
}
