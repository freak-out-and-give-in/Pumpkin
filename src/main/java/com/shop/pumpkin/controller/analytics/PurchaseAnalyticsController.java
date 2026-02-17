package com.shop.pumpkin.controller.analytics;

import com.shop.pumpkin.service.analytics.PurchaseAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseAnalyticsController {

    private final PurchaseAnalyticsService purchaseAnalyticsService;

    @Autowired
    public PurchaseAnalyticsController(PurchaseAnalyticsService purchaseAnalyticsService) {
        this.purchaseAnalyticsService = purchaseAnalyticsService;
    }

    @GetMapping("/analytics/purchase/amountOfPurchases")
    public void getAmountOfPurchases() {
        purchaseAnalyticsService.calculateAmountOfPurchases();
    }

    @GetMapping("/analytics/purchase/averageAmountPurchased")
    public void getAverageAmountPurchased() {
        purchaseAnalyticsService.calculateAverageAmountPurchased();
    }

}
