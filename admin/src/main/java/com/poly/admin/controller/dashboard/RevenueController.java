package com.poly.admin.controller.dashboard;

import com.poly.admin.constant.Constant;
import com.poly.admin.dto.hoadonchitiet.HDCTSearchRequest;
import com.poly.admin.dto.hoadonchitiet.HDCTSearchResponse;
import com.poly.admin.entity.NhanVien;
import com.poly.admin.service.DashboardService;
import com.poly.admin.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Map;

@Controller
public class RevenueController {
    @Autowired
    private IStatisticService iStatisticService;
    @Autowired
    private DashboardService dashboardService;
    @GetMapping("/admin/statistic")
    public String getMonthlyRevenue(Model model,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) String size,
                                    @RequestParam(required = false) String color,
                                    @RequestParam(required = false) String colorId,
                                    @RequestParam(defaultValue = "1", required = false) Integer page) {
        HDCTSearchRequest hdctSearchRequest = new HDCTSearchRequest(name, color, size);
        Page<HDCTSearchResponse> result = dashboardService.hdctSerchResponse(hdctSearchRequest, PageRequest.of(page-1, Constant.LIMIT_SIZE));
        model.addAttribute("list", result.getContent());
        model.addAttribute("totalPages", result.getTotalPages());
        model.addAttribute("currentPage", result.getPageable().getPageNumber() + 1);
        return "/admin/thong-ke/revenue";
    }
}