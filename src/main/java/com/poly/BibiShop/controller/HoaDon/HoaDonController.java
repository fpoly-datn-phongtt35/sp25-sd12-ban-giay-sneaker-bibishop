package com.poly.BibiShop.controller.HoaDon;

import com.poly.BibiShop.entity.GioHang;
import com.poly.BibiShop.entity.HoaDon;
import com.poly.BibiShop.service.server.HoaDon.EmailService;
import com.poly.BibiShop.service.server.HoaDon.GioHangService;
import com.poly.BibiShop.service.server.HoaDon.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/admin/")
public class HoaDonController {

  @Autowired
  private HoaDonService hoaDonService;

  @Autowired
  private EmailService emailService;
  @Autowired
  private GioHangService gioHangService;

  // Danh sách hóa đơn
  @GetMapping("hoadon/list")
  public String listHoaDon(
      @RequestParam(name = "page", defaultValue = "1") int page,
      @RequestParam(name = "size", defaultValue = "5") int size,
      Model model) {
    Page<HoaDon> hoaDonPage = hoaDonService.findAll(PageRequest.of(page - 1, size));
    model.addAttribute("list", hoaDonPage);
    return "admin/hoadon/list";
  }

  // Xem chi tiết và cập nhật trạng thái hóa đơn
  @GetMapping("hoadon/view/{id}")
  public String viewHoaDon(@PathVariable Long id, Model model) {
    HoaDon hoaDon = hoaDonService.findById(id)
        .orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại"));
    model.addAttribute("hoaDon", hoaDon);
    return "admin/hoadon/view";
  }

  // Cập nhật trạng thái hóa đơn
  @PostMapping("/update-status/{id}")
  public String updateStatus(
      @PathVariable Long id,
      @RequestParam("trangThai") String trangThai,
      RedirectAttributes redirectAttributes) {
    hoaDonService.updateTrangThai(id, trangThai);

    HoaDon hoaDon = hoaDonService.findById(id).get();
    emailService.sendEmail(hoaDon.getKhachHang().getEmail(), "Cập nhật trạng thái đơn hàng",
        "Chào " + hoaDon.getTenKhachhang() + ",\nĐơn hàng " + hoaDon.getMaHoaDon() + " đã được cập nhật trạng thái: " + trangThai);

    redirectAttributes.addFlashAttribute("message", "Cập nhật trạng thái thành công!");
    return "redirect:/admin/hoadon/list";
  }

  // Xuất hóa đơn
  @GetMapping("hoadon/export/{id}")
  public String exportHoaDon(@PathVariable Long id, Model model) {
    HoaDon hoaDon = hoaDonService.findById(id)
        .orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại"));
    model.addAttribute("hoaDon", hoaDon);
    return "admin/hoadon/export";
  }

  @PostMapping("HoaDon/create")
  public String createHoaDon(
      @RequestParam("idKhachHang") Integer idKhachHang,
      @RequestParam("tenNguoiNhan") String tenNguoiNhan,
      @RequestParam("sdt") String sdt,
      @RequestParam("diaChi") String diaChi,
      RedirectAttributes redirectAttributes) {
    // Lấy giỏ hàng từ idKhachHang (giả định có GioHangService)
    GioHang gioHang = gioHangService.getOrCreateGioHang(idKhachHang);
    HoaDon hoaDon = hoaDonService.createHoaDon(gioHang, tenNguoiNhan, sdt, diaChi);
    redirectAttributes.addFlashAttribute("message", "Hóa đơn đã được tạo thành công với mã: " + hoaDon.getMaHoaDon());
    return "redirect:/hoadon/list";
  }
}