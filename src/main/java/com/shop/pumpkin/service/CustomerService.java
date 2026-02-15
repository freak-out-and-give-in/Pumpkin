package com.shop.pumpkin.service;

import com.shop.pumpkin.model.Customer;
import com.shop.pumpkin.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(Customer customer) {
        log.info("Saving customer with the name {}", customer.getName());

        customerRepository.save(customer);
    }

    public List<Customer> getAll() {
        log.info("Retrieving all customers");

        return customerRepository.findAll();
    }

    public void delete(String id) {
        log.info("Deleting customer with id {}", id);

        customerRepository.deleteById(id);
    }
}
