package com.shop.pumpkin.repository;

import com.shop.pumpkin.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
