package com.shop.pumpkin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Purchase {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String supplier;

    @Column(nullable = false)
    private double amountPurchased;

    @Column(nullable = false, columnDefinition = "TIME")
    private String time;

    @Column(nullable = false, columnDefinition = "DATE")
    private String date;

    public Purchase() {
    }

    public Purchase(String supplier, double amountPurchased, String time, String date) {
        this.supplier = supplier;
        this.amountPurchased = amountPurchased;
        this.time = time;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getAmountPurchased() {
        return amountPurchased;
    }

    public void setAmountPurchased(double amountPurchased) {
        this.amountPurchased = amountPurchased;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getmaou() {
        return false;
    }
}

