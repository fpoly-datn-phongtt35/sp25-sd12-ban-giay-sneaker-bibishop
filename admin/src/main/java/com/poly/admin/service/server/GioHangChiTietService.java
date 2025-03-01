package com.poly.admin.service.server;

import com.poly.admin.entity.GiamGiaSanPham;
import com.poly.admin.entity.GioHangChiTiet;
import com.poly.admin.repository.impl.hoadon.Client.GioHangChiTietRepository;
import com.poly.admin.repository.impl.hoadon.Server.GiamGiaSanPhamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GioHangChiTietService {
  private final GioHangChiTietRepository chiTietRepository;
  private final GiamGiaSanPhamRepository giamGiaSanPhamRepository;

  public GioHangChiTiet apDunggiamGiaSanPham(Integer chiTietId, Long idGiamGia) {
    GioHangChiTiet chiTiet = chiTietRepository.findById(chiTietId)
        .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));

    GiamGiaSanPham giamGia = giamGiaSanPhamRepository.findById(idGiamGia)
        .orElseThrow(() -> new RuntimeException("Giảm giá không hợp lệ"));

    chiTiet.setGiamGiaSanPham(giamGia);
    return chiTietRepository.save(chiTiet);
  }
}

