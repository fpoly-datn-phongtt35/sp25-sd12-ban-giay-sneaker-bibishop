package com.poly.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SanPhamChiTietPK implements Serializable {

    private Long sanPhamId;

    private Long sanPhamChiTietId;

    // Constructors, getters, setters
}
