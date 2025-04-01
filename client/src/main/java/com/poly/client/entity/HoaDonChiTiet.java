package com.poly.client.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

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
  private SanPhamEntity sanPham; // đổi lại tên cho đúng chuẩn Java

  @ManyToOne
  @JoinColumn(name = "id_sanpham_chitiet", nullable = false)
  private SanPhamChiTietEntity sanPhamChiTiet;

  @Column(name = "so_luong", nullable = false)
  private Integer soLuong;

  @Column(name = "gia", nullable = false)
  private BigDecimal gia;
}
