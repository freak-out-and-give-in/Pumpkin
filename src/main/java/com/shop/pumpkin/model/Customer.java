package com.shop.pumpkin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean membership;

    @Column(nullable = false, columnDefinition = "DATE")
    private String membershipDateBought;

    @Column(nullable = false)
    private double totalAmountPurchased;

    @Column(nullable = false)
    private double totalAmountRefunded;

    @Column(nullable = false)
    private String complaints;

    @Column(nullable = false)
    private String employeeComments;

    @Column(nullable = false)
    private boolean ban;

    public Customer() {
    }

    public Customer(String name, boolean membership, String membershipDateBought, double totalAmountPurchased,
                    double totalAmountRefunded, String complaints, String employeeComments, boolean ban) {
        this.name = name;
        this.membership = membership;
        this.membershipDateBought = membershipDateBought;
        this.totalAmountPurchased = totalAmountPurchased;
        this.totalAmountRefunded = totalAmountRefunded;
        this.complaints = complaints;
        this.employeeComments = employeeComments;
        this.ban = ban;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isMembership() {
        return membership;
    }

    public String getMembershipDateBought() {
        return membershipDateBought;
    }

    public double getTotalAmountPurchased() {
        return totalAmountPurchased;
    }

    public double getTotalAmountRefunded() {
        return totalAmountRefunded;
    }

    public String getComplaints() {
        return complaints;
    }

    public String getEmployeeComments() {
        return employeeComments;
    }

    public boolean isBan() {
        return ban;
    }
}
