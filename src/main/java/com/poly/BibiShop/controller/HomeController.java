package com.poly.BibiShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class HomeController {
    @GetMapping("/san-pham")
    public String getProductShopPages(Model model){
        model.addAttribute("totalPages", 1);
        model.addAttribute("currentPage", 0);
        model.addAttribute("listProduct", new Object());

        return "shop/product";
    }
}
