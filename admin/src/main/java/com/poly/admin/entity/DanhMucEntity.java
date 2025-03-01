package com.poly.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "DanhMuc")
public class DanhMucEntity extends SuperEntity{


    @Column(name = "tenDanhMuc", length = 20, nullable = false,columnDefinition = "NVARCHAR(255)")
    private String tenDanhMuc;

    @JsonIgnore
    @OneToMany(mappedBy = "danhMuc")
    @ToString.Exclude
    private List<SanPhamChiTietEntity> sanPhamChiTiets = new ArrayList<SanPhamChiTietEntity>();
}
