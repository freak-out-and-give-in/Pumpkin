package com.shop.pumpkin.repository;

import com.shop.pumpkin.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}
