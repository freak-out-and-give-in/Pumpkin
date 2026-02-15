package com.shop.pumpkin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private double wholesalePrice;

    @Column(nullable = false)
    private double retailPrice;

    @Column(nullable = false)
    private boolean hasSold;

    public Item() {
    }

    public Item(String name, double wholesalePrice, double retailPrice, int amount, int quantity, double weight) {
        this.name = name;
        this.amount = amount;
        this.quantity = quantity;
        this.weight = weight;
        this.wholesalePrice = wholesalePrice;
        this.retailPrice = retailPrice;
        this.hasSold = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public boolean isHasSold() {
        return hasSold;
    }

    public void setHasSold(boolean hasSold) {
        this.hasSold = hasSold;
    }
}
