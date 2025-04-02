package com.poly.client.controller.GioHang;

import com.poly.client.entity.SanPhamChiTietEntity;
import com.poly.client.service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class GioHangController {

  @Autowired
  SanPhamChiTietService sanPhamChiTietService;

  @ModelAttribute("cart")
  public List<Map<String, Object>> initializeCart(HttpSession session) {
    if (session.getAttribute("cart") == null) {
      List<Map<String, Object>> cart = new ArrayList<>();
      session.setAttribute("cart", cart);
    }
    return (List<Map<String, Object>>) session.getAttribute("cart");
  }

  @GetMapping("/cart")
  public String showCart(@ModelAttribute("cart") List<Map<String, Object>> cart, Model model) {
    model.addAttribute("cart", cart);
    return "client/cart";
  }

  @PostMapping("/cart/update")
  @ResponseBody
  public void updateQuantity(HttpSession session, @RequestBody Map<String, Integer> payload) {
    List<Map<String, Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
    if (cart == null) return;

    int index = payload.get("index");
    int change = payload.get("change");
    if (index >= 0 && index < cart.size()) {
      int newQuantity = (int) cart.get(index).get("quantity") + change;
      if (newQuantity > 0) {
        cart.get(index).put("quantity", newQuantity);
      }
    }
  }

  @PostMapping("/cart/remove")
  @ResponseBody
  public void removeFromCart(@ModelAttribute("cart") List<Map<String, Object>> cart, @RequestBody Map<String, Integer> payload) {
    int index = payload.get("index");
    if (index >= 0 && index < cart.size()) {
      cart.remove(index);
    }
  }

  @GetMapping("/cart/count")
  @ResponseBody
  public int getCartCount(@ModelAttribute("cart") List<Map<String, Object>> cart) {
    if (cart == null) {
      return 0;
    }
    return cart.size();
  }

  @PostMapping("/cart/add")
  @ResponseBody
  public ResponseEntity<String> addToCart(@ModelAttribute("cart") List<Map<String, Object>> cart, @RequestBody Map<String, Object> payload) {
    int productDetailId = (int) payload.get("productDetailId");
    int quantity = (int) payload.get("quantity");
    for (Map<String, Object> product: cart) {
      if (product.get("productDetailId") != null && product.get("productDetailId").equals(productDetailId)) {
        product.put("quantity", quantity + (int) product.get("quantity"));
        return ResponseEntity.ok("success");
      }
    }
    SanPhamChiTietEntity sanPhamChiTietEntity = sanPhamChiTietService.findById(productDetailId).get();
    cart.add(new HashMap<String, Object>() {{
      put("productDetailId", productDetailId);
      put("quantity", quantity);
      put("name", sanPhamChiTietEntity.getSanPham().getTenSanPham());
      put("color", sanPhamChiTietEntity.getMauSac().getTen());
      put("size", sanPhamChiTietEntity.getKichCo().getTenKichCo());
      put("category", sanPhamChiTietEntity.getDanhMuc().getTenDanhMuc());
      put("price", sanPhamChiTietEntity.getGiaSanPham());
//      put("image", sanPhamChiTietEntity.getHinhAnh().getDuongDan());
      put("image", "https://naidecor.vn/wp-content/uploads/2020/01/ct00192-549k.jpg");
    }});
    return ResponseEntity.ok("success");
  }
}
