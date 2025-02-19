package com.poly.BibiShop.controller;

import com.poly.BibiShop.dto.admin.CreateKhachHangRequest;
import com.poly.BibiShop.dto.admin.CreateNhanVienRequest;
import com.poly.BibiShop.entity.KhachHang;
import com.poly.BibiShop.service.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.poly.BibiShop.entity.NhanVien;
import com.poly.BibiShop.service.NhanVienService;

@Controller
@RequestMapping("/admin/khachhang")
@RequiredArgsConstructor
public class KhachHangController {

    private final KhachHangService khachHangService;

    @GetMapping("list")
    public String listEmployee(Model model,
                               @RequestParam( required = false) String fullName,
                               @RequestParam( required = false) String phone,
                               @RequestParam( required = false) String email,
                               @RequestParam( required = false) String address,
                               @RequestParam( required = false) String account,
                               @RequestParam(defaultValue = "1", required = false) Integer page) {
        Page<KhachHang> users = khachHangService.adminListUserPages(account, fullName, phone, email, page);
        model.addAttribute("list", users.getContent());
        model.addAttribute("totalPages", users.getTotalPages());
        model.addAttribute("currentPage", users.getPageable().getPageNumber() + 1);
        return "admin/khach-hang/list";
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id) {
        khachHangService.deleteCustomer(id);
        return ResponseEntity.ok("Xóa thành công");
    }
    @GetMapping("/create")
    public String showAddEmployeeForm(Model model) {
        return "admin/khach-hang/create";
    }

    @PostMapping("/create")
    public String addEmployee(@RequestBody CreateKhachHangRequest request) {

        khachHangService.saveCustomer(request);
        return "redirect:/admin/khachhang/list";
    }
    @GetMapping("/{id}")
    public String showUpdateEmployeeForm(@PathVariable("id") Long id, Model model) {
        KhachHang khachHang = khachHangService.getCustomerById(id);
        model.addAttribute("khachHang", khachHang);
        return "admin/khach-hang/view";
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") Long id, @RequestBody CreateKhachHangRequest request) {
        request.setId(id);
        khachHangService.updateCustomer(request);
        return ResponseEntity.ok("Cập nhật thành công");
    }
}