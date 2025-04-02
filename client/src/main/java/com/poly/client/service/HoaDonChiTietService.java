package com.poly.client.service;

import com.poly.client.entity.HoaDon;
import com.poly.client.entity.HoaDonChiTiet;
import com.poly.client.repository.HoaDonChiTietRepository;

import java.util.List;
import java.util.Optional;

public class HoaDonChiTietService {

  private HoaDonChiTietRepository hoaDonChiTietRepository;

  public List<HoaDonChiTiet> getByHoaDonId(Long hoaDonId) {
    return hoaDonChiTietRepository.findByHoaDonId(hoaDonId);
  }

  public HoaDonChiTiet getHoaDonChiTietById(Long id) {
    Optional<HoaDonChiTiet> hoaDonChiTiet = hoaDonChiTietRepository.findById(id);
    return hoaDonChiTiet.orElseThrow(() -> new RuntimeException("HoaDonChiTiet not found"));
  }
  public HoaDonChiTiet updateHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) {
    // Assuming the HoaDonChiTiet exists, we save it again
    return hoaDonChiTietRepository.save(hoaDonChiTiet);
  }

  public void deleteHoaDonChiTiet(Long id) {
    hoaDonChiTietRepository.deleteById(id);
  }

  public HoaDonChiTiet saveHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) {
    // If HoaDon is not null, set it (assuming it is not already set)
    if (hoaDonChiTiet.getHoaDon() != null) {
      HoaDon hoaDon = hoaDonChiTietRepository.findById(
              Long.valueOf(hoaDonChiTiet.getHoaDon().getId()))
          .orElseThrow(() -> new RuntimeException("HoaDon not found")).getHoaDon();
      hoaDonChiTiet.setHoaDon(hoaDon);
    }
    return hoaDonChiTietRepository.save(hoaDonChiTiet);
  }

}
