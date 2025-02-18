package com.poly.BibiShop.controller;


import com.poly.BibiShop.entity.HoaDon;
import com.poly.BibiShop.entity.HoaDonChiTiet;
import com.poly.BibiShop.repository.impl.hoadon.Server.HoaDonChiTietRepository;
import com.poly.BibiShop.service.server.HoaDonService;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/hoadon")
@RequiredArgsConstructor
public class HoaDonController {

  private String generateMaHoaDon() {
    // Generate a random alphanumeric code
    String randomPart = UUID.randomUUID().toString().substring(0, 8)
        .toUpperCase(); // Get the first 8 characters of UUID
    return "HD" + randomPart;
  }

  private final HoaDonService hoaDonService;

  @GetMapping
  public String danhSachHoaDon(Model model) {
    List<HoaDon> danhSach = hoaDonService.layTatCa();
    model.addAttribute("danhSachHoaDon", danhSach);
    return "admin/hoadon/danh-sach";
  }

  @GetMapping("/them")
  public String formThemHoaDon(Model model) {
    // tạo hóa đơn mới
    HoaDon hoaDon = hoaDonService.themHoaDon(new HoaDon());
    model.addAttribute("hoaDon", hoaDon);
    hoaDon.setMaHoaDon(generateMaHoaDon());
    hoaDon.setChiTietHoaDon((List<HoaDonChiTiet>) new HoaDonChiTiet());
    // danh sách sản phẩm chi tiết
    List<HoaDonChiTiet> hoadonChitiet = hoaDonService.getChiTietHoaDonById(hoaDon.getId());
    model.addAttribute("hoadonchitiet", hoadonChitiet);
    return "admin/hoadon/them-hoaDon";
  }

  @PostMapping("/them")
  public String themHoaDon(@Valid @ModelAttribute("hoaDon") HoaDon hoaDon, BindingResult result) {
    if (result.hasErrors()) {
      return "admin/hoadon/them-hoaDon";
    }
    hoaDonService.themHoaDon(hoaDon);
    return "redirect:/admin/hoadon";
  }


  @GetMapping("/sua/{id}")
  public String formSuaHoaDon(@PathVariable Long id, Model model) {
    HoaDon hoaDon = hoaDonService.layTheoId(id);
    model.addAttribute("hoaDon", hoaDon);
    return "admin/hoadon/form";
  }

  @PostMapping("/sua/{id}")
  public String suaHoaDon(@PathVariable Long id, @Valid @ModelAttribute("hoaDon") HoaDon hoaDon,
      BindingResult result) {
    if (result.hasErrors()) {
      return "admin/hoadon/form";
    }
    hoaDonService.capNhatHoaDon(id, hoaDon);
    return "redirect:/admin/hoadon";
  }

  @GetMapping("/xoa/{id}")
  public String xoaHoaDon(@PathVariable Long id) {
    hoaDonService.xoaHoaDon(id);
    return "redirect:/admin/hoadon";
  }


  @GetMapping("/chitiet/{id}")
  public String getHoaDonById(@PathVariable("id") Long id, Model model) throws Exception {
    Optional<HoaDon> hoaDon = hoaDonService.findById(id);
    if (hoaDon.isEmpty()) {  // Dùng isEmpty() thay vì so sánh null
      return "/admin/hoadon/404";  // Trang lỗi nếu không tìm thấy hóa đơn
    }
    model.addAttribute("hoaDon", hoaDon.get()); // Lấy đối tượng HoaDon thực tế
    List<HoaDonChiTiet> hoaDonChiTiet =
        hoaDonService.getChiTietHoaDonById(Long.parseLong(id.toString()));
    if (hoaDonChiTiet.isEmpty()) {
      return "/admin/hoadon/404"; // Trang lỗi nếu không tìm thấy hóa đơn
    }
//    model.addAttribute("hoaDonChiTiet", hoaDonChiTiet);
    return "/admin/hoadon/chi-tiet";
  }
}