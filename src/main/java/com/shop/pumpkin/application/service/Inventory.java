package com.shop.pumpkin.application.service;

import com.shop.pumpkin.application.port.DrivingPort;
import com.shop.pumpkin.infrastructure.port.DrivenPort;
import org.springframework.beans.factory.annotation.Autowired;

public class Inventory implements DrivingPort {

    private final DrivenPort drivenPort;

    @Autowired
    public Inventory(DrivenPort drivenPort) {
        this.drivenPort = drivenPort;
    }
}
