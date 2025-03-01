package com.poly.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kichCo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KichCoEntity extends SuperEntity {

    @Column(name = "tenKichCo", length = 120, nullable = false,columnDefinition = "NVARCHAR(255)")
    private String tenKichCo;
    @Column(name = "doDai", length = 150, nullable = false,columnDefinition = "NVARCHAR(255)")
    private String doDai;
    @JsonIgnore
    @OneToMany(mappedBy = "kichCo")
    @ToString.Exclude
    private List<SanPhamChiTietEntity> sanPhamChiTiets = new ArrayList<SanPhamChiTietEntity>();
}
