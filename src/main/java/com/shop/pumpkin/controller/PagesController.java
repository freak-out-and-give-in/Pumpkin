package com.shop.pumpkin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PagesController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping({"/", "/dashboard"})
    public ModelAndView loadDashboardPage() {
        log.info("Loading the dashboard page");

        return new ModelAndView("/pages/dashboard/dashboard.html");
    }

    @GetMapping("/inventory")
    public ModelAndView loadInventoryPage() {
        log.info("Loading the inventory page");

        return new ModelAndView("/pages/inventory/inventory.html");
    }

    @GetMapping("/purchases")
    public ModelAndView loadPurchasesPage() {
        log.info("Loading the purchases page");

        return new ModelAndView("/pages/purchases/purchases.html");
    }

    @GetMapping("/customers")
    public ModelAndView loadCustomersPage() {
        log.info("Loading the customers page");

        return new ModelAndView("/pages/customers/customers.html");
    }

    @GetMapping("/suppliers")
    public ModelAndView loadSuppliersPage() {
        log.info("Loading the suppliers page");

        return new ModelAndView("/pages/suppliers/suppliers.html");
    }

    @GetMapping("/reports")
    public ModelAndView loadReportsPage() {
        log.info("Loading the reports page");

        return new ModelAndView("/pages/reports/reports.html");
    }

    @GetMapping("/settings")
    public ModelAndView loadSettingsPage() {
        log.info("Loading the settings page");

        return new ModelAndView("/pages/settings/settings.html");
    }
}
