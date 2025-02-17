package com.poly.BibiShop.controller;


import com.poly.BibiShop.entity.HoaDon;
import com.poly.BibiShop.entity.HoaDonChiTiet;
import com.poly.BibiShop.service.server.HoaDonService;
import jakarta.validation.Valid;
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

  private final HoaDonService hoaDonService;

  @GetMapping
  public String danhSachHoaDon(Model model) {
    List<HoaDon> danhSach = hoaDonService.layTatCa();
    model.addAttribute("danhSachHoaDon", danhSach);
    return "admin/adminWeb/hoadon/danh-sach";
  }

  @GetMapping("/them")
  public String formThemHoaDon(Model model) {
    model.addAttribute("hoaDon", new HoaDon());
    return "admin/adminWeb/hoadon/danh-sach";
  }

  @PostMapping("/them")
  public String themHoaDon(@Valid @ModelAttribute("hoaDon") HoaDon hoaDon, BindingResult result) {
    if (result.hasErrors()) {
      return "admin/adminWeb/hoadon/form";
    }
    hoaDonService.themHoaDon(hoaDon);
    return "redirect:/admin/adminWeb/hoadon";
  }

  @GetMapping("/sua/{id}")
  public String formSuaHoaDon(@PathVariable Long id, Model model) {
    HoaDon hoaDon = hoaDonService.layTheoId(id);
    model.addAttribute("hoaDon", hoaDon);
    return "admin/adminWeb/hoadon/form";
  }

  @PostMapping("/sua/{id}")
  public String suaHoaDon(@PathVariable Long id, @Valid @ModelAttribute("hoaDon") HoaDon hoaDon,
      BindingResult result) {
    if (result.hasErrors()) {
      return "admin/adminWeb/hoadon/form";
    }
    hoaDonService.capNhatHoaDon(id, hoaDon);
    return "redirect:/admin/adminWeb/hoadon";
  }

  @GetMapping("/xoa/{id}")
  public String xoaHoaDon(@PathVariable Long id) {
    hoaDonService.xoaHoaDon(id);
    return "redirect:/admin/adminWeb/hoadon";
  }


  @GetMapping("/chitiet/{id}")
  public String getHoaDonById(@PathVariable("id") Long id, Model model) throws Exception {
    Optional<HoaDon> hoaDon = hoaDonService.findById(id);
    if (hoaDon.isEmpty()) {  // Dùng isEmpty() thay vì so sánh null
      return "error"; // Trang lỗi nếu không tìm thấy hóa đơn
    }
    model.addAttribute("hoaDon", hoaDon.get()); // Lấy đối tượng HoaDon thực tế
    List<HoaDonChiTiet> hoaDonChiTiet =
        hoaDonService.getChiTietHoaDonById(Long.parseLong(id.toString()));
    if (hoaDonChiTiet.isEmpty()){
      return "error"; // Trang lỗi nếu không tìm thấy hóa đơn
    }
//    model.addAttribute("hoaDonChiTiet", hoaDonChiTiet);
    return "/admin/adminWeb/hoadon/chi-tiet";
  }
}