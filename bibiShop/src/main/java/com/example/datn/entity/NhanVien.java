package com.example.datn.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.*;




@Entity
@Table(name = "nhan_vien")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  private Date ngaySua;

  @Temporal(TemporalType.TIMESTAMP)
  private Date ngayTao;

  private Integer gioiTinh;
  private String ho;
  private String matKhau;

}