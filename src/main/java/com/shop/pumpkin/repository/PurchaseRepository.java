package com.shop.pumpkin.repository;

import com.shop.pumpkin.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {
}
