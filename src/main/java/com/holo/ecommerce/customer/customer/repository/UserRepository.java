package com.holo.ecommerce.customer.customer.repository;

import com.holo.ecommerce.customer.customer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
