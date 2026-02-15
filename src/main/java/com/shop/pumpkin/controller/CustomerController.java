package com.shop.pumpkin.controller;

import com.shop.pumpkin.model.Customer;
import com.shop.pumpkin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/getCustomers")
    public List<Customer> getCustomer() {
        return customerService.getAll();
    }

    @PostMapping("/customers/addCustomer")
    public void addCustomer(@RequestParam String name,
                            @RequestParam boolean membership,
                            @RequestParam String membershipDateBought,
                            @RequestParam double totalAmountPurchased,
                            @RequestParam double totalAmountRefunded,
                            @RequestParam String complaints,
                            @RequestParam String employeeComments,
                            @RequestParam boolean ban) {
        Customer customer = new Customer(name, membership, membershipDateBought, totalAmountPurchased,
                totalAmountRefunded, complaints, employeeComments, ban);

        customerService.save(customer);
    }

    @DeleteMapping("/customers/deleteCustomer")
    public void deleteCustomer(@RequestParam String id) {
        customerService.delete(id);
    }
}

