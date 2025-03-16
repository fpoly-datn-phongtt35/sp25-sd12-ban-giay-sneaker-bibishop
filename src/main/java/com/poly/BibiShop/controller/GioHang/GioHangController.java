package com.poly.BibiShop.controller.GioHang;
import com.poly.BibiShop.entity.*;
import com.poly.BibiShop.repository.KhachHangRepository;
import com.poly.BibiShop.service.server.HoaDon.EmailService;
import com.poly.BibiShop.service.server.HoaDon.GioHangService;
import com.poly.BibiShop.service.server.HoaDon.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

@Controller
@RequestMapping("/giohang")
public class GioHangController {

  @Autowired
  private GioHangService gioHangService;

  @Autowired
  private HoaDonService hoaDonService;

  @Autowired
  private EmailService emailService;

  @Autowired
  private KhachHangRepository khachHangRepository; // Đảm bảo khai báo đúng

  // Hiển thị giỏ hàng
  @GetMapping
  public String viewCart(@RequestParam("idKhachHang") Integer idKhachHang, Model model) {
    GioHang gioHang = gioHangService.getOrCreateGioHang(idKhachHang);
    model.addAttribute("gioHang", gioHang);
    model.addAttribute("total", gioHangService.calculateTotal(gioHang));
    return "giohang/view";
  }

  // Thêm sản phẩm vào giỏ hàng
  @PostMapping("/add")
  public String addToCart(
      @RequestParam("idKhachHang") Integer idKhachHang,
      @RequestParam("idSanPhamChiTiet") Integer idSanPhamChiTiet,
      @RequestParam("soLuong") Integer soLuong,
      RedirectAttributes redirectAttributes) {
    gioHangService.addToCart(idKhachHang, idSanPhamChiTiet, soLuong);
    redirectAttributes.addFlashAttribute("message", "Thêm sản phẩm thành công!");
    return "redirect:/giohang?idKhachHang=" + idKhachHang;
  }

  // Sửa số lượng sản phẩm
  @PostMapping("/update")
  public String updateQuantity(
      @RequestParam("idGioHangChiTiet") Long idGioHangChiTiet,
      @RequestParam("soLuong") Integer soLuong,
      @RequestParam("idKhachHang") Integer idKhachHang,
      RedirectAttributes redirectAttributes) {
    gioHangService.updateQuantity(idGioHangChiTiet, soLuong);
    redirectAttributes.addFlashAttribute("message", "Cập nhật số lượng thành công!");
    return "redirect:/giohang?idKhachHang=" + idKhachHang;
  }

  // Xóa sản phẩm khỏi giỏ hàng
  @PostMapping("/remove")
  public String removeFromCart(
      @RequestParam("idGioHangChiTiet") Long idGioHangChiTiet,
      @RequestParam("idKhachHang") Integer idKhachHang,
      RedirectAttributes redirectAttributes) {
    gioHangService.removeFromCart(idGioHangChiTiet);
    redirectAttributes.addFlashAttribute("message", "Xóa sản phẩm thành công!");
    return "redirect:/giohang?idKhachHang=" + idKhachHang;
  }

  // Áp dụng mã giảm giá
  @PostMapping("/apply-discount")
  public String applyDiscount(
      @RequestParam("idKhachHang") Integer idKhachHang,
      @RequestParam("maGiamGia") String maGiamGia,
      RedirectAttributes redirectAttributes) {
    GioHang gioHang = gioHangService.getOrCreateGioHang(idKhachHang);
    BigDecimal newTotal = gioHangService.applyDiscount(gioHang, maGiamGia);
    redirectAttributes.addFlashAttribute("message", "Áp dụng mã giảm giá thành công! Bạn được giảm " + (gioHangService.calculateTotal(gioHang).subtract(newTotal)) + "đ");
    return "redirect:/giohang?idKhachHang=" + idKhachHang;
  }

  // Thanh toán và tạo hóa đơn
  @PostMapping("/checkout")
  public String checkout(
      @RequestParam("idKhachHang") Integer idKhachHang,
      @RequestParam("tenNguoiNhan") String tenNguoiNhan,
      @RequestParam("sdt") String sdt,
      @RequestParam("diaChi") String diaChi,
      RedirectAttributes redirectAttributes) {
    GioHang gioHang = gioHangService.getOrCreateGioHang(idKhachHang);
    HoaDon hoaDon = hoaDonService.createHoaDon(gioHang, tenNguoiNhan, sdt, diaChi);

    // Lấy thông tin khách hàng từ repository
    KhachHang khachHang = khachHangRepository.findById(gioHang.getIdKhachHang().longValue())
        .orElseThrow(() -> new RuntimeException("Khách hàng không tồn tại"));

    // Gửi email thông báo đặt hàng
    emailService.sendEmail(khachHang.getEmail(), "Đặt hàng thành công",
        "Chào " + tenNguoiNhan + ",\nĐơn hàng " + hoaDon.getMaHoaDon() + " đã được đặt thành công!\nTổng tiền: " + hoaDon.getTongTien() + "đ");

    redirectAttributes.addFlashAttribute("message", "Đặt hàng thành công!");
    return "redirect:/hoadon/list";
  }
}