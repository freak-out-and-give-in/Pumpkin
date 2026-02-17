package com.shop.pumpkin.service.analytics;

import com.shop.pumpkin.dto.MembershipDateBoughtOnly;
import com.shop.pumpkin.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CustomerAnalyticsService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerAnalyticsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Calculates the amount of memberships purchased per year
    public HashMap<Integer, Integer> calculateMembershipPurchaseRatePerYear() {
        log.info("Retrieving every date when customers purchased membership");

        List<MembershipDateBoughtOnly> dates = customerRepository.findMembershipDatesPurchased();

        // Adds year of each date to map
        // Year, amount (e.g. 2021, 3)
        HashMap<Integer, Integer> yearsAndAmount = new HashMap<>();

        for (MembershipDateBoughtOnly date : dates) {
            String strDate = date.membershipDateBought();
            int year = Integer.parseInt(strDate.substring(0, 4));

            // Add 1 to the year count
            yearsAndAmount.compute(year, (k, currentAmount) -> (currentAmount == null) ? 1 : currentAmount + 1);
        }

        return yearsAndAmount;
    }
}
