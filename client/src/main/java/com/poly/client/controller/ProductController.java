package com.poly.client.controller;

import com.poly.client.entity.SanPhamChiTietEntity;
import com.poly.client.entity.SanPhamEntity;
import com.poly.client.service.ChatLieuService;
import com.poly.client.service.DanhMucService;
import com.poly.client.service.MauSacService;
import com.poly.client.service.SanPhamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.math3.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ProductController {

  private final DanhMucService danhMucService;

  final SanPhamService sanPhamService;

  final MauSacService mauSacService;

  final ChatLieuService chatLieuService;

  @GetMapping("/product")
  public String product(Model model) {
    model.addAttribute("danhMuc", danhMucService.findAll());
    model.addAttribute("chatLieu", chatLieuService.getAllChatLieu());
    model.addAttribute("mauSac", mauSacService.getAllMauSac());
    return "client/shop-product";
  }

  @GetMapping("/product-detail/{id}")
  public String product(@PathVariable Integer id, Model model) {
    SanPhamEntity sanPhamEntity = sanPhamService.findById(id);
    model.addAttribute("id", id);
    model.addAttribute("product", sanPhamEntity);

    Map<String, List<Pair<String, Pair<Integer, BigDecimal>>>> priceMap = new HashMap<>();
    for (SanPhamChiTietEntity sanPhamChiTiet: sanPhamEntity.getSanPhamChiTiets()) {
      if (sanPhamChiTiet.getTrangThai() == 1 && sanPhamChiTiet.getSoLuong() > 0) {
        priceMap.putIfAbsent(sanPhamChiTiet.getMauSac().getTen(), new ArrayList<>());
        priceMap.get(sanPhamChiTiet.getMauSac().getTen()).add(
            new Pair<>(sanPhamChiTiet.getKichCo().getTenKichCo(),
                new Pair<>(sanPhamChiTiet.getId(), sanPhamChiTiet.getGiaSanPham())));
      }
    }

    model.addAttribute("priceMap", priceMap);

    return "client/product-detail";
  }

}
