package com.poly.client.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dia_chi")
public class DiaChi {

  @Id
  private Long id;

  @Column(name = "dia_chi", length = 255)
  private String diaChi;

  @Column(name = "dia_chi_cu_the", length = 255)
  private String diaChiCuThe;

  @Column(name = "ho_va_ten", length = 255)
  private String hoVaTen;

  @Column(name = "ngay_sua")
  private LocalDateTime ngaySua;

  @Column(name = "ngay_tao")
  private LocalDateTime ngayTao;

  @Column(name = "phuong_xa", length = 255)
  private String phuongXa;

  @Column(name = "quan_huyen", length = 255)
  private String quanHuyen;

  @Column(name = "so_dien_thoai", length = 255)
  private String soDienThoai;

  @Column(name = "thanh_pho", length = 255)
  private String thanhPho;

  @Column(name = "trang_thai", nullable = false)
  private Integer trangThai;

  // Getters and Setters
}
