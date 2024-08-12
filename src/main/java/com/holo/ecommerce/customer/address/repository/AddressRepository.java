package com.holo.ecommerce.customer.address.repository;

import com.holo.ecommerce.customer.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
