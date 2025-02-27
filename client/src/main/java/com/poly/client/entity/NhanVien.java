package com.poly.client.entity;

import javax.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "NHAN_VIEN")
public class NhanVien{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ngay_sua")
  private LocalDateTime ngaySua;
  @Column(name = "Ma_nhan_vien")
  private String maNhanVien;

  @Column(name = "ngay_tao")
  private LocalDateTime ngayTao;

  @Column(name = "gioi_tinh")
  private String gioiTinh;

  @Column(name = "ho")
  private String ho;

  @Column(name = "mat_khau")
  private String matKhau;
  private String passwordRaw;

  @Column(name = "ngay_sinh")
  private Instant ngaySinh;

  @Column(name = "sdt")
  private String sdt;

  @Column(name = "email")
  private String email;

  @Column(name = "tai_khoan")
  private String taiKhoan;

  @Column(name = "ten")
  private String ten;

  @Column(name = "ten_dem")
  private String tenDem;

  @Column(name = "trang_thai")
  private Integer trangThai;

//  @OneToOne
//  @JoinColumn(name = "dia_chi_id", referencedColumnName = "id")
//  private DiaChi diaChi;

  @Column(name = "vai_tro")
  private int vaiTro;
//
//  @Override
//  public Collection<? extends GrantedAuthority> getAuthorities() {
//    return List.of(new SimpleGrantedAuthority(vaiTro==1?"ROLE_ADMIN":"ROLE_EMPLOYEE"));
//  }
//
//  @Override
//  public String getPassword() {
//    return getMatKhau();
//  }
//
//  @Override
//  public String getUsername() {
//    return getEmail();
//  }
//
//  @Override
//  public boolean isAccountNonExpired() {
//    return true;
//  }
//
//  @Override
//  public boolean isAccountNonLocked() {
//    return true;
//  }
//
//  @Override
//  public boolean isCredentialsNonExpired() {
//    return true;
//  }
//
//  @Override
//  public boolean isEnabled() {
//    return true;
//  }
}
