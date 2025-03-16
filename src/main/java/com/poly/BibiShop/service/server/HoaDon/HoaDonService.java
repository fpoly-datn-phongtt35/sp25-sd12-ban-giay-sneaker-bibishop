package com.poly.BibiShop.service.server.HoaDon;

import com.poly.BibiShop.entity.*;
import com.poly.BibiShop.repository.KhachHangRepository;
import com.poly.BibiShop.repository.SanPhamChiTietRepository;
import com.poly.BibiShop.repository.GioHangRepository;
import com.poly.BibiShop.repository.HoaDonChiTietRepository;
import com.poly.BibiShop.repository.HoaDonRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HoaDonService {
  public final SanPhamChiTietRepository sanPhamChiTietRepository;


  private final HoaDonRepository hoaDonRepository;

  private final HoaDonChiTietRepository hoaDonChiTietRepository;

  private final GioHangRepository gioHangRepository;


  public final KhachHangRepository getKhachHangRepository;

  public HoaDonService(SanPhamChiTietRepository sanPhamChiTietRepository,
      HoaDonRepository hoaDonRepository, HoaDonChiTietRepository hoaDonChiTietRepository,
      GioHangRepository gioHangRepository, KhachHangRepository getKhachHangRepository) {
    this.sanPhamChiTietRepository = sanPhamChiTietRepository;
    this.hoaDonRepository = hoaDonRepository;
    this.hoaDonChiTietRepository = hoaDonChiTietRepository;
    this.gioHangRepository = gioHangRepository;
    this.getKhachHangRepository = getKhachHangRepository;
  }

  public Optional<HoaDon> findById(Long id) {
    return hoaDonRepository.findById(id);
  }
  // Phương thức findAll để lấy danh sách hóa đơn phân trang
  public Page<HoaDon> findAll(Pageable pageRequest) {
    return hoaDonRepository.findAll(pageRequest);
  }
  // Tạo hóa đơn từ giỏ hàng
  public HoaDon createHoaDon(GioHang gioHang, String tenNguoiNhan, String sdt, String diaChi) {
    HoaDon hoaDon = new HoaDon();
    hoaDon.setMaHoaDon("HD" + System.currentTimeMillis());

    // Tìm khách hàng từ idKhachHang
    KhachHang khachHang = getKhachHangRepository.findById(gioHang.getIdKhachHang().longValue())
        .orElseThrow(() -> new RuntimeException("Khách hàng không tồn tại"));
    hoaDon.setKhachHang(khachHang); // Sửa lỗi: Gán đối tượng KhachHang thay vì ID

    hoaDon.setNgayTao(LocalDateTime.now());
    hoaDon.setTongTien(calculateTotal(gioHang));
    hoaDon.setTrangThai("CHO_XAC_NHAN");
    hoaDon.setTenKhachhang(tenNguoiNhan);
    hoaDon.setSdtKhachhang(sdt);
    hoaDon.setDiaChi(diaChi);

// Tạo chi tiết hóa đơn từ giỏ hàng
    for (GioHangChiTiet item : gioHang.getChiTietGioHang()) {
      HoaDonChiTiet chiTiet = new HoaDonChiTiet();
      chiTiet.setHoaDon(hoaDon);

      // Tìm SanPhamChiTietEntity từ idSanPham
      SanPhamChiTietEntity sanPhamChiTiet = sanPhamChiTietRepository.findById(item.getIdSanPham())
          .orElseThrow(() -> new RuntimeException("Sản phẩm chi tiết không tồn tại"));
      chiTiet.setSanPhamChiTiet(sanPhamChiTiet); // Sửa lỗi: Gán đối tượng SanPhamChiTietEntity

      // Gán sản phẩm (SanPhamEntity) từ SanPhamChiTietEntity
      chiTiet.setSanPham(sanPhamChiTiet.getSanPham());

      chiTiet.setSoLuong(item.getSoLuong());
      chiTiet.setGia(item.getGia());
      hoaDon.getChiTietHoaDon().add(chiTiet);
    }

    gioHang.setTrangThai(TrangThaiGioHang.HOAN_THANH);
    gioHangRepository.save(gioHang);
    return hoaDonRepository.save(hoaDon);
  }

  // Cập nhật trạng thái hóa đơn
  public void updateTrangThai(Long idHoaDon, String trangThai) {
    HoaDon hoaDon = hoaDonRepository.findById(idHoaDon)
        .orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại"));
    hoaDon.setTrangThai(trangThai);
    hoaDonRepository.save(hoaDon);
  }

  // Tính tổng tiền hóa đơn
  public BigDecimal calculateTotal(HoaDon hoaDon) {
    return hoaDon.getChiTietHoaDon().stream()
        .map(item -> item.getGia().multiply(BigDecimal.valueOf(item.getSoLuong())))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public BigDecimal calculateTotal(GioHang gioHang) {
    return gioHang.getChiTietGioHang().stream()
        .map(item -> item.getGia().multiply(BigDecimal.valueOf(item.getSoLuong())))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

}

