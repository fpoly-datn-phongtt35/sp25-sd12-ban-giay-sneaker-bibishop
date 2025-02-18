package com.poly.BibiShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





@Entity
@Table(name = "giam_gia_san_pham")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GiamGiaSanPham {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "id_sanpham", nullable = false)
  private Integer idSanPham;

  @Column(name = "phan_tram_giam", nullable = false)
  private Integer phanTramGiam;

  @Column(name = "gia_tri_giam")
  private Integer giaTriGiam;
}
