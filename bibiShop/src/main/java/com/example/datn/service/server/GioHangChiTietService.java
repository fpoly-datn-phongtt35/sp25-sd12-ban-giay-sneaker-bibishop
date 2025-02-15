package com.example.datn.service.server;

import com.example.datn.Repository.HoaDon.Client.GioHangChiTietRepository;
import com.example.datn.Repository.HoaDon.Server.GiamGiaSanPhamRepository;
import com.example.datn.entity.GiamGiaSanPham;
import com.example.datn.entity.GioHangChiTiet;
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

