package com.example.datn.service.server;



import com.example.datn.Repository.HoaDon.Server.HoaDonChiTietRepository;
import com.example.datn.Repository.HoaDon.Server.HoaDonRepository;
import com.example.datn.entity.HoaDon;
import com.example.datn.entity.HoaDonChiTiet;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HoaDonService {

  @Autowired
  private final HoaDonChiTietRepository hoaDonChiTietRepository;
  private final HoaDonRepository hoaDonRepository;

  public List<HoaDon> layTatCa() {
    return hoaDonRepository.findAll();
  }

  public HoaDon layTheoId(Long id) {
    return hoaDonRepository.findById(id).orElse(null);
  }

  public void themHoaDon(HoaDon hoaDon) {
    hoaDonRepository.save(hoaDon);
  }

  public void capNhatHoaDon(Long id, HoaDon hoaDon) {
    if (hoaDonRepository.existsById(id)) {
      hoaDon.setId(id);
      hoaDonRepository.save(hoaDon);
    }
  }

  public void xoaHoaDon(Long id) {
    hoaDonRepository.deleteById(id);
  }

  public Optional<HoaDon> findById(Long id) {
    return hoaDonRepository.findById(id);
  }

  public List<HoaDonChiTiet> getChiTietHoaDonById(Long hoaDonId) {
    return hoaDonChiTietRepository.findByHoaDonId(hoaDonId);
  }

}
