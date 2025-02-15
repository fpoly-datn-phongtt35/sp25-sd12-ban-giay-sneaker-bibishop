package com.example.datn.entity;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;
import lombok.*;

@Entity
@Table(name = "khach_hang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  private Date ngaySua;

  @Temporal(TemporalType.TIMESTAMP)
  private Date ngayTao;

  @Column(name = "gioi_tinh")
  private Integer gioiTinh;

  @Column(name = "ho")
  private String ho;

  @Column(name = "mat_khau")
  private String matKhau;

  @Temporal(TemporalType.DATE)
  @Column(name = "ngay_sinh")
  private Date ngaySinh;

  @Column(name = "sdt")
  private String sdt;


  @Column(name = "ten")
  private String ten;

  @Column(name = "ten_dem")
  private String tenDem;

  @Column(name = "trang_thai")
  private Integer trangThai;

  @ManyToOne
  @JoinColumn(name = "dia_chi_id")
  private DiaChi diaChi;

  @Column(name = "vai_tro")
  private Integer vaiTro;
}
