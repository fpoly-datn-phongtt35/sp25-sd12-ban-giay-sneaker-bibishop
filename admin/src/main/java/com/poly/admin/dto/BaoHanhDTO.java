package com.poly.admin.dto;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaoHanhDTO extends SuperDTO{
    private String ten;

    private String thoiHan;

    private int trangThai;
}
