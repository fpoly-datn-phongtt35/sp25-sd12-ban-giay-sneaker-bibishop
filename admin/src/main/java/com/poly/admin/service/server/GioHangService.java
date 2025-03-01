package com.poly.BibiShop.service.server;

import com.poly.BibiShop.entity.GioHang;
import com.poly.BibiShop.entity.MaGiamGia;
import com.poly.BibiShop.repository.impl.hoadon.Client.GioHangRepository;
import com.poly.BibiShop.repository.impl.hoadon.Server.MaGiamGiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class GioHangService {

  private final GioHangRepository gioHangRepository;
  private final MaGiamGiaRepository maGiamGiaRepository;

  public GioHang apDungGiamgia(Integer gioHangId, String maVoucher) {
    GioHang gioHang = gioHangRepository.findById(gioHangId)
        .orElseThrow(() -> new RuntimeException("Giỏ hàng không tồn tại"));

    MaGiamGia maGiamGia = maGiamGiaRepository.findByMa(maVoucher)
        .orElseThrow(() -> new RuntimeException("Mã giảm giá không hợp lệ"));

    ((GioHang) gioHang).setMaGiamGia(maGiamGia);
    return gioHangRepository.save(gioHang);
  }

    // Tạo giỏ hàng mới
    public GioHang taoGioHang(GioHang gioHang) {
      return gioHangRepository.save(gioHang);
    }

    // Lấy danh sách tất cả giỏ hàng
    public ArrayList<GioHang> layTatCaGioHang() {
      return (ArrayList<GioHang>) gioHangRepository.findAll();
    }

    // Lấy giỏ hàng theo ID
    public GioHang layGioHangTheoId(Integer id) {
      return gioHangRepository.findById(id)
          .orElseThrow(() -> new RuntimeException("Giỏ hàng không tồn tại"));
    }

    // Cập nhật giỏ hàng
    public GioHang capNhatGioHang(Integer id, GioHang gioHangMoi) {
      GioHang gioHang = layGioHangTheoId(id);
      gioHang.setTrangThai(gioHangMoi.getTrangThai());
      return gioHangRepository.save(gioHang);
    }

    // Xóa giỏ hàng
    public void xoaGioHang(Integer id) {
      gioHangRepository.deleteById(id);
    }
}

