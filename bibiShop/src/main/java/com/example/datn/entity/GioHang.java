package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "gio_hang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GioHang {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "id_khachhang", nullable = false)
  private Integer idKhachHang;

  @Column(name = "ngay_tao", nullable = false)
  private LocalDateTime ngayTao = LocalDateTime.now();

  @Column(name = "trang_thai", nullable = false)
  @Enumerated(EnumType.STRING)
  private TrangThaiGioHang trangThai;

  // Quan hệ với Mã giảm giá
  @ManyToOne
  @JoinColumn(name = "id_magiamgia")
  private MaGiamGia maGiamGia;

  // Quan hệ với Đợt giảm giá
  @ManyToOne
  @JoinColumn(name = "id_dotgiamgia")
  private DotGiamGia dotGiamGia;

  @OneToMany(mappedBy = "gioHang", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<GioHangChiTiet> chiTietGioHang;
}


enum TrangThaiGioHang {
  CHUA_THANH_TOAN, DA_THANH_TOAN, HUY
}