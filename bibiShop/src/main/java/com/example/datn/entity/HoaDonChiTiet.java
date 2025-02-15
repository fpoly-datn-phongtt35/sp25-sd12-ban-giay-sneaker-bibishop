package com.example.datn.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.*;

@Entity
@Table(name = "hoa_don_chi_tiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonChiTiet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_hoadon", nullable = false)
  private HoaDon hoaDon;

  @ManyToOne
  @JoinColumn(name = "id_sanpham", nullable = false)
  private SanPham sanPham; // đổi lại tên cho đúng chuẩn Java

  @ManyToOne
  @JoinColumn(name = "id_sanpham_chitiet", nullable = false)
  private SanPhamChiTiet sanPhamChiTiet;

  @Column(name = "so_luong", nullable = false)
  private Integer soLuong;

  @Column(name = "gia", nullable = false)
  private BigDecimal gia;
}
