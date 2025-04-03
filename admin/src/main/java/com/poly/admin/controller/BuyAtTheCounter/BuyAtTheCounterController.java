package com.poly.admin.controller.BuyAtTheCounter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuyAtTheCounterController {

    @GetMapping("/buyAtTheCounter")
    public String buyAtTheCounter(Model model) {
        return "admin/BuyAtTheCounter/buy-at-the-counter";
    }

}
