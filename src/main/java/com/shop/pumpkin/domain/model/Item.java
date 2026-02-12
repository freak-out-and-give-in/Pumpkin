package com.shop.pumpkin.domain.model;

import java.util.UUID;

public class Item {

    private UUID sku;

    private String name;

    private double price;

    private boolean hasSold;

    public Item(String name, double price, boolean hasSold) {
        this.sku = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.hasSold = hasSold;
    }
}
