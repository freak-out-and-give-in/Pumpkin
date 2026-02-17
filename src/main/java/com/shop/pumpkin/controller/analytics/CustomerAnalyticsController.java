package com.shop.pumpkin.controller.analytics;

import com.shop.pumpkin.service.analytics.CustomerAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerAnalyticsController {

    private final CustomerAnalyticsService customerAnalyticsService;

    @Autowired
    public CustomerAnalyticsController(CustomerAnalyticsService customerAnalyticsService) {
        this.customerAnalyticsService = customerAnalyticsService;
    }

    @GetMapping("/analytics/customer/calculateMembershipPurchaseRatePerYear")
    public void getMembershipPurchaseRatePerYear() {
        customerAnalyticsService.calculateMembershipPurchaseRatePerYear();
    }

}
