package com.poly.BibiShop.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DanhMucDTO extends SuperDTO {

    private String tenDanhMuc;
}
