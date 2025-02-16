package com.poly.BibiShop.controller;

import com.poly.BibiShop.dto.admin.CreateNhanVienRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.poly.BibiShop.entity.NhanVien;
import com.poly.BibiShop.service.NhanVienService;

@Controller
@RequestMapping("/admin/nhanvien")
public class NhanVienController {

    private final NhanVienService nhanVienService;

    public NhanVienController(NhanVienService nhanVienService) {
        this.nhanVienService = nhanVienService;
    }

    @GetMapping("list")
    public String listEmployee(Model model,
                            @RequestParam(defaultValue = "", required = false) String fullName,
                            @RequestParam(defaultValue = "", required = false) String phone,
                            @RequestParam(defaultValue = "", required = false) String email,
                            @RequestParam(defaultValue = "", required = false) String address,
                            @RequestParam(defaultValue = "1", required = false) Integer page) {
        Page<NhanVien> users = nhanVienService.adminListUserPages(fullName, phone, email, page);
        model.addAttribute("list", users.getContent());
        model.addAttribute("totalPages", users.getTotalPages());
        model.addAttribute("currentPage", users.getPageable().getPageNumber() + 1);
        return "admin/nhan-vien/list";
    }

    @GetMapping("/create")
    public String showAddEmployeeForm(Model model) {
        return "admin/nhan-vien/create";
    }

    @PostMapping("/create")
    public String addEmployee(@RequestBody CreateNhanVienRequest request) {

        NhanVien nhanVien = nhanVienService.saveEmployee(request);
        return "redirect:/admin/nhanvien/list";
    }

    @GetMapping("/{id}")
    public String showUpdateEmployeeForm(@PathVariable("id") Long id, Model model) {
        NhanVien nhanVien = nhanVienService.getEmployeeById(id);
        model.addAttribute("nhanVien", nhanVien);
        return "admin/nhan-vien/edit";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") Integer id, @RequestBody CreateNhanVienRequest nhanVien) {
        nhanVien.setId(id);
        nhanVienService.updateNhanVien(nhanVien);
        return ResponseEntity.ok("Cập nhật thành công");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id) {
        nhanVienService.deleteEmployee(id);
        return ResponseEntity.ok("Xóa thành công");
    }
}