package com.example.datn.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SanPham")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SanPham extends SuperEntity {

    @Column(name = "tenSanPham", length = 150, nullable = false, columnDefinition = "NVARCHAR(255)")
    private String tenSanPham;

    @Column(name = "trangThai", length = 10, nullable = false)
    private int trangThai;
    @JsonIgnore
    @OneToMany(mappedBy = "sanPham")
    @ToString.Exclude
    private List<SanPhamChiTiet> sanPhamChiTiets = new ArrayList<SanPhamChiTiet>();


}





