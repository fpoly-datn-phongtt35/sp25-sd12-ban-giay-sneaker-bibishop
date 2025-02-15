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
@Table(name = "kichCo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KichCo extends SuperEntity {

    @Column(name = "tenKichCo", length = 120, nullable = false,columnDefinition = "NVARCHAR(255)")
    private String tenKichCo;
    @Column(name = "doDai", length = 150, nullable = false,columnDefinition = "NVARCHAR(255)")
    private String doDai;
    @JsonIgnore
    @OneToMany(mappedBy = "kichCo")
    @ToString.Exclude
    private List<SanPhamChiTiet> sanPhamChiTiets = new ArrayList<SanPhamChiTiet>();
}
