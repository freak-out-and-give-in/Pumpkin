package com.shop.pumpkin.service.analytics;

import com.shop.pumpkin.dto.AmountPurchasedOnly;
import com.shop.pumpkin.repository.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseAnalyticsService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseAnalyticsService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public int calculateAmountOfPurchases() {
        return purchaseRepository.findAll().size();
    }

    public double calculateAverageAmountPurchased() {
        List<AmountPurchasedOnly> amountPurchased = purchaseRepository.findAmountPurchased();

        double sum = amountPurchased.stream()
                .map(AmountPurchasedOnly::amountPurchased)
                .mapToDouble(n -> n).sum();
        int amount = amountPurchased.size();

        return sum / amount;
    }
}
