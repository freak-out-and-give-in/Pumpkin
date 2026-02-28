package com.shop.selenium.pom.base;

enum Page {
    DASHBOARD("Dashboard"),
    INVENTORY("Inventory"),
    PURCHASES("Purchases"),
    CUSTOMERS("Customers"),
    SUPPLIERS("Suppliers"),
    REPORTS("Reports"),
    SETTINGS("Settings");

    private final String name;

    Page(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
