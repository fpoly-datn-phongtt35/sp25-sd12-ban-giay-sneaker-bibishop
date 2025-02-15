package com.example.datn.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import lombok.*;


@Entity
@Table(name = "dot_giam_gia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DotGiamGia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "don_toi_thieu", precision = 38, scale = 2)
  private BigDecimal donToiThieu;

  @Column(name = "gia_tri_giam", precision = 38, scale = 2)
  private BigDecimal giaTriGiam;

  @Column(name = "giam_toi_da", precision = 38, scale = 2)
  private BigDecimal giamToiDa;

  @Column(name = "loai_voucher")
  private Integer loaiVoucher;

  @Column(name = "ma", length = 255)
  private String ma;

  @Column(name = "so_luong")
  private Integer soLuong;

  @Column(name = "so_lan_su_dung")
  private Integer soLanSuDung;

  @Column(name = "ngay_bat_dau")
  private LocalDateTime ngayBatDau;

  @Column(name = "ngay_ket_thuc")
  private LocalDateTime ngayKetThuc;

  @Column(name = "ngay_sua")
  private LocalDateTime ngaySua;

  @Column(name = "ngay_tao")
  private LocalDateTime ngayTao;

  @Column(name = "ten", length = 255)
  private String ten;

  @Column(name = "trang_thai")
  private Integer trangThai;

  @ManyToOne
  @JoinColumn(name = "phuong_thuc_thanh_toan_id")
  private PhuongThucThanhToan phuongThucThanhToan;
}
