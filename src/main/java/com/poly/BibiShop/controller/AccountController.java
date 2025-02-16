package com.poly.BibiShop.controller;

import com.poly.BibiShop.dto.admin.CreateKhachHangRequest;
import com.poly.BibiShop.entity.KhachHang;
import com.poly.BibiShop.service.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client/khachhang")
@RequiredArgsConstructor
public class AccountController {

    private final KhachHangService khachHangService;

    @GetMapping("info")
    public String listEmployees(Model model) {
        KhachHang khachHang = khachHangService.getAllCustomers().get(0);
        model.addAttribute("khachhang", khachHang);
        return "shop/account";
    }
    @PostMapping("register")
    public ResponseEntity<String> register(Model model, @RequestBody CreateKhachHangRequest request) {
        khachHangService.register(request);
        return ResponseEntity.ok("Đăng ký thành công");
    }
    @PutMapping("update-profile")
    public ResponseEntity<String> updateProfile(Model model, @RequestBody CreateKhachHangRequest request) {
        khachHangService.updateProfile(request);
        return ResponseEntity.ok("Cập nhật thành công");
    }
}