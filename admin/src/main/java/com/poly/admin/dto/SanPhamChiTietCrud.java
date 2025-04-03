package com.poly.admin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamChiTietCrud extends SuperDTO {
    @NotNull(message = "Giá sản phẩm không được để trống")
    private BigDecimal giaSanPham;

    private int soLuong;

    private String trongLuong;

    private int gioiTinh;

    private String moTa;

    @JsonProperty("sanPhamId")
    private Integer sanPham;
    @JsonProperty("mauSacId")
    private Integer mauSac;
    @JsonProperty("kichCoId")
    private Integer kichCo;
    @JsonProperty("nsxId")
    private Integer nsx;
    @JsonProperty("chatLieuId")
    private Integer chatLieu;
    @JsonProperty("hinhAnhId")
    private Integer hinhAnh;
    @JsonProperty("danhMucId")
    private Integer danhMuc;
    @JsonProperty("baoHanhId")
    private Integer baoHanh;
    private int trangThai;
}
