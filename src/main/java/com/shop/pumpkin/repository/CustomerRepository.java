package com.shop.pumpkin.repository;

import com.shop.pumpkin.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
