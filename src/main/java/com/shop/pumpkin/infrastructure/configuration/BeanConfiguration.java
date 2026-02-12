package com.shop.pumpkin.infrastructure.configuration;

import com.shop.pumpkin.application.port.DrivingPort;
import com.shop.pumpkin.application.service.Inventory;
import com.shop.pumpkin.infrastructure.adapter.DrivenAdapter;
import com.shop.pumpkin.infrastructure.port.DrivenPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    DrivingPort drivingPort(DrivenPort drivenPort) {
        return new Inventory(drivenPort);
    }

    @Bean
    DrivenPort drivenPort() {
        return new DrivenAdapter();
    }

}
