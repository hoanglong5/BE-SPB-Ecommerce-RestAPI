package com.holo.ecommerce.customer.customer.repository;

import com.holo.ecommerce.customer.customer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmailAddress(String emailAddress);
}
