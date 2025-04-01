package com.poly.client.controller;

import com.poly.client.config.Contant;
import com.poly.client.dto.hoadonchitiet.HDCTSearchRequest;
import com.poly.client.dto.hoadonchitiet.HDCTSearchResponse;
import com.poly.client.entity.HoaDon;
import com.poly.client.entity.KhachHang;
import com.poly.client.repository.HoaDonChiTietRepository;
import com.poly.client.security.CustomUserDetails;
import com.poly.client.service.HoadonService;
import com.poly.client.service.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderHistoryController {
    private final KhachHangService userService;
    private final HoadonService hoadonService;
    @GetMapping("/tai-khoan/lich-su-giao-dich")
    public String getOrderHistoryPage(Model model,
                                      @RequestParam(required = false) String name,
                                      @RequestParam(required = false) String size,
                                      @RequestParam(required = false) String color,
                                      @RequestParam(required = false) String colorId,
                                      @RequestParam(defaultValue = "1", required = false) Integer page){

        //Get list order pending
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        Long id = principal.getUser().getId();
        KhachHang khachHang = userService.getCustomerById(id);
        HDCTSearchRequest hdctSearchRequest = new HDCTSearchRequest(name, color, size, khachHang.getId());
        Page<HoaDon> result = hoadonService.orderByCustomer(khachHang, PageRequest.of(page-1, Contant.LIMIT_SIZE));
        model.addAttribute("orderList", result.getContent());
        model.addAttribute("totalPages", result.getTotalPages());
        model.addAttribute("currentPage", result.getPageable().getPageNumber() + 1);

        return "shop/order_history";
    }
}
