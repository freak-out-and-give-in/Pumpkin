package com.shop.pumpkin.service;

import com.shop.pumpkin.model.Purchase;
import com.shop.pumpkin.repository.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public void save(Purchase purchase) {
        log.info("Saving purchase with the id {}", purchase.getId());

        purchaseRepository.save(purchase);
    }

    public List<Purchase> getAll() {
        log.info("Retrieving all purchases");

        return purchaseRepository.findAll();
    }

    public void delete(String id) {
        log.info("Deleting purchase with id {}", id);

        purchaseRepository.deleteById(id);
    }
}
