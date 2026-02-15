package com.shop.pumpkin.controller;

import com.shop.pumpkin.model.Purchase;
import com.shop.pumpkin.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchasesController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchasesController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/purchases/getPurchases")
    public List<Purchase> getPurchases() {
        return purchaseService.getAll();
    }

    @PostMapping("/purchases/addPurchase")
    public void addPurchase(@RequestParam String supplier,
                            @RequestParam double amountPurchased,
                            @RequestParam String time,
                            @RequestParam String date) {
        Purchase purchase = new Purchase(supplier, amountPurchased, time, date);

        purchaseService.save(purchase);
    }

    @DeleteMapping("/purchases/deletePurchase")
    public void deletePurchase(@RequestParam String id) {
        purchaseService.delete(id);
    }
}
