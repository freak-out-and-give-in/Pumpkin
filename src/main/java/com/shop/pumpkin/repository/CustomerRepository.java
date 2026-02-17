package com.shop.pumpkin.repository;

import com.shop.pumpkin.dto.MembershipDateBoughtOnly;
import com.shop.pumpkin.model.Customer;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query("SELECT membership_date_bought FROM Customer membership_date_bought")
    List<MembershipDateBoughtOnly> findMembershipDatesPurchased();
}
