package com.poly.admin.controller.dashboard;

import com.poly.admin.dto.dashboard.DashboardData;
import com.poly.admin.dto.dashboard.Metric;
import com.poly.admin.dto.dashboard.RevenueData;
import com.poly.admin.dto.dashboard.RevenueDataReq;
import com.poly.admin.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("admin/dashboard")
public class DashBoardController {
    @Autowired
    DashboardService dashboardService;
    @GetMapping("")
    public String getDashDetails(Model model) {
        /**
         * Populate company revenue data
         */
        model.addAttribute("cr", dashboardService.getTodayRevenueDash());

        /**
         * Populate Employee info
         */
        model.addAttribute("ei", dashboardService.getAllEmployee());

        /**
         * Populate Product Category data
         */
        model.addAttribute("bc", dashboardService.getBestCategory());

        /**
         * Populate Order Received data
         */
        model.addAttribute("or", dashboardService.getAllOrderReceived());

        /**
         * Populate Order Status data
         */
        model.addAttribute("os", dashboardService.getOrderCollection());

        return "admin/dashboard/index";
    }
    @PostMapping("chart")
    public List<RevenueData> getRevenueDate(@RequestBody RevenueDataReq revenueDataReq){
        List<RevenueData> revenueData = new ArrayList<>();
        RevenueData revenueData1 = new RevenueData(LocalDate.now(), 1000);
        RevenueData revenueData2 = new RevenueData(LocalDate.now(), 1000);
        RevenueData revenueData3 = new RevenueData(LocalDate.now(), 1000);
        RevenueData revenueData4 = new RevenueData(LocalDate.now(), 1000);
        RevenueData revenueData5 = new RevenueData(LocalDate.now(), 1000);
        RevenueData revenueData6 = new RevenueData(LocalDate.now(), 1000);
        revenueData.addAll(Arrays.asList(revenueData1,revenueData2,revenueData3, revenueData4, revenueData5, revenueData6));
        return revenueData;
    }
}
