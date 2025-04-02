package com.poly.client.dto;

import com.poly.client.entity.HoaDon;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HoaDonDTO {

  private int id;
  private Long khachHangId;
  private String ghiChu;
  private BigDecimal giamGia;
  private String loaiHoaDon;
  private String hinhThucThanhToan;
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

  private List<HoaDonChiTietDTO> hoaDonChiTiets;

  public static HoaDonDTO from(HoaDon hoaDon) {
    HoaDonDTO dto = new HoaDonDTO();
    dto.setId(hoaDon.getId());
    return dto;
  }

}
