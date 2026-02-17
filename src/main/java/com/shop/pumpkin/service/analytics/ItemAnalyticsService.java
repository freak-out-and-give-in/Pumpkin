package com.shop.pumpkin.service.analytics;

import com.shop.pumpkin.dto.AmountPurchasedOnly;
import com.shop.pumpkin.dto.WeightOnly;
import com.shop.pumpkin.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemAnalyticsService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final ItemRepository itemRepository;

    @Autowired
    public ItemAnalyticsService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public double calculateAverageWeight() {
        List<WeightOnly> weight = itemRepository.findWeight();

        double sum = weight.stream()
                .map(WeightOnly::weight)
                .mapToDouble(n -> n).sum();
        int amount = weight.size();

        return sum / amount;
    }
}
