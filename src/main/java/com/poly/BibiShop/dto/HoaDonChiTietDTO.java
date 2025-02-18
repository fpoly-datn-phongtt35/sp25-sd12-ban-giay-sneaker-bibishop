package com.poly.BibiShop.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
