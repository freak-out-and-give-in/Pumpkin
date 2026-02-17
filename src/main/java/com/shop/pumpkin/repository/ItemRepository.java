package com.shop.pumpkin.repository;

import com.shop.pumpkin.dto.WeightOnly;
import com.shop.pumpkin.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, String> {

    @Query("SELECT weight FROM Item weight")
    List<WeightOnly> findWeight();
}
