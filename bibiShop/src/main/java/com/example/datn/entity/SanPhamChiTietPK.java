package com.example.datn.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SanPhamChiTietPK implements Serializable {

    private Long sanPhamId;

    private Long sanPhamChiTietId;

    // Constructors, getters, setters
}
