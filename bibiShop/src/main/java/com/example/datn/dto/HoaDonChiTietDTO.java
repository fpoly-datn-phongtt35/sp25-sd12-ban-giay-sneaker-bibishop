package com.example.datn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HoaDonChiTietDTO {
  private Long id;
  private BigDecimal donGia;
  private String ghiChu;
  private LocalDateTime ngayTao;
  private LocalDateTime ngaySua;
  private String nguoiTao;
  private String nguoiSua;
  private Integer soLuong;
  private Integer trangThai;
  private Long chiTietSanPhamId;
  private Long hoaDonId;
}
