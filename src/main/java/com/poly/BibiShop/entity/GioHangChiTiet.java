package com.poly.BibiShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Table(name = "gio_hang_chi_tiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GioHangChiTiet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_giohang", nullable = false)
  private GioHang gioHang;

  @Column(name = "id_sanpham", nullable = false)
  private Integer idSanPham;

  @Column(name = "so_luong", nullable = false)
  private Integer soLuong;

  @Column(name = "gia", nullable = false)
  private BigDecimal gia;
  /*
giá sẽ bằng giá sản phẩm chi tiết
*/

  // Quan hệ với giảm giá theo sản phẩm
  @ManyToOne
  @JoinColumn(name = "id_giamgiasanpham")
  private GiamGiaSanPham giamGiaSanPham;
}

