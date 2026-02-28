package com.shop.pumpkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"com.shop.pumpkin.repository"})
@EntityScan({"com.shop.pumpkin.model"})
public class PumpkinApplication {

	static void main(String[] args) {
		SpringApplication.run(PumpkinApplication.class, args);
	}

}
