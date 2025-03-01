package com.poly.BibiShop;

import com.poly.BibiShop.controller.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
public class BibiShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(BibiShopApplication.class, args);

    }

}
