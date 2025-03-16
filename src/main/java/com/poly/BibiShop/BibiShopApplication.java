package com.poly.BibiShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = {"com.poly.BibiShop", "com.poly.BibiShop.repository.impl.hoadon.Server"})
public class BibiShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(BibiShopApplication.class, args);

    }

}
