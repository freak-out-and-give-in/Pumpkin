package com.shop.pumpkin.model;

import com.shop.pumpkin.enumeration.OrderStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private OrderStatus status;

    @OneToMany
    @Column(nullable = false)
    private List<Item> items;

    @Column(nullable = false)
    private double price;

    public Order() {
    }

    public Order(List<Item> items, double price) {
        this.status = OrderStatus.CREATED;
        this.items = items;
        this.price = price;
    }
}
