package com.poly.BibiShop.controller.Magiamgia;


import com.poly.BibiShop.controller.Magiamgia.dto.CreatePercentageDiscountDTO;
import com.poly.BibiShop.controller.Magiamgia.dto.CreateValueDiscountDTO;
import com.poly.BibiShop.entity.MaGiamGia;
import com.poly.BibiShop.repository.impl.hoadon.Server.MaGiamGiaRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/")
@RequiredArgsConstructor
public class MaGiamGiaController {

  private final MaGiamGiaRepository maGiamGiaRepository;


  @GetMapping("MaGiamGia/list")
  public String getAllvoucher(Model model,
      @RequestParam(name = "page", defaultValue = "1") int page,
      @RequestParam(name = "size", defaultValue = "5") int size) {

    Page<MaGiamGia> maGiamGiaPage = maGiamGiaRepository.findAllMaGiamGia(PageRequest.of(page - 1, size));

    // Check and update status based on expiration date
    LocalDate currentDate = LocalDate.now();
    for (MaGiamGia voucher : maGiamGiaPage.getContent()) {
      if (voucher.getNgayKetThuc() != null && currentDate.isAfter(voucher.getNgayKetThuc().toLocalDate())) {
        if (voucher.getTrangThai() != 0) { // Only update if not already inactive
          voucher.setTrangThai(0);
          maGiamGiaRepository.save(voucher); // Persist the change
        }
      }
    }
    // Add updated page to model
    model.addAttribute("list", maGiamGiaPage);
    return "admin/MaGiamGia/list";
  }


  @GetMapping("MaGiamGia/add")
  public String addMaGiamGia(Model model) {
    model.addAttribute("percentageDiscount", new CreatePercentageDiscountDTO());
    model.addAttribute("valueDiscount", new CreateValueDiscountDTO());
    return "admin/MaGiamGia/add";
  }
  @PostMapping("MaGiamGia/add/percentage")
  public String addPercentageDiscount(
      @ModelAttribute("percentageDiscount") CreatePercentageDiscountDTO dto,
      BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      redirectAttributes.addFlashAttribute("message", "Có lỗi khi nhập thông tin.");
      redirectAttributes.addFlashAttribute("messageType", "error");
      return "admin/MaGiamGia/add";
    }
    try {
      MaGiamGia newMaGiamGia = new MaGiamGia();
      newMaGiamGia.setTen(dto.getTen());
      newMaGiamGia.setMa(dto.getMa() != null && !dto.getMa().isEmpty() ? dto.getMa() : generateRandomCode());
      newMaGiamGia.setGiaTriGiam(dto.getPhanTramGiam());
      newMaGiamGia.setGiamToiDa(dto.getGiamToiDa());
      newMaGiamGia.setSoLuong(dto.getSoLuong());
      newMaGiamGia.setLoaiVoucher(1);
      newMaGiamGia.setNgayBatDau(dto.getNgayBatDau());
      newMaGiamGia.setNgayKetThuc(dto.getNgayKetThuc());
      newMaGiamGia.setNgayTao(Date.valueOf(LocalDate.now()));
      newMaGiamGia.setTrangThai(1);

      maGiamGiaRepository.save(newMaGiamGia);
      redirectAttributes.addFlashAttribute("message", "Thêm mã giảm giá theo phần trăm thành công!");
      redirectAttributes.addFlashAttribute("messageType", "success");
      return "redirect:/admin/MaGiamGia/list";
    } catch (Exception e) {
      // Log the exception for debugging
      e.printStackTrace();
      redirectAttributes.addFlashAttribute("message",
          "Lỗi khi thêm mã giảm giá: " + e.getMessage());
      redirectAttributes.addFlashAttribute("messageType", "error");
      return "admin/MaGiamGia/add";
    }
  }

  @PostMapping("MaGiamGia/add/value")
  public String addValueDiscount(
      @ModelAttribute("valueDiscount") CreateValueDiscountDTO dto,
      BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      redirectAttributes.addFlashAttribute("message", "Có lỗi khi nhập thông tin.");
      redirectAttributes.addFlashAttribute("messageType", "error");
      return "admin/MaGiamGia/add";
    }

    try {
      MaGiamGia newMaGiamGia = new MaGiamGia();
      newMaGiamGia.setTen(dto.getTen());
      newMaGiamGia.setMa(
          dto.getMa() != null && !dto.getMa().isEmpty() ? dto.getMa() : generateRandomCode());
      newMaGiamGia.setGiaTriGiam(dto.getGiaTriGiam());
      newMaGiamGia.setDonToiThieu(dto.getDonToiThieu());
      newMaGiamGia.setSoLuong(dto.getSoLuong());
      newMaGiamGia.setLoaiVoucher(0);
      newMaGiamGia.setNgayBatDau(dto.getNgayBatDau());
      newMaGiamGia.setNgayKetThuc(dto.getNgayKetThuc());
      newMaGiamGia.setNgayTao(Date.valueOf(LocalDate.now()));
      newMaGiamGia.setTrangThai(1);

      maGiamGiaRepository.save(newMaGiamGia);
      redirectAttributes.addFlashAttribute("message", "Thêm mã giảm giá theo giá trị thành công!");
      redirectAttributes.addFlashAttribute("messageType", "success");
      return "redirect:/admin/MaGiamGia/list";
    } catch (Exception e) {
      // Log the exception for debugging
      e.printStackTrace();
      redirectAttributes.addFlashAttribute("message",
          "Lỗi khi thêm mã giảm giá: " + e.getMessage());
      redirectAttributes.addFlashAttribute("messageType", "error");
      return "redirect:/admin/MaGiamGia/list";
    }
  }

  private String generateRandomCode() {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random random = new Random();
    StringBuilder code = new StringBuilder();
    for (int i = 0; i < 8; i++) {
      code.append(characters.charAt(random.nextInt(characters.length())));
    }
    return code.toString();
  }
  @PostMapping("MaGiamGia/delete/{id}")
  public String delete(@PathVariable int id) {
    try {
      Optional<MaGiamGia> newMgiamgia = maGiamGiaRepository.findById((long) id);
      MaGiamGia magiamGia = newMgiamgia.get();
      if (magiamGia.getTrangThai() == 1){
        magiamGia.setTrangThai(0);
        maGiamGiaRepository.save(magiamGia);
      }else {
        magiamGia.setTrangThai(1);
        maGiamGiaRepository.save(magiamGia);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:/admin/MaGiamGia/list";
  }



}