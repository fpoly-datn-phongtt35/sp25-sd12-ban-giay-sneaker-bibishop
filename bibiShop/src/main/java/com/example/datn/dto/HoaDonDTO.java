package com.example.datn.dto;

import com.example.datn.entity.DotGiamGia;
import com.example.datn.entity.MaGiamGia;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HoaDonDTO {

  private int id;
  private String SanPhamchitiet_id;
  private int soLuong;
  private DotGiamGia dotGiamGia;
  private BigDecimal thanhTien;
  private BigDecimal tongTien;
  private Long khachHangId;
  private String ghiChu;
  private BigDecimal giamGia;
  private Integer loaiHoaDon;
  private String maHoaDon;
  private LocalDateTime ngayNhan;
  private LocalDateTime ngayNhanDuKien;
  private LocalDateTime ngayShip;
  private LocalDateTime ngaySua;
  private LocalDateTime ngayTao;
  private String diaChi;
  private String soDienThoai;
  private String tenNguoiNhan;
  private String trangThai;

}
