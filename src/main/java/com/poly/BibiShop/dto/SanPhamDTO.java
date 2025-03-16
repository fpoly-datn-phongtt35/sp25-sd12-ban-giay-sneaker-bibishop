package com.poly.BibiShop.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamDTO extends SuperDTO{
    private String tenSanPham;
    private int trangThai;
}
