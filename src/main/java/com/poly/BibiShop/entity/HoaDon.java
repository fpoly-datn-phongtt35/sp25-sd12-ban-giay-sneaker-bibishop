package com.poly.BibiShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "hoa_don")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ma_hoa_don", nullable = false)
  private String maHoaDon;

  @ManyToOne
  @JoinColumn(name = "id_khach_hang", referencedColumnName = "id", nullable = false)
  private KhachHang khachHang;  // Đây là khóa ngoại, không cần thêm idKhachHang riêng

  @Column(name = "ngay_tao", nullable = false)
  private LocalDateTime ngayTao = LocalDateTime.now();

  @Column(name = "tong_tien", nullable = false)
  private BigDecimal tongTien;

  @Column(name = "trang_thai", nullable = false)
  private String trangThai;

  @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<HoaDonChiTiet> chiTietHoaDon;
}
