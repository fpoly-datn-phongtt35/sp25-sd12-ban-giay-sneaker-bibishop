package com.poly.admin.controller.dashboard;

import com.poly.admin.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Map;

@Controller
public class RevenueController {
    @Autowired
    private IStatisticService iStatisticService;
    @GetMapping("/admin/statistic")
    public String getMonthlyRevenue(Model model) {
        Map<String, Map<String, BigDecimal>> revenueData = iStatisticService.statisticByMonth();
        model.addAttribute("revenueData", revenueData);
        return "/admin/thong-ke/revenue";
    }
}