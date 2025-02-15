package com.example.datn.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.*;





@Entity
@Table(name = "phuong_thuc_thanh_toan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhuongThucThanhToan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String ma;

  @Temporal(TemporalType.TIMESTAMP)
  private Date ngaySua;

  @Temporal(TemporalType.TIMESTAMP)
  private Date ngayTao;

  private String ten;
  private Integer trangThai;
}
