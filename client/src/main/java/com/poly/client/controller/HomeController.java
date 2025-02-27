package com.poly.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class HomeController {

    @GetMapping
    public String homePage(Model model) {

        //Lấy 5 sản phẩm mới nhất
        model.addAttribute("totalPages", 1);
        model.addAttribute("currentPage", 0);
        model.addAttribute("listProduct", new Object());

        return "shop/product";
    }
}
