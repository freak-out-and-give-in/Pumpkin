package com.shop.pumpkin.repository;

import com.shop.pumpkin.dto.AmountPurchasedOnly;
import com.shop.pumpkin.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {

    @Query("SELECT amount_purchased FROM Purchase amount_purchased")
    List<AmountPurchasedOnly> findAmountPurchased();
}
