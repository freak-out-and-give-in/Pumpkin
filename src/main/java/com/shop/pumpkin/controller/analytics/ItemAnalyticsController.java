package com.shop.pumpkin.controller.analytics;

import com.shop.pumpkin.service.analytics.ItemAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemAnalyticsController {

    private final ItemAnalyticsService itemAnalyticsService;

    @Autowired
    public ItemAnalyticsController(ItemAnalyticsService itemAnalyticsService) {
        this.itemAnalyticsService = itemAnalyticsService;
    }

    @GetMapping("/analytics/item/averageWeight")
    public void getAverageWeight() {
        itemAnalyticsService.calculateAverageWeight();
    }

}
