package com.holo.ecommerce.payment.repository;

import com.holo.ecommerce.payment.entity.UserPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPaymentTypeRepository extends JpaRepository<UserPaymentMethod,Long> {
}
