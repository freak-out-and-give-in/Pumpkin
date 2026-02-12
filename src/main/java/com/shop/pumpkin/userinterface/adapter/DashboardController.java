package com.shop.pumpkin.userinterface.adapter;

import com.shop.pumpkin.application.port.DrivingPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DashboardController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final DrivingPort drivingPort;

    @Autowired
    public DashboardController(DrivingPort drivingPort) {
        this.drivingPort = drivingPort;
    }

    @GetMapping
    public ModelAndView index() {
        log.info("Loading the dashboard page");

        return new ModelAndView("/pages/dashboard/dashboard.html");
    }
}
